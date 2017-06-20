package com.wwd.tictactoe.service;

/**
 * service contract for the specific lower level functions
 * @author Wendong Wang
 * @version 1 (June 2017)
 */

import java.util.List;

import com.wwd.tictactoe.model.Square;

public interface TictactoeService {

	/**
	 * Randomly pick up one from the available moves
	 * @param moves available moves
	 * @return return true if a move is made, otherwise false.
	 */
	public abstract boolean moveRandom(List<Square> moves);

	/**
	 * Get the legal moves available at the current state 
	 * @return return the list of legal moves
	 */
	public abstract List<Square> getLegalMoves();

	/**
	 * Get real good ones from the legal moves
	 * @return
	 */
	public abstract List<Square> getGoodMoves();

	/**
	 * Get game board - state
	 * @return return game board of n x n squares
	 */
	public abstract Square[][] getBoard();

	/**
	 * Set game board - state
	 * @param board n x n game board
	 */
	public abstract void setBoard(Square[][] board);

}