package lsug

import scala.util.parsing.combinator.JavaTokenParsers
import scala.util.parsing.combinator.Parsers
import scala.util.parsing.combinator.RegexParsers

sealed class Action

sealed class Direction(val name: String) extends Action
//object Direction {
//  val Directions = List(NORTH, SOUTH, EAST, WEST).map { i => i.name -> i }.toMap
//}


sealed class Target(val name: String) extends Action
object Direction {
  val Directions = List(NORTH, SOUTH, EAST, WEST).map { i => i.name -> i }.toMap
}

case object NORTH extends Direction("NORTH")
case object SOUTH extends Direction("SOUTH")
case object EAST extends Direction("EAST")
case object WEST extends Direction("WEST")

case object DEAD extends Action  //("SELF")
case object RAGNORAK extends Action

object MudParser extends RegexParsers { 
  def command: Parser[Action] = "GO" ~> direction | "KILL" ~> target
  def direction: Parser[Direction] = ("NORTH" | "SOUTH" | "EAST" | "WEST") ^^ { Direction.Directions.get(_).get }
  def target: Parser[Action] = ("SELF" | "EVERYONE") ^^ { _ => DEAD }  // Target.Targets.get(_).get }
  
	def parse(input: String) = {
	  parseAll(command, input).get
	}
}
