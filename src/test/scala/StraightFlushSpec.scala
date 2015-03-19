import org.scalatest._

class StraightFlushSpec extends UnitSpec {

  "A hand" should "be determined to be StraightFlush" in {
    val hand = Hand(List("3C", "4C", "5C", "6C", "7C"))
    val evaluation = StraightFlush(hand)

    assert(evaluation._1)
    assert(evaluation._2.isInstanceOf[StraightFlush])
    assert(evaluation._3 == List(8,7,6,5,4,3))
  }

  it should "render a meaningful String value" in {
    val hand = Hand(List("3C", "4C", "5C", "6C", "7C"))
    val evaluation = StraightFlush(hand)

    assert(evaluation._2.toString == "Straight Flush")
  }
}