import cats.effect._
import cats.syntax.all._

object d_IOApp extends IOApp {

  /**
    * To avoid manually run IO we can delegate it to the runtime.
    */
  val program = IO { println("Hello world") }

  def run(args: List[String]): IO[ExitCode] = {
    program *> IO { ExitCode.Success }
  }
}
