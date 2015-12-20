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

import java.util.concurrent.TimeUnit;

/**
 * Controller
 * Created by Yang Jing (yangbajing@gmail.com) on 2015-12-19.
 */
@RestController
public class Controller {
    private WSClient ws = new NingWSClient(new AsyncHttpClientConfig.Builder().build());

    @RequestMapping(value = "/qq", method = RequestMethod.GET)
    @ResponseBody
    public String qq() {
        long begin = System.currentTimeMillis();
        WSRequest client = ws.url("http://127.0.0.1:8080/api/hello");
        F.Promise<WSResponse> response = client
                .setRequestTimeout(TimeUnit.SECONDS.toMillis(10))
                .get();
        String body = response.get(20, TimeUnit.SECONDS).getBody();
        System.out.println((System.currentTimeMillis() - begin) + "  " + body);
        return body;
    }
}
