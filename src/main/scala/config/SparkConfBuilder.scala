package config

import org.apache.spark.SparkConf

object SparkConfBuilder {

  private val defConfig =
    Map("spark.app.name" -> "spark-poc",
        "spark.master" -> "local",
        "spark.driver.memory" -> "2g",
        "spark.default.parallelism" -> "4")

  lazy val defaultConfiguration: SparkConf = {
    new SparkConf().setAll(defConfig)
  }

}
