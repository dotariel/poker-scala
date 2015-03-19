object HandTypes {
  def all: List[HandType] = {
    List(
      new StraightFlush,
      new FourOfAKind,
      new FullHouse,
      new Flush,
      new Straight,
      new ThreeOfAKind,
      new TwoPair,
      new Pair,
      new HighCard
    )
  }
}
