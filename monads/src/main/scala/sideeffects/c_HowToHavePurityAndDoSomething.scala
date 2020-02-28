import cats.effect.IO

object c_HowToHavePurityAndDoSomething extends App {

  /**
    * Pure functions are great but program with only pure functions doesn't
    * do anything useful. It can't communicate with the outside world,
    * because any external change is side-effectful.
    *
    * Solution: Treat side effects as values.
    */
  var state = 0

  def pureFunctionWithSideEffect(i: Int): IO[Int] = IO {
    state += i
    state
  }

  /**
    * Running function does nothing. To execute it we need to explicitly say so.
    */
  println(pureFunctionWithSideEffect(1))
  println(pureFunctionWithSideEffect(1).unsafeRunSync)
}
