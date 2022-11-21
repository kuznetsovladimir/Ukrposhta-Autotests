package utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class CreateCounterparty {
    static ApiConstants constants = new ApiConstants();


    public static void main(String[] args) throws IOException {
        final String URL = "https://api.novaposhta.ua/v2.0/json/";
       // String id = "c983247e-36b7-11ed-a60f-48df37b921db";
        HttpPost createCounterParty = new HttpPost(URL);
        HttpEntity body = new StringEntity(String.valueOf(constants.counterpartyDataInitial()), "utf-8");
        createCounterParty.setEntity(body);
        HttpResponse response = HttpClientBuilder.create().build().execute(createCounterParty);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        System.out.println(result.substring(31, 69));
    }
}