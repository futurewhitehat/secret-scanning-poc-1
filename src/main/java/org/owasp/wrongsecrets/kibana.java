public class KibanaBasicAuthExample {
    private static final String KIBANA_URL = "https://kibana.example.com/api/saved_objects/_find";
    private static final String KIBANA_USERNAME = "${kibana_user}";
    private static final String KIBANA_PASSWORD = "${kibana_password}";

    public static void main(String[] args) {
        String credentials = KIBANA_USERNAME + ":" + KIBANA_PASSWORD;
        String basicAuth = "Basic " + java.util.Base64.getEncoder().encodeToString(credentials.getBytes());

        System.out.println("Authorization header: " + basicAuth);
        // Simulate sending request to Kibana
    }
}
