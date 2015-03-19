import org.scalatest._

class ScenarioSpec extends UnitSpec {

  "A FullHouse" should "beat a Pair" in {
    val h1 = Hand(List("AC", "2D", "3H", "4S", "5H"))
    
    println(h1.compareTo(h1))

    
  }
}