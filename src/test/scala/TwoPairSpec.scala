import org.scalatest._

class TwoPairSpec extends UnitSpec {

  "A hand" should "be determined to be TwoPair" in {
    val hand = Hand(List("3C", "3S", "TC", "TD", "KH"))
    val evaluation = TwoPair(hand)

    assert(evaluation._1)
    assert(evaluation._2.isInstanceOf[TwoPair])
    assert(evaluation._3 == List(2,10,3,13,0,0))
  }

  it should "render a meaningful String value" in {
    val hand = Hand(List("3C", "3S", "TC", "TD", "KH"))
    val evaluation = TwoPair(hand)

    assert(evaluation._2.toString == "Two Pair")
  }
}