package twenty20.example.aitictactoe


import android.util.Log

class Minimax {
    fun evaluate(newmoves: Array<IntArray>): Int {
        // Checking for Rows for X or O victory.

        for (row in 0..2) {
            if (newmoves[row][0] == newmoves[row][1] &&
                    newmoves[row][1] == newmoves[row][2]) {
                if (newmoves[row][0] == 2) return +10
                else if (newmoves[row][0] == 1) return -10
            }
        }


        for (col in 0..2) {
            if (newmoves[0][col] == newmoves[1][col] &&
                    newmoves[1][col] == newmoves[2][col]) {
                if (newmoves[0][col] == 2) return +10
                else if (newmoves[0][col] == 1) return -10
            }
        }


        if (newmoves[0][0] == newmoves[1][1] && newmoves[1][1] == newmoves[2][2]) {
            if (newmoves[0][0] == 2) return +10
            else if (newmoves[0][0] == 1) return -10
        }

        if (newmoves[0][2] == newmoves[1][1] && newmoves[1][1] == newmoves[2][0]) {
            if (newmoves[0][2] == 2) return +10
            else if (newmoves[0][2] == 1) return -10
        }

        return 0
    }
    fun isMovesLeft(board: Array<IntArray>): Boolean {
        for (i in 0..2) for (j in 0..2) if (board[i][j] == 0) return true
        return false
    }

    fun minimax(newmoves: Array<IntArray>, depth: Int, isMax: Boolean): Int
    {

        val score: Int = evaluate(newmoves)

        // If Maximizer has won the game
        // return his/her evaluated score
        if (score == 10) return score

        // If Minimizer has won the game
        // return his/her evaluated score
        if (score == -10) return score

        // If there are no more moves and
        // no winner then it is a tie

        if (isMovesLeft(newmoves) == false) return 0

        // If this maximizer's move
        if (isMax) {
        var best = -1000

        // Traverse all cells
        for (i in 0..2) {
            for (j in 0..2) {
                // Check if cell is empty
                if (newmoves[i][j] == 0) {

                    // Make the move
                    newmoves[i][j] = 2

                    // Call minimax recursively and choose
                    // the maximum value
                    best = Math.max(
                            best, minimax(
                                    newmoves,
                                    depth + 1, !isMax
                            )
                    )

                    // Undo the move
                    newmoves[i][j] = 0
                }
            }
        }
       return best
    } else {
        var best = 1000

        // Traverse all cells
        for (i in 0..2) {
            for (j in 0..2) {
                // Check if cell is empty
                if (newmoves[i][j] == 0) {
                    // Make the move
                    newmoves[i][j] = 1

                    // Call minimax recursively and choose
                    // the minimum value
                    best = Math.min(
                            best, minimax(
                                    newmoves,
                                    depth + 1, !isMax
                            )
                    )

                    // Undo the move
                    newmoves[i][j] = 0
                }
            }
        }
    return  best
    }
    }
    fun findBestMove(moves:Array<Int>): Move {
        val newmoves: Array<IntArray> = arrayOf(
            intArrayOf(moves[0], moves[1], moves[2]),
            intArrayOf(moves[3], moves[4], moves[5]),
            intArrayOf(moves[6], moves[7], moves[8]),
        )
        var bestVal = -1000
        val bestmove = Move()
        bestmove.row = -1
        bestmove.col = -1
        for (i in 0..2) {
            for(j in 0..2)
            {
                if (newmoves[i][j] == 0) {
                    newmoves[i][j] = 2
                    val moveVal = minimax(newmoves, 0, false)
                    newmoves[i][j] = 0
                    if (moveVal > bestVal) {
                        bestmove.row = i
                        bestmove.col=j
                        bestVal = moveVal
                    }
                }
            }

        }
        Log.e("showing","$bestVal")
        return bestmove
    }

}

class Move{
    var row=0
    var col=0
}