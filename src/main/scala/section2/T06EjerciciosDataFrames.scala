package section2

import org.apache.spark.sql.SparkSession

object T06EjerciciosDataFrames extends App {
  val spark = SparkSession.builder()

    .appName("T05DataFrameBasico")

    .config("spark.master", "local")

    .getOrCreate()



  val celulares = Seq(
    ("Nokia", "3310", "Android", 0),
    ("Samsung", "Galaxy", "Android", 32),
    ("Apple", "Iphone", "IOS", 64)
  )


  import spark.implicits._
  val celularDataFrame = celulares.toDF("Fabricante", "Modelo", "Sistema Operativo", "Memoria")

  celularDataFrame.show()




}
