import org.scalatest._
import org.scalamock.scalatest.MockFactory

abstract class UnitSpec extends FlatSpec 
  with Matchers
  with MockFactory
  with OptionValues
  with Inside 
  with Inspectors
