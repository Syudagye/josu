package fr.syudagye.josu;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fr.syudagye.josu.model.Beatmap;
import fr.syudagye.josu.requests.Requester;
import fr.syudagye.josu.requests.Route;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class DefaultOsuClient implements OsuClient{

    public static final Logger LOGGER = LoggerFactory.getLogger(OsuClient.class);

    protected static Requester requester = new Requester();

    private String token;
    private int tokenTimeout;

    public DefaultOsuClient(String token, int tokenTimeout)
    {
        this.token = token;
        this.tokenTimeout = tokenTimeout;

    }

    public static DefaultOsuClient create(String cliendId, String clienSecret)
    {
        LOGGER.info(String.format("Retrieving token with client credentials from osu.ppy.sh"));

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode body= mapper.createObjectNode();
        body.put("client_id", cliendId);
        body.put("client_secret", clienSecret);
        body.put("grant_type", "client_credentials");
        body.put("scope", "public");

        Request request = new Request.Builder()
                .url("https://osu.ppy.sh/oauth/token")
                .post(RequestBody.create(
                        body.toString(),
                        MediaType.get("appliation/json")
                ))
                .build();

        try {
            Response response = Requester.httpClient.newCall(request).execute();
            String resBody = response.body().string();
            DefaultTokenObject tokenObject = new JsonMapper().readValue(resBody, DefaultTokenObject.class);

            return new DefaultOsuClient(tokenObject.getAccessToken(), tokenObject.getExpiresIn());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Beatmap getBeatmap(String beatmapId) {
        return requester.requestApi(Route.Beatmaps.GET_BEATMAP.compile(beatmapId), token, Beatmap.class);
    }

    @JsonIgnoreProperties({"token_type"})
    public static class DefaultTokenObject {

        @JsonProperty("access_token")
        private String accessToken;
        @JsonProperty("expires_in")
        private int expiresIn;

        public String getAccessToken() {
            return accessToken;
        }

        public int getExpiresIn() {
            return expiresIn;
        }
    }

}
