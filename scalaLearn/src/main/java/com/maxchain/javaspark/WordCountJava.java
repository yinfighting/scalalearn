package com.maxchain.javaspark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @description:
 * @author: YHR
 * @date: Created in 2022/4/7 13:44
 * @version:
 * @modified By:
 */
public class WordCountJava {

    public static void main(String[] args) {
        SparkConf conf = new SparkConf();
        conf.setAppName("java-wordcount");
        conf.setMaster("local");

        JavaSparkContext jsc = new JavaSparkContext(conf);
        JavaRDD<String> fileRDD = jsc.textFile("data/testdata.txt");

        JavaRDD<String> words = fileRDD.flatMap(new FlatMapFunction<String, String>() {
            public Iterator<String> call(String s) throws Exception {
                return Arrays.asList(s.split(" ")).iterator();
            }
        });

        JavaPairRDD<String, Integer> parirWord = words.mapToPair(new PairFunction<String, String, Integer>() {
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<String, Integer>(s, 1);
            }
        });

        JavaPairRDD<String, Integer> res = parirWord.reduceByKey(new Function2<Integer, Integer, Integer>() {
            public Integer call(Integer oldV, Integer v) throws Exception {
                return oldV + v;
            }
        });

        res.foreach(new VoidFunction<Tuple2<String, Integer>>() {
            public void call(Tuple2<String, Integer> stringIntegerTuple2) throws Exception {
                System.out.println(stringIntegerTuple2._1 + "\t" + stringIntegerTuple2._2);
            }
        });

    }
}
