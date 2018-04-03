package app

import config.SparkConfBuilder
import jobs.{CategorizationJob}
import org.apache.spark.SparkContext

object Main {

  def main(args: Array[String]): Unit = {

    val sc = new SparkContext(SparkConfBuilder.defaultConfiguration)

    val job = CategorizationJob(sc)

    job.execute()

  }

}
