package cn.socialcredits.medical.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.ning.http.client.AsyncHttpClientConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import play.libs.F;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;
import play.libs.ws.ning.NingWSClient;

/**
 * Created by Yang Jing (yangbajing@gmail.com) on 2015-12-19.
 */
@RestController
public class Controller {
    private WSClient ws = new NingWSClient(new AsyncHttpClientConfig.Builder().build());

    @RequestMapping(value = "/qq", method = RequestMethod.GET)
    @ResponseBody
    public String qq() {
        WSRequest client = ws.url("http://www.qq.com");
        F.Promise<WSResponse> f = client.get();
        f.map(resp -> {
            JsonNode jv = resp.asJson();
            return resp;
        });
        String body = client.get().get(10 * 1000).getBody();
        System.out.println(body);
        return body;
    }
}
