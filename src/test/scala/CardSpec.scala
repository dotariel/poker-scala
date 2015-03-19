import org.scalatest._

class CardSpec extends UnitSpec {

  "A card" should "return a meaningful string" in {
    assert(new Card("4C").toString === "4C")
    assert(new Card("AH").toString === "AH")
    assert(new Card("3S").toString === "3S")
    assert(new Card("KD").toString === "KD")
  }

  it should "be constructed using Card()" in {
    assert(Card("4C").isInstanceOf[Card])
  }

  it should "be able to be constructed from a string" in {
    assert(new Card("AH").toString === "AH")
    assert(new Card("TC").toString === "TC")
    assert(new Card("2S").toString === "2S")
  }

  it should "throw IllegalArgumentException if an invalid string is used in constructor" in {
    an [IllegalArgumentException] should be thrownBy {
      new Card("XX")
    } 
  }

  it should "return the face identifier of the card" in {
    assert(new Card("AH").face === "A")
    assert(new Card("TC").face === "T")
    assert(new Card("2S").face === "2")
  }

  it should "return the suit identifier of the card" in {
    assert(new Card("AH").suit === "H")
    assert(new Card("TC").suit === "C")
    assert(new Card("2S").suit === "S")
    assert(new Card("9D").suit === "D")
  }

  it should "return the value of the card" in {
    assert(new Card("AH").value === 14)
    assert(new Card("TC").value === 10)
    assert(new Card("2S").value === 2)
    assert(new Card("9D").value === 9)
  }
}