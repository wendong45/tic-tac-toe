package com.wwd.tictactoe.controller;

/**
 * Controller program to handle requests for Tic-Tac-Toe web services
 * @author Wendong Wang
 * @version 1 (June 2017)
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wwd.tictactoe.Constants;
import com.wwd.tictactoe.model.Board;
import com.wwd.tictactoe.model.ResponseData;
import com.wwd.tictactoe.model.Square;
import com.wwd.tictactoe.service.TictactoeService;


@RestController
@Scope("prototype") //make one class instance exclusively serve one request
public class TictactoeController {
	@Autowired
	private TictactoeService tictactoeService;
	
	//note of exception in operations, or instruction given back to client
	private String message;
	
	private static final Logger logger = LoggerFactory.getLogger(TictactoeController.class);


	/**
	 * Request handler for server to initiate the game
	 * @param whoPlaysFirst If client asks server to play first, a move is done after board reset.
	 * @return Return ResponseData which contains new board state and message note
	 */
	@RequestMapping(value = Constants.SERVER_INIT, method = RequestMethod.GET)
	public @ResponseBody
	ResponseData serverInit(@RequestParam("who_plays_first") String whoPlaysFirst) {
		logger.info("Start serverInit");
		Square[][] board = new Square[][] { { new Square("1", ""), new Square("2", ""), new Square("3", "") },
				{ new Square("4", ""), new Square("5", ""), new Square("6", "") },
				{ new Square("7", ""), new Square("8", ""), new Square("9", "") } };

		message = "";
		if (whoPlaysFirst != null && whoPlaysFirst.equalsIgnoreCase(Constants.SERVER_MARK))
			playOnce(board);
		
		if(message.length()==0)
			message = "Your turn please...";
		
		return new ResponseData(new Board(board), message);
	}

	/**
	 * Request handler for server to make a move upon client's move
	 * @param board the n x n game board
	 * @return Return ResponseData which contains new board state and message note
	 */
	@RequestMapping(value = Constants.SERVER_PLAY, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody
	ResponseData serverPlay(@RequestBody Square[][] board) { //
		logger.info("Start serverPlay.");

		message = "";
		playOnce(board);
		
		if(message.length()==0)
			message = "Your turn please...";

		return new ResponseData(new Board(board), message);

	}

	/**
	 * Server makes one play or one move
	 * @param board
	 */
	private void playOnce(Square[][] board) {
		try {
			tictactoeService.setBoard(board);
			tictactoeService.moveRandom(tictactoeService.getLegalMoves());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("TictactoeController::serverPlay:" + e.getMessage());
			message = "Server error: " + e.getMessage();
		}
	}
}
