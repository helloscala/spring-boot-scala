package me.yangbajing.springbootscala.web.controllers;

import me.yangbajing.springbootscala.data.domain.Message;
import me.yangbajing.springbootscala.data.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import scala.Some;

import java.util.Optional;

/**
 * Java WebController
 * Created by yangbajing on 16-8-24.
 */
@RestController
@RequestMapping("/web")
public class WebController {

    @RequestMapping(path = "message", method = RequestMethod.GET)
    public Message message(@RequestParam String name,
                           @RequestParam Optional<String> nickname) {
        User user = new User();
        user.setName(name);
        nickname.ifPresent(value -> user.setNickname(value));
        return new Message("Yang Jing", 30, user, new Some(false));
    }

}
