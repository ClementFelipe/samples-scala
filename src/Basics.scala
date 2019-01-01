object Basics extends App {
  /*
  Variables and values
  */

  var variable = 123; // Variable - re-assignable
  val value:Int = 321; // Value - not re-assignable

  /*
  Expressions - Yields a value, has no side-effects
  */

  val sum = variable + value;

  val isEvenNumber: Any = if (sum % 2 == 0) "even" else "not even";

  /*
  Statements - May or may not yield a result, may cause side effects and be unreliable
  */

  println(sum);
  println(isEvenNumber);

  /*
  Functions
  */

  val numbers = Array(1, 2, 3, 4);

  // Pure function - injective, no side effects, reliable
  def sum(numbers: Array[Int]): Int = {
    var sum: Int = 0;

    for (number <- numbers) {
      sum += number;
    }

    return sum;
  }

  // Impure function - non reliable, may have side effects
  var random = new scala.util.Random;
  var randomInt = 0;

  def productByRandom(number: Int): Int = {
    randomInt = random.nextInt(10);

    return number * randomInt;
  }

  println(sum(numbers));
  println(productByRandom(5));

  /*
  Loops
  */

  // Imperative - Does something, no value yield
  val integers = 1 to 10;

  println("Even numbers")
  for (integer <- integers if integer % 2 == 0) {
    println(integer);
  }

  println("Even numbers larger than 5")
  for (
    integer <- integers
    if integer % 2 == 0
    if integer > 5
  ) println(integer);

  println("Numbers and letters combination");
  val letters = Array("a", "b");

  for {
    integer <- integers
    letter <- letters
    if integer % 2 == 0
    if integer > 5
  } println(integer + " -> " + letter);

  // Functional - Yields value
  val oddNumbers = for {
    integer <- integers
    letter <- letters
    if integer % 2 == 1
    if integer <= 5
  } yield integer + " -> " + letter;

  println("Odd numbers less than 6 combined with letters");
  for (oddNumber <- oddNumbers) println(oddNumber);
}
