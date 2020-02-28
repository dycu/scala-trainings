object b_ProblemsWithSideEffects extends App {

  /**
    * 1. Equational reasoning
    * Pure functions give us the ability to use substitution model
    * (safely replace any expression in our program with the value that it evaluates)
    * as if program was a mathematical expression
    */
  var globalState = 0

  def fun(input: Int) = input + 1 // pure function
  val sideEfectfulFunction = { globalState = 2 } // we need to follow the external world while trying to understand it

  assert(fun(1) + fun(2) == 1 + 1 + 2 + 1)

  /**
    * 2. Testability
    * Side effectful free program is deterministic.
    * Pure function can be easily tested in separation.
    * Functions with side effects are separated by using proper return types.
    */

  /**
    * 3. Referential transparency
    * We can always assign a sub-expression to a variable and replace all occurrences
    * of the sub-expression with that variable. When we do this refactoring we can be
    * absolutely sure that the behavior of the program remains unchanged.
    */
  var total = 0

  def addToTotal(x: Int): Int = {
    total += x
    total
  }

  assert(addToTotal(1) == addToTotal(1))
}
