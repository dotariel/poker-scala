class HighCard extends HandType {
  def evaluate(h: Hand): (Boolean, HandType, List[Int]) = {
    (true, this, 0 :: h.sorted.map(_.value))
  }
  
  override def toString: String = "High Card"
}

object HighCard {
  def apply(h: Hand): (Boolean, HandType, List[Int]) = (new HighCard).evaluate(h)
}
