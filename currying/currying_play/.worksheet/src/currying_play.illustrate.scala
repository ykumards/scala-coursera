package currying_play

object illustrate {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(290); 
  // Higher order functions take other functions as parameters or return values
  // Simplest is the map function
  def map_illus(f: Int => Int, in: List[Int]): List[Int] = {
  	if(in.isEmpty) List()
  	else f(in.head) :: map_illus(f, in.tail)
  };System.out.println("""map_illus: (f: Int => Int, in: List[Int])List[Int]""");$skip(143); 
  // Testing map_illus
  // We pass an ananymous function (x => x*x) which squares each element
  println (map_illus((x => x*x), List(1,2,3)));$skip(399); 
  
  // Now we can curry this function so the input parameters aren't tied together
  // Here, map_curr is a function that will return another function 'mapper'
  // All the calculation heavy-lifting is done by mapper
  def map_curr(f:Int => Int): (List[Int]) => List[Int] = {
  	def mapper(in: List[Int]): List[Int] =
  		if (in.isEmpty) List()
  		else f(in.head) :: mapper(in.tail)
  	mapper
  };System.out.println("""map_curr: (f: Int => Int)List[Int] => List[Int]""");$skip(155); 
  // We can test this new function to verify the results are consistent
  // Notice the difference in function call
  def square_mapper = map_curr(x=>x*x);System.out.println("""square_mapper: => List[Int] => List[Int]""");$skip(38); 
  println(square_mapper(List(1,2,3)));$skip(87); 
  
  // We can define a new function for cubing
  def cube_mapper = map_curr(x=>x*x*x);System.out.println("""cube_mapper: => List[Int] => List[Int]""");$skip(36); 
  println(cube_mapper(List(1,2,3)));$skip(104); 
  
  // Of course, this will work with anonymous functions too
  println(map_curr(x=>x*x)(List(1,2,3)));$skip(108); 
  
  // More examples with currying
  
  // 1. Curried Multiply
  def mult_curr(a: Int)(b:Int): Int = a * b;System.out.println("""mult_curr: (a: Int)(b: Int)Int""");$skip(57); 
  // Can be used all together
  println(mult_curr(3)(2));$skip(79); 
  // Or we can create a bunch of new functions
  def mult_by_3 = mult_curr(3)_;System.out.println("""mult_by_3: => Int => Int""");$skip(24); 
  println(mult_by_3(4))}
  
  //2. TODO
}
