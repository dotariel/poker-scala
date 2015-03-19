class TwoPair extends HandType {
  def evaluate(h: Hand): (Boolean, HandType, List[Int]) = {
    def score: List[Int] = {
      val p: List[Int] = h.pairs.collect { case (a,b) => b.head.value }.toList
      val q: List[Int] = h.sorted.map(_.value).filter(!p.contains(_))

      List(2) ::: p ::: q ::: List(0,0)
    }

    (h.pairs.toList.length == 2, this, score)
  }

  override def toString: String = {
    "Two Pair"
  }
}

object TwoPair {
  def apply(h: Hand): (Boolean, HandType, List[Int]) = (new TwoPair).evaluate(h)
}
