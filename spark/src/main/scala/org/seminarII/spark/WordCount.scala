package org.seminarII.spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object WordCount {
   
def main (args: Array[String]): Unit = {
    val conf = new SparkConf()
    .setAppName("WordCount")
    .setMaster("local")
    val sc = new SparkContext(conf)
    
    val test = sc textFile "foo.txt"
    test.flatMap {line => 
      line.split(" ")
    }
    .map{ word =>
      (word,1)      
    }
    .reduceByKey(_ + _)
    .saveAsTextFile("foo.Count.txt")
    
    
  }
}