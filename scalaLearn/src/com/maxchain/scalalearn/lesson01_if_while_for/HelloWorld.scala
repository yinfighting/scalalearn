package com.maxchain.scalalearn.lesson01_if_while_for

/**
 * @description:  主方法只能写在object文件中
 *              object和class区别: object类似于java static , class就是java中纯粹的没有statuc关键字的类
 *              java中类名和文件名必须一样, 但是scala中可以不一样,没有必然关系, scala是包级别区分
 * @author: YHR
 * @date: Created in 2022/3/29 17:51
 * @version: ${VERSION}
 * @modified By:
 */
object HelloWorld01 {
  println("process start")

  //var: 变量
  var a = 1
  //val:常量
  val b = 4

  def main(args: Array[String]): Unit = {
    println("hello world")   //与go一样,不用写 ;
  }

  println("process end")

}

class HelloWorld01 {

  var a =3

  def printMsg(): Unit = {

  }

}

