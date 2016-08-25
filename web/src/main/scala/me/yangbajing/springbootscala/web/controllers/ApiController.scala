package me.yangbajing.springbootscala.web.controllers

import java.util.Optional

import me.yangbajing.springbootscala.data.domain.Message
import org.springframework.web.bind.annotation._

import scala.compat.java8.FunctionConverters._

@RestController
@RequestMapping(Array("/api"))
class ApiController {

  @RequestMapping(path = Array("message"), method = Array(RequestMethod.POST))
  def message(@RequestParam name: Optional[String],
              @RequestBody reqMsg: Message): Seq[Message] = {
    List(
      reqMsg,
      reqMsg.copy(age = reqMsg.age + 1, status = Some(true), name = name.orElseGet(asJavaSupplier(() => reqMsg.name)))
    )
  }

}
