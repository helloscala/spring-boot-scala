package me.yangbajing.springbootscala.web.controllers;

import me.yangbajing.springbootscala.data.domain.Message;
import me.yangbajing.springbootscala.data.domain.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Java WebController
 * Created by yangbajing on 16-8-24.
 */
@RestController
@RequestMapping("/web")
public class WebController {

    @RequestMapping(path = "message", method = RequestMethod.POST)
    public Message message(@RequestBody User user) {
        return new Message("Yang Jing", 30, user);
    }

}
