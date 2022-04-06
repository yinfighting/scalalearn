package com.maxchain.scalalearn.lesson04_highGrade


/**
 * @description:
 * @author: YHR
 * @date: Created in 2022/3/30 10:47
 * @version: ${VERSION}
 * @modified By:
 */
object Demo1 {

  def main(args: Array[String]): Unit = {
    // trait  可以被继承的类
    val p = new Person("张三")
    p.hello()
    p.say()
    p.ku()
    p.haiRen()
  }

}

trait God{
  def say(): Unit = {
    println("god...say")
  }
}

trait Mg{
  def ku(): Unit ={
    println("mg...say")
  }

  def haiRen(): Unit
}



class Person(name: String) extends God with Mg {
   def hello(): Unit ={
     println(s"$name say hello")
   }

  override def haiRen(): Unit = {
    println("ziji shixian")
  }

}
