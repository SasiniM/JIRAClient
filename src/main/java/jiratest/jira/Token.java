package jiratest.jira;

import com.google.api.client.auth.oauth.OAuthCredentialsResponse;
import jiratest.token.JiraOAuthClient;
import jiratest.token.PropertiesClient;

import java.util.Map;

import static jiratest.token.PropertiesClient.ACCESS_TOKEN;
import static jiratest.token.PropertiesClient.CONSUMER_KEY;
import static jiratest.token.PropertiesClient.PRIVATE_KEY;
import static jiratest.token.PropertiesClient.REQUEST_TOKEN;
import static jiratest.token.PropertiesClient.SECRET;

public class Token {

    public void generateToken() throws Exception{
        PropertiesClient propertiesClient = new PropertiesClient();
        JiraOAuthClient jiraOAuthClient = new JiraOAuthClient(propertiesClient);

        Map<String, String> properties = propertiesClient.getPropertiesOrDefaults();

        String requestToken = jiraOAuthClient.getAndAuthorizeTemporaryToken(properties.get(CONSUMER_KEY), properties.get(PRIVATE_KEY));
        properties.put(REQUEST_TOKEN, requestToken);
        properties.put(SECRET, "Yljl6M");

        String tmpToken = properties.get(REQUEST_TOKEN);

        propertiesClient.savePropertiesToFile(properties);

        String accessToken = jiraOAuthClient.getAccessToken(tmpToken, properties.get(SECRET), properties.get(CONSUMER_KEY), properties.get(PRIVATE_KEY));
        properties.put(ACCESS_TOKEN, accessToken);
        propertiesClient.savePropertiesToFile(properties);

    }
}
