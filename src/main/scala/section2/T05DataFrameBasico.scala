package section2

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{DoubleType, LongType, StringType, StructField, StructType}

object T05DataFrameBasico extends App {

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

  /**
   * A Spark schema structure that describes a small cars DataFrame.
   */
  val esquemaCarrosManual = StructType(Array(
    StructField("Name", StringType),
    StructField("Miles_per_Gallon", DoubleType),
    StructField("Cylinders", LongType),
    StructField("Displacement", DoubleType),
    StructField("Horsepower", LongType),
    StructField("Weight_in_lbs", LongType),
    StructField("Acceleration", DoubleType),
    StructField("Year", StringType),
    StructField("Origin", StringType)
  ))

  val carrosEsquemaInferido = miframe.schema

  println(carrosEsquemaInferido)

  val carrosConEsquema = spark.read
    .format("json")
    .schema(esquemaCarrosManual)
    .load("src/main/resources/data/carros.json")

  /**
   * A "manual" sequence of s describing cars, fetched from cars.json in the data folder.
   */
  val cars = Seq(
    ("chevrolet chevelle malibu", 18.0, 8L, 307.0, 130L, 3504L, 12.0, "1970-01-01", "USA"),
    ("buick skylark 320", 15.0, 8L, 350.0, 165L, 3693L, 11.5, "1970-01-01", "USA"),
    ("plymouth satellite", 18.0, 8L, 318.0, 150L, 3436L, 11.0, "1970-01-01", "USA"),
    ("amc rebel sst", 16.0, 8L, 304.0, 150L, 3433L, 12.0, "1970-01-01", "USA"),
    ("ford torino", 17.0, 8L, 302.0, 140L, 3449L, 10.5, "1970-01-01", "USA"),
    ("ford galaxie 500", 15.0, 8L, 429.0, 198L, 4341L, 10.0, "1970-01-01", "USA"),
    ("chevrolet impala", 14.0, 8L, 454.0, 220L, 4354L, 9.0, "1970-01-01", "USA"),
    ("plymouth fury iii", 14.0, 8L, 440.0, 215L, 4312L, 8.5, "1970-01-01", "USA"),
    ("pontiac catalina", 14.0, 8L, 455.0, 225L, 4425L, 10.0, "1970-01-01", "USA"),
    ("amc ambassador dpl", 15.0, 8L, 390.0, 190L, 3850L, 8.5, "1970-01-01", "USA")
  )


  val miRow: Row = Row("amc ambassador dpl", 15.0, 8L, 390.0, 190L, 3850L, 8.5, "1970-01-01", "USA")

  val carrosManuales = spark.createDataFrame(cars)

  import spark.implicits._

  val carrosmanualesConImplicit = cars.toDF("Name", "kilometro x litros", "cilindros", "Motor", "Caballos", "Peso", "Aceleracion", "fecha", "Pais")

  carrosManuales.printSchema()
  carrosmanualesConImplicit.printSchema()
}
