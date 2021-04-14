package fr.syudagye.josu.requests;

import com.fasterxml.jackson.databind.json.JsonMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Requester{

    public static final String OSU_ENDPOINT = "https://osu.ppy.sh/api/v2/";
    public static final Logger LOGGER = LoggerFactory.getLogger(Requester.class);

    public static OkHttpClient httpClient = new OkHttpClient();

    public <T> T requestApi(String compiledRoute, String token, Class<T> tClass)
    {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(OSU_ENDPOINT + compiledRoute)
                .addHeader("Authorization", "Bearer " + token)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String body = response.body().string();
            LOGGER.debug(body);
            return new JsonMapper().readValue(body, tClass);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
