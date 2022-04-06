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
}




class Person(name: String) {
   def hello(): Unit ={
     println(s"$name say hello")
   }
}
