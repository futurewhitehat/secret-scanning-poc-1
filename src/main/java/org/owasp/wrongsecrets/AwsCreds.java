public class AwsCredentialsExample {
    private static final String AWS_ACCESS_KEY = "${aws_key}";
    private static final String AWS_SECRET_KEY = "${aws_secret}";

    public static void main(String[] args) {
        System.out.println("AWS Access Key: " + AWS_ACCESS_KEY);
    }
}
