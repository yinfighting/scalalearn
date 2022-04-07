package com.maxchain.scalalearn.lesson04_highGrade

import java.util

/**
 * @description:
 * @author: YHR
 * @date: Created in 2022/3/30 10:47
 * @version: ${VERSION}
 * @modified By:
 */
object Demo5 {

  def main(args: Array[String]): Unit = {
    // 隐式转换:    方便不改变源码的情况下， 扩展方法
    val list = new util.LinkedList[Int]()
    list.add(1)
    list.add(2)
    list.add(3)
    //需求： 这是java的类，没有foreach方法，如果让java的List有foreach方法
    //list.foreach(println)

    //方法一；
    //    def foreach[T](list: util.LinkedList[T], f: T => Unit): Unit = {
    //      val iter: util.Iterator[T] = list.iterator()
    //      while (iter.hasNext)f(iter.next())
    //    }
    //    foreach(list,println)

    //方法二；
    //    val xx = new XXX(list)
    //    xx.foreach(println)

    //方法三；  隐式转换方法
    //    implicit def sfsfds[T](list:util.LinkedList[T]): XXX[T] = {
    //      new XXX[T](list)
    //    }
    //    list.foreach(println)  //必须先承认一件事情： list有foreach方法吗？  肯定没有的！  在java里肯定报错
    //这些代码最终交给的是scala编译器
    /*
      1. scala编译器发现list.foreach(println) 有bug
      2. 去寻找implicit  定义的方法，且方法的参数正好是list的类型！！！
      3. 编译期： 完成你曾经人类首先new XXX（list）   xx.foreach(prinlt) 这个过程         编译器帮你吧代码改写了
    */

    //方法四： 隐式转换类
    //    implicit class KKK[T](list:util.LinkedList[T]) {
    //      def foreach(f: T => Unit): Unit = {
    //        val iter: util.Iterator[T] = list.iterator()
    //        while (iter.hasNext)f(iter.next())
    //      }
    //    }
    //    list.foreach(println)

    //方法五： 隐式转换方法： 不同类型参数
    val list1 = new util.ArrayList[Int]()
    list1.add(1)
    list1.add(2)
    list1.add(4)

    implicit def sfsdfdfdffds[T](list: util.ArrayList[T]): RRR[T] = {
      val iter: util.Iterator[T] = list.iterator()
      new RRR[T](iter)
    }

    list1.foreach(println)

    // 事实证明： 用接口泛型也是可以的
    implicit def sfsdfdfdf1111111fds[T](list: util.List[T]): GGG[T] = {
      new GGG[T](list)
    }

    list.foreach(println)
    list1.foreach(println)


    //隐式转换字段
    implicit val ddddgww: String = "lisi"

    def ooxx(implicit name: String): Unit = {
      println(name)
    }
    ooxx

    implicit val wlgslel: Int = 199
    def ooxxx(implicit name: String, age: Int): Unit = {  //表示两个都是implicit类型
      println(s"name=$name,age=$age")
    }
    ooxxx

    def oooxxx(age: Int)(implicit name: String): Unit = {        //implicit必须在后
      println(s"name=$name,age=$age")
    }
    oooxxx(999)

  }

}


//class XXX[T](list:util.LinkedList[T]) {
//  def foreach(f: T => Unit): Unit = {
//    val iter: util.Iterator[T] = list.iterator()
//    while (iter.hasNext)f(iter.next())
//  }
//}

class RRR[T](iter: util.Iterator[T]) {
  def foreach(f: T => Unit): Unit = {
    while (iter.hasNext) f(iter.next())
  }
}

class GGG[T](list: util.List[T]) {
  def foreach(f: T => Unit): Unit = {
    val iter: util.Iterator[T] = list.iterator()
    while (iter.hasNext) f(iter.next())
  }
}
