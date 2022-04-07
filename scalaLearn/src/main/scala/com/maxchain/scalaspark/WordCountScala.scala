package com.maxchain.scalaspark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @description: 开发spark程序
 * @author: YHR
 * @date: Created in 2022/4/7 11:43
 * @version: ${VERSION}
 * @modified By:
 */
object WordCountScala {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setAppName("wordcount")
    conf.setMaster("local") //单机本地运行

    val sc = new SparkContext(conf)
    //单词统计
    //DATASET
    val fileRDD: RDD[String] = sc.textFile("data/testdata.txt")
    //分割成单个单词
    val words: RDD[String] = fileRDD.flatMap((x: String) => x.split(" "))
    //把单个单词组成map形式
    val pairWord: RDD[(String, Int)] = words.map((x: String) => new Tuple2(x, 1))
    //计算出现重复时,相加
    val res: RDD[(String, Int)] = pairWord.reduceByKey((x: Int, y: Int) => {
      x + y
    })
    //遍历, 只有遍历才真正执行
    res.foreach(println)

    //优化 上面的代码可优化成下面的一行
    fileRDD.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).foreach(println)

  }

}
