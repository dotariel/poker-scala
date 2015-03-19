class FourOfAKind extends HandType {
  def evaluate(h: Hand): (Boolean, HandType, List[Int]) = {
    def score: List[Int] = {
      val p: List[Int] = h.quads.collect { case (a,b) => b.head.value }.toList
      val q: List[Int] = h.sorted.map(_.value).filter(!p.contains(_))

      List(7) ::: p ::: q ::: List(0,0,0)
    }

    (h.quads.toList.length == 1, this, score)
  }

  override def toString: String = {
    "Four of a Kind"
  }
}

object FourOfAKind {
  def apply(h: Hand): (Boolean, HandType, List[Int]) = (new FourOfAKind).evaluate(h)
}
