object a_WhatIsSideEffect extends App {

  /**
    * Side effect modifies some state variable value(s) outside its local environment,
    *  that is to say has an observable effect besides returning a value (the main effect)
    *  to the invoker of the operation
    */
  var v = 0

  def fun(i: Int) = v += i

  fun(v) // side effectful function
}
