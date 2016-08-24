package me.yangbajing.springbootscala.data.domain

import me.yangbajing.springbootscala.common.Utils

import scala.beans.BeanProperty

case class Message(name: String, age: Int) {
  @BeanProperty
  val sign: String = Utils.randomString(16)
}

