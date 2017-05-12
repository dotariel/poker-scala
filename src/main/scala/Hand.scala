import Ordering.Implicits._

class Hand(val cards: List[Card]) {
  require(isValid, "Invalid hand specification")

  def sorted: List[Card] = this.cards.sortWith(_.value > _.value)

  def compareTo(that: Hand): (Option[Hand], Option[HandType], String) = {
    def eval(h: Hand): (Hand, HandType, List[Int]) = {
      HandTypes.all.collect { case t => t.evaluate(h) }.find { case (b,t,s) => b } match {
          case None    => throw new Error("This shouldn't have happened!")
          case Some(v) => (h, v._2, v._3)
        }
    }

    def compare(a: (Hand, HandType, List[Int]), b: (Hand, HandType, List[Int])): Option[(Hand, HandType)] = {
      (a._3 > b._3, b._3 > a._3) match {
        case (true, false) => Some((a._1, a._2))
        case (false, true) => Some((b._1, b._2))
        case _ => None
      }
    }

    compare(eval(this), eval(that)) match {
      case Some(v)  => (Option(v._1), Option(v._2), s"Winner: ${v._1} (${v._2})")
      case None     => (None, None, s"Tie (${eval(this)._2})")
    }
  }

  def pairs = group(2)
  def trips = group(3)
  def quads = group(4)

  def isSameSuit: Boolean = {
    cards.groupBy(_.suit).toList.length == 1
  }

  def isConsecutive: Boolean = {
    def get(swap: Boolean): List[Int] = swap match {
      case false  => sorted.map(_.value)
      case true   => get(false).map { case 14 => 1; case x => x }.sortWith(_ > _)
    }

    val a: List[Int] = get(false)
    val b: List[Int] = get(true)
    
    (a.max to a.min by -1).toList == a || (b.max to b.min by -1).toList == b
  }

  override def toString: String = {
    cards.map(_.toString).mkString(" ")
  }

  private def group(n: Int): Map[String, List[Card]] = {
    this.cards.groupBy(_.face).filter { case (a,b) => b.length == n }
  }

  private def isValid: Boolean = {
    cards.length == 5
  }
}

object Hand {
  def apply(cards: List[String]): Hand = {
    val c = cards.collect { case s: String => new Card(s) }
    new Hand(c)
  }
}
