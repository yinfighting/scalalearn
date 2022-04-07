package com.maxchain.scalalearn.lesson04_highGrade

/**
 * @description:
 * @author: YHR
 * @date: Created in 2022/3/30 10:47
 * @version: ${VERSION}
 * @modified By:
 */
object Demo3 {

  def main(args: Array[String]): Unit = {
    // match   类似于java的switch
    val tuple: (Double, Int, String, Boolean, Int) = (1.0, 88, "abc", false, 99)
    val iter: Iterator[Any] = tuple.productIterator
    val res = iter.map(x => {
      x match {
        case 1 => println(s"$x...这是一个1")
        case 88 => println(s"$x。。。这是88")
        case false => println("这是boolean类型")
        case w: Int if w > 50 => println(s"$w。。。这个数大于50")
        case _ => println("wo ye bu zhi dao shen me yi si ")
      }
    })

    while (res.hasNext) {println(res.next())}

  }

}



