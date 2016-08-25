package me.yangbajing.springbootscala.data.domain

import java.time.LocalDateTime

import scala.beans.BeanProperty

case class Message(name: String,
                   age: Int,
                   user: User,
                   status: Option[Boolean]) {
  @BeanProperty
  val createdAt: LocalDateTime = LocalDateTime.now()
}

