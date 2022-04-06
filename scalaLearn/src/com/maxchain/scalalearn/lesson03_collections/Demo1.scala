package com.maxchain.scalalearn.lesson03_collections

import java.util

import scala.collection.mutable
import scala.collection.mutable.ListBuffer


/**
 * @description:
 * @author: YHR
 * @date: Created in 2022/3/30 10:47
 * @version: ${VERSION}
 * @modified By:
 */
object Demo1 {

  def main(args: Array[String]): Unit = {

    //可以用java的collections
    val listJava = new util.LinkedList[String]()
    listJava.add("hello")
    println(listJava)

    //scala还有自己的collections
    //1. 数组
    //java中泛型是<> scala中是[], 所以数组用(n)
    val arr01 = Array[Int](1, 2, 3, 4)
    println(arr01(0))
    for (elem <- arr01) {
      print(s"$elem\t")
    }
    println()
    arr01.foreach(print)
    println("-----------------数组结束-----------------------------")

    //List
    val list01 = List(1, 3, 5, 7) //默认不可变
    list01.foreach(print)
    println("-----------------List结束-----------------------------")
    val list02 = ListBuffer[Int]() //可变list
    list02.+=(10)
    list02.+=(20)
    list02.+=(30)
    list02.+=(40)
    //TODO: 学习  scala数据集中的++ += ++:  :++
    list02.foreach(print)
    println("-----------------List可变结束-----------------------------")

    //Set
    val set01 = Set(1, 2, 3, 4, 5, 6, 7, 7)
    set01.foreach(print)
    println("-----------------Set不可变结束-----------------------------")
    val set02 = scala.collection.mutable.Set(2, 3, 4)
    set02.add(5)
    set02.add(6)
    set02.add(6)
    set02.foreach(print)
    println("-----------------Set可变结束-----------------------------")

    //tuple 共有tuple1-22,可以放任何类型  tuple2就是java的map
    val tuple03 = Tuple4((a: Int, b: Int) => a + b * 2, (a: Int) => a, "aa", 33)
    println(s"1: ${tuple03._1},   2: ${tuple03._2},   3: ${tuple03._3},   4: ${tuple03._4}")
    println(tuple03._1(1, 2))
    //迭代器
    val iterator = tuple03.productIterator
    while (iterator.hasNext) {
      println(iterator.next())
    }
    println("-----------------tuple结束-----------------------------")

    //Map
    val map01 = Map(("a", 1), ("b", 2), ("c", 3), ("a", 4), "d" -> 5)
    println(map01)
    println(map01.get("d").get) // option: none  some
    println(map01.get("w").getOrElse("没有值")) // option: none  some
    map01.foreach(print)
    val keys = map01.keys
    for (elem <- keys) {
      println(map01.get(elem).get)
    }
    println("-----------------Map结束-----------------------------")
    val map02: mutable.Map[String, Int] = scala.collection.mutable.Map()
    map02.put("aa", 11)
    map02.put("bb", 12)
    map02.put("cc", 13)
    println(map02)
    println("-----------------可变Map结束-----------------------------")

    //不可变的意义
    println("-----------------艺术-----------------------------")
    val list03 = list01.map((x: Int) => x + 10)
    println(list03)
    val list04 = list01.map(_ * 10)
    println(list04)
    val listStr = List(
      "hello world",
      "hello scala",
      "hello golang"
    )
    val list05 = listStr.flatMap(_.split(" "))
    println(list05)
    val list06 = list05.map((_, 1))
    println(list06)
    //以上代码有什么问题吗?   内存扩大了N倍, 每一步计算都留有对象数据, 有什么线程的技术能解决数据计算中间状态占用内存这一问题?
    println("-----------------艺术再升华-----------------------------")
    val iter: Iterator[String] = listStr.iterator
    val iterlist05 = iter.flatMap(_.split(" "))
    iterlist05.foreach(println)
    val iterlist06 = iterlist05.map((_, 1))
    iterlist06.foreach(println) //这一行没打印, 是因为上一个for循环指针已经指到末尾了
    //基于迭代器的源码分析
    //1. listStr是真正的数据集,有数据的
    //2. iter.flatMap 没有发生计算, 返回一个新的迭代器
    //3. iterlist05.map 又返回一个迭代器
    println("-----------------不可变的意义结束-----------------------------")

  }


}
