package me.yangbajing.springbootscala.web.controllers

import me.yangbajing.springbootscala.data.domain.{Message, User}
import org.springframework.web.bind.annotation.{RequestBody, RequestMapping, RequestMethod, RestController}

@RestController
@RequestMapping(Array("/api"))
class ApiController {

  @RequestMapping(path = Array("message"), method = Array(RequestMethod.POST))
  def message(@RequestBody reqMsg: Message): Seq[Message] = {
    List(
      reqMsg,
      reqMsg.copy(age = reqMsg.age + 1)
    )
  }

}
