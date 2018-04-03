package jobs

import model.Product
import org.apache.spark.SparkContext
import utils.PathUtils

import scala.util.Try

case class CategorizationJob(sc: SparkContext) {

  def execute() = {

    val catHeader = "name"
    val prodHeader =
      "\"sku\";\"price\";\"name\";\"brand\";\"type\";\"categories\";\"product_image_url\""

    val categories = sc.textFile(PathUtils.categories).filter(_ != catHeader)

    val products = sc
      .textFile(PathUtils.products)
      .flatMap { l =>
        val attributes = l.split(';').map(_.replace("\"", ""))
        if (attributes.length < 5 || l == prodHeader)
          Nil
        else {

          val wprice = Try(attributes(1).toDouble)

          if (wprice.isFailure)
            Nil
          else {

            val price = wprice.get
            val id = attributes(0)
            val name = attributes(2)
            val brand = attributes(3)
            val typ = attributes(4)
            val categories = attributes(5).split(',').toList
            val imageUrl = Try(attributes(6)).toOption

            Array(Product(id, price, name, brand, typ, categories, imageUrl))

          }
        }

      }

    println(products.count())

  }

}
