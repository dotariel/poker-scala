import org.scalatest._

class FourOfAKindSpec extends UnitSpec {

  "A hand" should "be determined to be FourOfAKind" in {
    val hand = Hand(List("3C", "3S", "3H", "3D", "KH"))
    val evaluation = FourOfAKind(hand)

    assert(evaluation._1)
    assert(evaluation._2.isInstanceOf[FourOfAKind])
    assert(evaluation._3 == List(7,3,13,0,0,0))
  }

  it should "render a meaningful String value" in {
    val hand = Hand(List("3C", "3S", "3C", "TD", "KH"))
    val evaluation = FourOfAKind(hand)

    assert(evaluation._2.toString == "Four of a Kind")
  }
}