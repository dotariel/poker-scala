import org.scalatest._

class ScenarioSpec extends UnitSpec {

  /*
  Input: Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C AH Output: White wins - high card: Ace
  Input: Black: 2H 4S 4C 2D 4H White: 2S 8S AS QS 3S Output: Black wins - full house
  Input: Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C KH Output: Black wins - high card: 9
  Input: Black: 2H 3D 5S 9C KD White: 2D 3H 5C 9S KH Output: Tie
  */

  "A HighCard" should "beat a lesser HighCard" in {
    val black = Hand(List("2H", "3D", "5S", "9C", "KD"))
    val white = Hand(List("2C", "3H", "4S", "8C", "AH"))
    
    val result = black compareTo white

    assert(result._1.get == white)
    assert(result._2.get.isInstanceOf[HighCard] )
  }

  "A FullHouse" should "beat HighCard" in {
    val black = Hand(List("2H", "4S", "4C", "2D", "4H"))
    val white = Hand(List("2S", "8S", "AS", "QS", "3S"))
    
    val result = black compareTo white

    assert(result._1.get == black)
    assert(result._2.get.isInstanceOf[FullHouse] )
  }

  "A HighCard" should "beat a lesser HighCard with kicker problems" in {
    val black = Hand(List("2H", "3D", "5S", "9C", "KD"))
    val white = Hand(List("2C", "3H", "4S", "8C", "KH"))
    
    val result = black compareTo white

    assert(result._1.get == black)
    assert(result._2.get.isInstanceOf[HighCard] )
  }

  "A HighCard" should "tie and equal HighCard" in {
    val black = Hand(List("2H", "3D", "5S", "9C", "KD"))
    val white = Hand(List("2H", "3D", "5S", "9C", "KD"))
    
    val result = black compareTo white

    assert(result._1 == None)
    assert(result._2 == None )
  }
}