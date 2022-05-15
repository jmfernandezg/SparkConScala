package section1

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.Success

object T03ScalaRecap extends App {

  val boolean = false

  val unidad: Unit = println("CACA")

  //unidad

  class Animal

  class Perro extends Animal

  trait Carnivoro {
    def comer(animal: Animal)
  }

  class Croc extends Animal with Carnivoro {
    override def comer(animal: Animal): Unit = println("CROC CRUNCH!")
  }

  object Croc

  object Carnivoro

  trait MiLista[A]

  val incrementar: (Int) => Int = zx => zx + 1

  val x = incrementar(233)

  val lista = List(1, 2, 3).map(incrementar)

  val desco: Any = 243

  val description = desco match {
    case 243 => println("he")
    case _ => println("no se ")
  }

  try {
    throw new NullPointerException("MAL !")
  } catch {
    case e: NullPointerException => println(" NPE!")
    case _ => println(" otor")
  }

  val fx = Future {
    42
  }

  fx.onComplete {
    case Success(value) => println(s" OK $value")
  }

  println(fx.map(_.+(3)))

  /// funciones parciales

  val parcial: PartialFunction[Int, Int] = {
    case 1 => println("UNIO")
      1
    case 2 => println("DOS")
      2
    case _ => println("999")
      999
  }

  def metodoImplicitod(implicit x: Int)  = x + 42

  implicit val implicita: Int = 2

  val implicitcall = metodoImplicitod

  println(implicitcall)

  case class Persona(nombre : String) {
    def greet(): Unit = println(s"hola soy $nombre")
  }

  implicit def fromStr(nombre: String): Persona = Persona(nombre)

  "POPO".greet()



}
