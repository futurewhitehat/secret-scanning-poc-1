public class FirebaseConfigExample {
    private static final String FIREBASE_API_KEY = "${firebase_key}";
    private static final String AUTH_DOMAIN = "my-app.firebaseapp.com";
    private static final String DATABASE_URL = "https://my-app.firebaseio.com";

    public static void main(String[] args) {
        System.out.println("Firebase API Key: " + FIREBASE_API_KEY);
    }
}