import org.scalatest._

class FullHouseSpec extends UnitSpec {

  "A hand" should "be determined to be FullHouse" in {
    val hand = Hand(List("3C", "3S", "3D", "2H", "2C"))
    val evaluation = FullHouse(hand)

    assert(evaluation._1)
    assert(evaluation._2.isInstanceOf[FullHouse])
    assert(evaluation._3 == List(6,3,2,0,0,0))
  }

  it should "render a meaningful String value" in {
    val hand = Hand(List("3C", "3S", "3D", "2H", "2C"))
    val evaluation = FullHouse(hand)

    assert(evaluation._2.toString == "Full House")
  }
}