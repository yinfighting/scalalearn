package com.maxchain.scalalearn.lesson04_highGrade

/**
 * @description:
 * @author: YHR
 * @date: Created in 2022/3/30 10:47
 * @version: ${VERSION}
 * @modified By:
 */
object Demo2 {

  def main(args: Array[String]): Unit = {
    // case  比较类时可以用
    val dog1 = Dog("hsq", 18)
    val dog2 = Dog("hsq", 18)
    println(dog1.equals(dog2))
    println(dog1 == dog2)

  }

}

case class Dog(name: String, age: Int) {

}


