import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;

import java.io.IOException;

public class SlackBotExample {

    // Replace with your Bot User OAuth Token (xoxb-...)
    private static final String BOT_TOKEN = "${slack_bot}";

    // Replace with the channel ID where you want to send a message
    private static final String CHANNEL_ID = "C01234567";

    public static void main(String[] args) {
        Slack slack = Slack.getInstance();

        try {
            ChatPostMessageResponse response = slack.methods(BOT_TOKEN).chatPostMessage(req -> req
                .channel(CHANNEL_ID)
                .text("Hello from my Java Slack bot!"));

            if (response.isOk()) {
                System.out.println("Message sent successfully to channel: " + CHANNEL_ID);
            } else {
                System.err.println("Error sending message: " + response.getError());
            }

        } catch (IOException | SlackApiException e) {
            e.printStackTrace();
        }
    }
}
