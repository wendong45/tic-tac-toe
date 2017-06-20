package com.wwd.tictactoe.model;

/**
 * Game board model
 * @author Wendong Wang
 * @version 1 (June 2017)
 */

import java.io.Serializable;


public class Board implements Serializable {
	private static final long serialVersionUID = -8290708632141465234L;

	/**
	 * The n x n squares consist a whole game board
	 */
	private Square[][] squares;

	public Square[][] getSquares() {
		return squares;
	}

	public void setSquares(Square[][] squares) {
		this.squares = squares;
	}

	public Board(Square[][] squares) {
		this.squares = squares;
	}

	public Board() {
	}

	/**
	 * String expression of Board in JSON format
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("[");

		for (int i = 0; squares != null && i < squares.length; i++) {
			if (i > 0)
				sb.append(", ");
			sb.append("[");
			
			for (int j = 0; squares[i] != null && j < squares[i].length; j++) {
				if (j != 0)
					sb.append(", ");
				sb.append(squares[i][j]);
			}
			
			sb.append("]");
		}

		sb.append("]");

		return sb.toString();
	}

}
