package week7.lecture5

class Pouring(capacity: Vector[Int]) {

  // State
  type State = Vector[Int]
  val initialState = capacity map (_ => 0)

  // Moves
  trait Move {
    def change(state: State): State
  }
  case class Empty(glass: Int) extends Move {
    def change(state: State): State = state.updated(glass, 0)
  }
  case class Fill(glass: Int) extends Move {
    def change(state: State): State = state.updated(glass, capacity(glass))
  }
  case class Pour(from: Int, to: Int) extends Move {
    def change(state: State): State = {
      val amount = state(from) min (capacity(to) - state(to));
      state.updated(to, state(to) + amount)
      ( state.updated(from, state(from) - amount) ).updated(to, state(to) + amount)
    }
  }

  val glasses = 0 until capacity.length

  val moves =
    (for (g <- glasses) yield Empty(g)) ++
      (for (g <- glasses) yield Fill(g)) ++
      (for (from <- glasses; to <- glasses if from != to) yield Pour(from, to))

  val initialPath = new Path(Nil, initialState)
  
  // List contains our moves in reverse order so our first move is basically
  // the last element in the list
  //class Path(history: List[Move]) {
  class Path(history: List[Move], val endState: State) {

    //def endState = history.foldRight(initialState)((move, result) => move.change(result)) // as the path grow big, computing this starts to take more and more time!

    /*
     * a more verbose option below for end state calculation.
     *
     def endState = trackState(history)
    private def trackState(moves: List[Move]): State = moves match {
      case Nil => initialState
      case move :: rem => {
        move change trackState(moves)
      }
    }
    */

    def extend(move: Move) = new Path(move :: history, move.change(endState)) // since our history is reveresed

    override def toString = {
      history.reverse mkString (" ") + "--> " + endState
    }
  }
  
  def from(paths: Set[Path], explored: Set[State]): Stream[Set[Path]] = {
    if ( paths.isEmpty ) {
      Stream.Empty
    }
    else {
      val more = for {
        path <- paths
        next <- moves.map { move => path.extend(move) }
        if ! (explored contains next.endState)
      } yield next
      
      paths #:: from(more, explored ++ ( more map { _.endState } ) ) // TODO: Why does from(more).append(paths) doesn't work, isn't it same for #:: ?
    }
  }
  
  val pathSets = from(Set(initialPath), Set(initialState))
  
  def solution(target: Int): Stream[Path] = {
    for {
      pathset <- pathSets
      path <- pathset
      if path.endState contains target
    } yield path
  }
}