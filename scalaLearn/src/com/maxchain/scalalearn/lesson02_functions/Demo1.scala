package com.maxchain.scalalearn.lesson02_functions

import java.util.Date


/**
 * @description:
 * @author: YHR
 * @date: Created in 2022/3/30 10:47
 * @version: ${VERSION}
 * @modified By:
 */
object Demo1 {

  //函数    方法
  println("-------------basic--------------------")

  //返回值, 参数, 函数体
  def fun01(): Int = {
    println("hello world")
    return 3
  }

  //参数: 必须给定类型
  //class构造, 只能是val类型,不能变的
  def fun03(a: Int): Unit = {
    println(a)
  }

  //递归函数
  //递归先写触底! 触发什么报错
  def fun04(num: Int): Int = {
    if (num == 1) {
      num
    } else {
      num * fun04(num - 1)
    }
  }

  //默认值函数
  def fun05(a: Int = 88, b: String = "test"): Unit = {
    println(s"a=$a b=$b")
  }


  def main(args: Array[String]): Unit = {
    //返回值
    var y = fun01()
    println(y)

    //传参
    fun03(999)

    //递归
    println("递归")
    val i = fun04(5)
    println(i)

    //默认值函数
    fun05(b = "我要改变")

    //匿名函数
    //函数是第一类值
    //函数:
    // 1. 签名: (Int, Int) => Int : (参数类型列表) => 返回值类型
    // 2. 匿名函数: (a: Int, b: Int) => {a+b} : (参数实现列表) => 函数体
    var fun06: (Int, Int) => Int = (a: Int, b: Int) => {
      a + b
    }
    println(fun06(3, 4))

    //嵌套函数


    //偏应用函数
    def fun08(data: Date, level: String, msg: String): Unit = {
      println(s"data:$data\t level:$level\t msg:$msg")
    }

    var info = fun08(new Date(), "info", _: String)
    var error = fun08(new Date(), "error", _: String)
    info("这是info日志")
    error("这是error日志")

    //可变参数
    def fun09(a: Int*): Unit = {
      for (elem <- a) {
        print(s"$elem\t")
      }
      println()
      a.foreach((x) => {
        print(x * 2 + "\t")
      })
      println()
      a.foreach(print(_))
      println()
      a.foreach(print)
      println()
    }

    fun09(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)

    //高阶函数
    //函数作为参数
    def fun10(a: Int, b: Int, f: (Int, Int) => Int): Unit = {
      val resut = f(a, b)
      println(resut)
    }

    fun10(10, 9, (x, y) => {
      x + y
    })
    fun10(10, 9, (x, y) => {
      x - y
    })
    fun10(10, 9, (x, y) => {
      x * y
    })
    fun10(10, 9, (x, y) => {
      x / y
    })
    fun10(10, 9, _ * _)

    //函数作为返回值
    def facroty(i: String): (Int, Int) => Int = {
      if (i.equals("+")) {
        (x:Int, y:Int) => x + y
      }else if(i.equals("-")){
        (x:Int, y:Int) => x - y
      }else if(i.equals("*")){
        (x:Int, y:Int) => x * y
      }else {
        (x:Int, y:Int) => x / y
      }
    }
    fun10(3,4,facroty("*"))

    //柯里化
    def fun11(a:Int)(b:Int)(c:String): Unit ={
      println(s"$a\t$b\t$c")
    }
    fun11(3)(8)("rrrr")

    //方法不想执行，赋值一个变量引用    方法名+空格+下划线
    val funvar = fun01 _
    funvar()

    //java中 + 是一个关键字
    //scala中 + 是一个方法/函数
    //3 =2   《==》 3.+(2)
    //scala语法中，没有基本类型， 所以你写一个数字 3   编辑器/语法， 其实是把3看待成Int这个对象
    //编译器，衔接 人 和 机器
    //java：解释型， 编译过程， 类型  比python快
    //jvm 为什么值钱， 是c写的，【字节码（二进制）> jvm（堆/堆外（二进制）） < kernel（mmap， dendfile）】 更快！



  }

}
