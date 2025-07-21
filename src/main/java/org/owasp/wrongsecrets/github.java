import okhttp3.*;

import java.io.IOException;

public class GitHubApiExample {

    // Replace with your GitHub personal access token
    private static final String GITHUB_TOKEN = "${git_token}";

    // Repository info: owner and repo name
    private static final String OWNER = "octocat";
    private static final String REPO = "Hello-World";

    private static final OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) {
        try {
            listIssues();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listIssues() throws IOException {
        String url = "https://api.github.com/repos/" + OWNER + "/" + REPO + "/issues";

        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", "token " + GITHUB_TOKEN)
                .header("Accept", "application/vnd.github.v3+json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String responseBody = response.body().string();
                System.out.println("Issues in repo " + OWNER + "/" + REPO + ":");
                System.out.println(responseBody);
            } else {
                System.err.println("Request failed: " + response.code() + " " + response.message());
                if (response.body() != null) {
                    System.err.println(response.body().string());
                }
            }
        }
    }
}
