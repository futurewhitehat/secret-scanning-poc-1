package org.owasp.wrongsecrets;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1)
public class HerokuWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requiresChannel()
            .requestMatchers(r -> r.getRequestURL().toString().contains("heroku") && (r.getHeader("x-forwarded-proto") != null || r.getHeader("X-Forwarded-Proto") != null))
            .requiresSecure();
    }
}
