package section2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{LongType, StringType, StructField, StructType}

object T05DataFrameBasico extends App{

  // crear sesion
  val spark = SparkSession.builder()
    .appName("T05DataFrameBasico")
    .config("spark.master", "local")
    .getOrCreate()

  // leer dataframe
  val miframe = spark.read
    .format("json")
    .option("inferSchema", value = true)
    .load("src/main/resources/data/carros.json")

  // mostrar dataframe
  miframe.show

  miframe.printSchema()

  miframe.take(10).foreach(println)

  val tipoLargo = LongType

  val esquemaCarros = StructType(
    Array(
      StructField("Name", StringType, nullable = false)
    )
  )


}
