import org.scalatest._

class PairSpec extends UnitSpec {

  "A hand" should "be determined to be Pair" in {
    val hand = Hand(List("3C", "3S", "TC", "7D", "KH"))
    val evaluation = Pair(hand)

    assert(evaluation._1)
    assert(evaluation._2.isInstanceOf[Pair])
    assert(evaluation._3 == List(1,3,13,10,7,0))
  }

  it should "render a meaningful String value" in {
    val hand = Hand(List("3C", "3S", "TC", "7D", "KH"))
    val evaluation = Pair(hand)

    assert(evaluation._2.toString == "Pair")
  }
}