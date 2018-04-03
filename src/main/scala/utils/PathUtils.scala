package utils

object PathUtils {

  lazy val base = System.getProperty("user.dir")
  lazy val default = base.concat("/datasets")

  lazy val products = default.concat("/catalog-data.csv")
  lazy val categories = default.concat("/categories.txt")


  lazy val result = base.concat("/result/")
}
