package section1

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.language.implicitConversions
import scala.util.Success

object T03ScalaRecap extends App {

  val boolean = false

  val unidad: Unit = println("...")

  //unidad

  class Animal

  class Perro extends Animal

  trait Carnivoro {
    def comer(animal: Animal): Unit
  }

  class Croc extends Animal with Carnivoro {
    override def comer(animal: Animal): Unit = println("CROC CRUNCH!")
  }

  object Croc

  object Carnivoro

  trait MiLista[A]

  private val incrementar: Int => Int = zx => zx + 1

  val x = incrementar(233)

  val lista = List(1, 2, 3).map(incrementar)

  private val desco: Any = 243

  val description: Unit = desco match {
    case 243 => println("he")
    case _ => println("no se ")
  }

  try {
    throw new NullPointerException("MAL !")
  } catch {
    case _: NullPointerException => println(" NPE!")
    case _ => println(" motor")
  }

  private val fx = Future {
    42
  }

  fx.onComplete {
    case Success(value) => println(s" OK $value")
  }

  println(fx.map(_.+(3)))

  /// funciones parciales

  val parcial: PartialFunction[Int, Int] = {
    case 1 => println("UNIT")
      1
    case 2 => println("DOS")
      2
    case _ => println("999")
      999
  }

  private def metodoImplicito(implicit x: Int)  = x + 42

  implicit val implicita: Int = 2

  private val implicitcall = metodoImplicito

  println(implicitcall)

  case class Persona(nombre : String) {
    def greet(): Unit = println(s"hola soy $nombre")
  }

  implicit def fromStr(nombre: String): Persona = Persona(nombre)

  "POPO".greet()



}
