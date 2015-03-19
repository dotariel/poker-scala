class StraightFlush extends HandType {
  def evaluate(h: Hand): (Boolean, HandType, List[Int]) = {

    def matches: Boolean = {
      h.isConsecutive && h.isSameSuit
    }

    (matches, this, 8 :: h.sorted.map(_.value))
  }

  override def toString: String = {
    "Straight Flush"
  }
}

object StraightFlush {
  def apply(h: Hand): (Boolean, HandType, List[Int]) = (new StraightFlush).evaluate(h)
}
