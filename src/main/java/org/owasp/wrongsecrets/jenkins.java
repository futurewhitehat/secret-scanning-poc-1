public class JenkinsApiTokenExample {
    private static final String JENKINS_URL = "http://jenkins.example.com";
    private static final String USERNAME = "${jenkins_user}";
    private static final String API_TOKEN = "${jenkins_key}";

    public static void main(String[] args) {
        System.out.println("Connecting to Jenkins as " + USERNAME);
        // Example usage
        String authHeader = "Basic " + java.util.Base64.getEncoder()
                .encodeToString((USERNAME + ":" + API_TOKEN).getBytes());
        System.out.println("Authorization: " + authHeader);
    }
}
