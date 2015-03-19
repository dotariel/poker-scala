class Flush extends HandType {
  def evaluate(h: Hand): (Boolean, HandType, List[Int]) = {
    (h.isSameSuit, this, 5 :: h.sorted.map(_.value))
  }

  override def toString: String = {
    "Flush"
  }
}

object Flush {
  def apply(h: Hand): (Boolean, HandType, List[Int]) = (new Flush).evaluate(h)
}
