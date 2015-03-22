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
    Card.value(face)
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

  val suits: List[String] = 
    List("C", "H", "D", "S")

  val faces: List[String] = 
    (2 to 9).map(_.toString).toList ::: List("T", "J", "Q", "K", "A")

  def value(key: String): Int = {
    values.find(v => v._1 == key).get._2
  }

  private val values: List[(String, Int)] = List(
    ("2", 2),
    ("3", 3),
    ("4", 4),
    ("5", 5),
    ("6", 6),
    ("7", 7),
    ("8", 8),
    ("9", 9),
    ("T", 10),
    ("J", 11),
    ("Q", 12),
    ("K", 13),
    ("A", 14)
  )
}