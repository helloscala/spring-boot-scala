package me.yangbajing.springscala.controller

import java.util.concurrent.TimeUnit

import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, ResponseBody, RestController}

/**
  * Created by Yang Jing (yangbajing@gmail.com) on 2015-12-18.
  */
@RestController
@RequestMapping(Array("/api"))
class ApiController {

  @RequestMapping(value = Array("/hello"), method = Array(RequestMethod.GET))
  @ResponseBody
  def hello(): Message = {
    TimeUnit.SECONDS.sleep(6)
    val message = new Message()
    message.value = "Hello, Scala for Spring!"
    message
  }

}
