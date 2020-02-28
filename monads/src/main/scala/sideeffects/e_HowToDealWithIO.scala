import cats.effect.IO
import cats.implicits._

object e_HowToDealWithIO extends App {

  /**
   * Values can be "lifted" into IO.
   */
  val liftedValue = IO.pure(1)
  val dontDoThis = IO.pure(println("Test")) // this will run sideffect as it's eagerly evaluated

  /**
    * Value inside a IO monad can be modified.
    */
  val mapping = IO { 1 }
  println(mapping.map(before => before + 1).unsafeRunSync)

  /**
    * IO is a Monad. Multiple instances can be joined by using flatMap.
    */
  val firstProgram = IO { println("Hello") }
  val secondProgram = IO { println("world") }

  firstProgram.flatMap(_ => secondProgram).unsafeRunSync()

  /**
    * For better readability we can use for-comprehension.
    */
  (for {
    _ <- firstProgram
    _ <- secondProgram
  } yield ()).unsafeRunSync

  /**
    * Monad stack may be flattened.
    */
  val program = IO { IO { println("same io stack") } }

  program.flatten.unsafeRunSync
}
