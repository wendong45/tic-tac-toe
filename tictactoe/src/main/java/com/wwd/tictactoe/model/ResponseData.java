package com.wwd.tictactoe.model;

/**
 * JSON data object model for data passing between server and client
 * @author Wendong Wang
 * @version 1 (June 2017)
 */

import java.io.Serializable;

public class ResponseData implements Serializable {

	private static final long serialVersionUID = -7788619177798333712L;

	private Board board;  // n x n game board

	//note of exception in operations, or instruction given back to client
	private String message; 

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseData(Board board, String message) {
		this.board = board;
		this.message = message;
	}

	public ResponseData() {
	}

}
