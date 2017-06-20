package com.wwd.tictactoe.service;

/**
 * service bean - implementation of the specific lower level functions
 * @author Wendong Wang
 * @version 1 (June 2017)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.wwd.tictactoe.model.Square;


@Service
@Scope("prototype") //make one class instance exclusively serve one request
public class TictactoeServiceImp implements TictactoeService {
	private Square[][] board;
	private final static String SERVER_MARK = "O";

	@Override
	public boolean moveRandom(List<Square> moves) {
		if (moves == null || moves.size() == 0)
			return false;

		Random r = new Random();
		int size = moves.size();
		
		int randomIdx = (size == 1 ? 0 : r.nextInt(size - 1));
		//nextInt returns an integer in range from 0 to (size-1). Illegal from 0 to 0!

		moves.get(randomIdx).setValue(SERVER_MARK);

		return true;
	}

	@Override
	public List<Square> getLegalMoves() {
		if (board == null || board.length == 0)
			return null;

		List<Square> moves = new ArrayList();
		
		//look for legal moves - actually unoccupied squares
		for (Square[] row : board) {
			if (row == null || row.length == 0)
				continue;
			for (Square square : row)
				if (square != null && square.getValue() == null || square.getValue().length() == 0)
					moves.add(square);
		}

		if (moves.size() == 0)
			return null;
		else
			return moves;
	}

	/*
	 * ToDo: to apply AI as marked inside
	 */
	@Override
	public List<Square> getGoodMoves() {
		List<Square> moves = getLegalMoves();
		if (moves == null || moves.size() == 0)
			return null;

		// apply AI to maximize own chance to win and minimize opponent's chance

		if (moves.size() == 0)
			return null;
		else
			return moves;
	}

	@Override
	public Square[][] getBoard() {
		return board;
	}

	@Override
	public void setBoard(Square[][] board) {
		this.board = board;
	}

}
