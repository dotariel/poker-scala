import org.scalatest._

class ThreeOfAKindSpec extends UnitSpec {

  "A hand" should "be determined to be ThreeOfAKind" in {
    val hand = Hand(List("3C", "3S", "3C", "TD", "KH"))
    val evaluation = ThreeOfAKind(hand)

    assert(evaluation._1)
    assert(evaluation._2.isInstanceOf[ThreeOfAKind])
    assert(evaluation._3 == List(3,3,13,10,0,0))
  }

  it should "render a meaningful String value" in {
    val hand = Hand(List("3C", "3S", "3C", "TD", "KH"))
    val evaluation = ThreeOfAKind(hand)

    assert(evaluation._2.toString == "Three of a Kind")
  }
}