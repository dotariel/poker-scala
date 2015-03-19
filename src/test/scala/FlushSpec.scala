import org.scalatest._

class FlushSpec extends UnitSpec {

  "A hand" should "be determined to be Flush" in {
    val hand = Hand(List("6C", "AC", "5C", "TC", "8C"))
    val evaluation = Flush(hand)

    assert(evaluation._1)
    assert(evaluation._2.isInstanceOf[Flush])
    assert(evaluation._3 == List(5,14,10,8,6,5))
  }

  it should "render a meaningful String value" in {
    val hand = Hand(List("6C", "AC", "5C", "TC", "8C"))
    val evaluation = Flush(hand)

    assert(evaluation._2.toString == "Flush")
  }
}