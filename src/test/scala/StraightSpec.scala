import org.scalatest._

class StraightSpec extends UnitSpec {

  "A hand" should "be determined to be Straight" in {
    val hand = Hand(List("3C", "4S", "5C", "6D", "7H"))
    val evaluation = Straight(hand)

    assert(evaluation._1)
    assert(evaluation._2.isInstanceOf[Straight])
    assert(evaluation._3 == List(4,7,6,5,4,3))
  }

  it should "render a meaningful String value" in {
    val hand = Hand(List("3C", "4S", "5C", "6D", "7H"))
    val evaluation = Straight(hand)

    assert(evaluation._2.toString == "Straight")
  }
}