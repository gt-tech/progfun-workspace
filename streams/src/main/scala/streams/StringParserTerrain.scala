package streams

import common._
import scala.annotation.tailrec

/**
 * This component implements a parser to define terrains from a
 * graphical ASCII representation.
 *
 * When mixing in that component, a level can be defined by
 * defining the field `level` in the following form:
 *
 *   val level =
 *     """------
 *       |--ST--
 *       |--oo--
 *       |--oo--
 *       |------""".stripMargin
 *
 * - The `-` character denotes parts which are outside the terrain
 * - `o` denotes fields which are part of the terrain
 * - `S` denotes the start position of the block (which is also considered
 * inside the terrain)
 * - `T` denotes the final position of the block (which is also considered
 * inside the terrain)
 *
 * In this example, the first and last lines could be omitted, and
 * also the columns that consist of `-` characters only.
 */
trait StringParserTerrain extends GameDef {

  /**
   * A ASCII representation of the terrain. This field should remain
   * abstract here.
   */
  val level: String

  /**
   * This method returns terrain function that represents the terrain
   * in `levelVector`. The vector contains parsed version of the `level`
   * string. For example, the following level
   *
   *   val level =
   *     """ST
   *       |oo
   *       |oo""".stripMargin
   *
   * is represented as
   *
   *   Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', 'o'))
   *
   * The resulting function should return `true` if the position `pos` is
   * a valid position (not a '-' character) inside the terrain described
   * by `levelVector`.
   */
  def terrainFunction(levelVector: Vector[Vector[Char]]): Pos => Boolean = {
    pos =>
      (pos.y >= 0) && (pos.y <= levelVector.size) && // row (y cordinate) of the position is between 0 and outer vector's size
        (pos.x >= 0) && (pos.x <= levelVector(pos.y).size) && // col (x cordinate) of the position is between 0 and size of inner vector obtained at column in outer vector (y-cordinate)
        (levelVector(pos.y)(pos.x) != '-') // and the value of row/col isn't '-'
  }

  /**
   * This function should return the position of character `c` in the
   * terrain described by `levelVector`. You can assume that the `c`
   * appears exactly once in the terrain.
   *
   * Hint: you can use the functions `indexWhere` and / or `indexOf` of the
   * `Vector` class
   */
  def findChar(c: Char, levelVector: Vector[Vector[Char]]): Pos = {
    
    @tailrec def impl(y: Int): Pos = { 
      if ( y >= levelVector.size ) {
        Pos(-1,-1) // out of bound row!
      }
      val x = levelVector(y).indexOf(c)
      if ( x != -1 ) Pos(x, y)
      else impl(y+1)
    }
    impl(0) // start iterating from 1st row
  }

  private lazy val vector: Vector[Vector[Char]] =
    Vector(level.split("\n").map(str => Vector(str: _*)): _*)

  lazy val terrain: Terrain = terrainFunction(vector)
  lazy val startPos: Pos = findChar('S', vector)
  lazy val goal: Pos = findChar('T', vector)

}
