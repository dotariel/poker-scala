class ThreeOfAKind extends HandType {
  def evaluate(h: Hand): (Boolean, HandType, List[Int]) = {
    def score: List[Int] = {
      val p: List[Int] = h.trips.collect { case (a,b) => b.head.value }.toList
      val q: List[Int] = h.sorted.map(_.value).filter(!p.contains(_))

      List(3) ::: p ::: q ::: List(0,0)
    }

    (h.trips.toList.length == 1, this, score)
  }

  override def toString: String = {
    "Three of a Kind"
  }
}

object ThreeOfAKind {
  def apply(h: Hand): (Boolean, HandType, List[Int]) = (new ThreeOfAKind).evaluate(h)
}
