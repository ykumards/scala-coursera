package currying_play
/*
From Scala by Example: http://www.scala-lang.org/docu/files/ScalaByExample.pdf
*/

object fixed_point {
  // given a function f(.), x is its fixed point if f(x) = x
  // we can find this iteratively if x, f(x), f(f(x)),... converges to x
  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  def isCloseEnough(x: Double, y:Double) = Math.abs((x - y)/x) < tolerance
                                                  //> isCloseEnough: (x: Double, y: Double)Boolean
  
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
  	def iterate(guess: Double): Double = {
  		val next = f(guess)
  		if (isCloseEnough(guess, next)) next
  		else iterate(next)
  	}
  	iterate(firstGuess) //initialize
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
  
  // Can use this to obtain sqrt(x). Find a solution for g(y) = x/y
  
  //def sqrt(x: Double) = fixedPoint(y => x / y)(1.0)
  
  // Run for sqrt(2) Doesn't converge since the guess oscillates between 1 and 2
  //sqrt(2)
  
  // By changing the function we can get it to converge
  def sqrt(x: Double) = fixedPoint(y => (y + x/y)/2)(1.0)
                                                  //> sqrt: (x: Double)Double
  // Things work now
  sqrt(2.0)                                       //> res0: Double = 1.4142135623746899
  
}