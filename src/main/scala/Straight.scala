class Straight extends HandType {
  def evaluate(h: Hand): (Boolean, HandType, List[Int]) = {
    (h.isConsecutive, this, 4 :: h.sorted.map(_.value))
  }

  override def toString: String = {
    "Straight"
  }
}

object Straight {
  def apply(h: Hand): (Boolean, HandType, List[Int]) = (new Straight).evaluate(h)
}
