import org.scalatest._

class HighCardSpec extends UnitSpec {

  "A hand" should "be determined to be HighCard" in {
    val hand = Hand(List("3C", "4S", "TC", "7D", "KH"))
    val evaluation = HighCard(hand)

    assert(evaluation._1)
    assert(evaluation._2.isInstanceOf[HighCard])
    assert(evaluation._3 == List(0,13,10,7,4,3))
  }

  it should "render a meaningful String value" in {
    val hand = Hand(List("3C", "4S", "TC", "7D", "KH"))
    val evaluation = HighCard(hand)

    assert(evaluation._2.toString == "High Card")
  }
}