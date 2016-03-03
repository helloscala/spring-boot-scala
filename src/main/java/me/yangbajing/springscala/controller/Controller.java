package me.yangbajing.springscala.controller;

import me.yangbajing.springscala.resource.JavaResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Controller
 * Created by Yang Jing (yangbajing@gmail.com) on 2015-12-19.
 */
@RestController
public class Controller {
    private final JavaResource javaResource;

    @Autowired
    public Controller(JavaResource javaResource) {
        this.javaResource = javaResource;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public DeferredResult<Message> hello() {
        DeferredResult<Message> result = new DeferredResult<>();
        javaResource.getHello()
                .addCallback(
                        resp -> result.setResult(resp.getBody()),
                        result::setErrorResult
                );

        return result;
    }
}
