import scala.util.matching.Regex

class Card(card: String) {
  require(isValid(card), "Invalid card specification")

  def face: String = {
    card.substring(0,1)
  }

  def suit: String = {
    card.substring(1,2)
  }

  def value: Int = {
    Card.values(face)
  }

  override def toString: String = {
    card
  }

  private def isValid(card: String): Boolean = {
    new Regex("[2-9KTQJA]{1}[CDSH]{1}").findAllIn(card).length > 0
  }
}

object Card {
  def apply(cs: String): Card = new Card(cs)

  def suits: Seq[String] = List("C", "H", "D", "S")

  def values(key: String): Int = key match {
    case "2" => 2
    case "3" => 3
    case "4" => 4
    case "5" => 5
    case "6" => 6
    case "7" => 7
    case "8" => 8
    case "9" => 9
    case "T" => 10
    case "J" => 11
    case "Q" => 12
    case "K" => 13
    case "A" => 14
  } 
}