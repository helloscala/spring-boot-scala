package me.yangbajing.springbootscala.web.controllers

import me.yangbajing.springbootscala.data.domain.Message
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RestController}

@RestController
@RequestMapping(Array("/api"))
class ApiController {

  @RequestMapping(path = Array("message"), method = Array(RequestMethod.GET))
  def message(): Message = {
    Message("Yang Jing", 30)
  }

}
