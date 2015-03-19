trait HandType {
  def evaluate(h: Hand): (Boolean, HandType, List[Int])
}
