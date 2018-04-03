package model

case class Product(sku: String,
                   price: Double,
                   name: String,
                   brand: String,
                   `type`: String,
                   categories: Seq[String],
                   img: Option[String] = None)
