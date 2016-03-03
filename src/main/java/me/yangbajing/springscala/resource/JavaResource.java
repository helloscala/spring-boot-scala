package me.yangbajing.springscala.resource;

import me.yangbajing.springscala.controller.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;

/**
 * Created by Yang Jing (yangbajing@gmail.com) on 2016-03-03.
 */
@Service
public class JavaResource {

    private final AsyncRestTemplate asyncRestTemplate;

    @Autowired
    public JavaResource(AsyncRestTemplate asyncRestTemplate) {
        this.asyncRestTemplate = asyncRestTemplate;
    }

    @Async
    public ListenableFuture<ResponseEntity<Message>> getHello() {
        return asyncRestTemplate.getForEntity("http://127.0.0.1:8080/api/hello", Message.class);
    }

}
