object Main { 
  def main(args: Array[String]): Unit = {
    println("Simple Poker Hand Evaluator")
    println("=======================================")
    println("")
    println("Instructions:")
    println(" - Enter each hand in the following format:")
    println("    {V}{S} {V}{S} {V}{S} {V}{S} {V}{S}")
    println("     Suits: C=Clubs, H=Hearts, S=Spades, D=Diamonds")
    println("     Values: 2,3,4,5,6,7,8,9,T,J,Q,K,A")
    println("  - Example:")
    println("     AC 2D TH 3S 5D")
    println("")

    val a: String = System.console().readLine("Black: ")
    val b: String = System.console().readLine("White: ")

    val h1: Hand = Hand(a.split(" ").toList)
    val h2: Hand = Hand(b.split(" ").toList)

    println(h1.compareTo(h2)._3)
  }
}
