import scala.util.Random
 
object rollingDice extends App {
  val diceNum = 3   //  number of your dices
  val dices = (1 to diceNum).map(_ => unbalancedDice()).toList
  printOutcome(dices, 0, 1)
   
  def unbalancedDice () : List[Double] = { 
    var dices = List[Double]()
    var sum = 0.0
    for ( i <- 1 to 6) {
      val ran = Random.nextDouble()
      sum += ran
      dices = ran :: dices
    }
    dices.map( x => x / sum)
  }
 
  def printOutcome(dices : List[List[Double]], diceIndex: Int, prob: Double): Unit = {
    for (i <- 0 to 5) {
      if (diceIndex == diceNum - 1)
        println(prob * dices(diceIndex)(i))
      else
        printOutcome(dices, diceIndex + 1, prob * dices(diceIndex)(i))
    }
  }
}
