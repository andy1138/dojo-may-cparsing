package lsug

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class MudParserTestSuite extends FunSuite with ShouldMatchers {
	test("go North") {
    MudParser.parse("GO NORTH") should be(NORTH)
  }

	test("Go South") {
		MudParser.parse("GO SOUTH") should be(SOUTH)
	}

	test("Go East") {
		MudParser.parse("GO EAST") should be(EAST)
	}
	
	test("Go West") {
		MudParser.parse("GO WEST") should be(WEST)
	}
	
	test("Kill Self") {
		MudParser.parse("KILL SELF") should be(DEAD)
	}
	
//	test("Kill Everyone") {
//	  MudParser.parse("KILL EVERYONE") should be(RAGNAROK)
//	}
}
