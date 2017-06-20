package com.wwd.tictactoe;

/**
 * Junit tests
 * @author Wendong Wang
 * @version 1 (June 2017)
 */

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.wwd.tictactoe.model.Board;
import com.wwd.tictactoe.model.ResponseData;
import com.wwd.tictactoe.model.Square;

public class TestTictactoe {

	public static final String SERVER_URI = "http://localhost:8080/tictactoe/";

	@Test
	public void testServerInit() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseData resp = restTemplate.getForObject(SERVER_URI + Constants.SERVER_INIT + "?who_plays_first=O",
				ResponseData.class);
		assertTrue(resp != null && resp.getBoard() != null && resp.getBoard().getSquares().length == 3);
		System.out.println(resp.getBoard());
	}

	//@Test //run into 405: Method Not Allowed
	public void testServerPlay() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		ResponseData resp = restTemplate.getForObject(SERVER_URI + Constants.SERVER_PLAY, ResponseData.class);
		Board board = resp.getBoard();
		System.out.println("--------before--------: \n" + board);

		board.getSquares()[0][0].setValue("X");

		// HttpHeaders headers = new HttpHeaders();
		// headers.setContentType(MediaType.APPLICATION_JSON);
		// List<MediaType> al = new ArrayList();
		// al.add(MediaType.APPLICATION_JSON);
		// headers.setAccept(al);
		// //headers.set("Authorization", "Basic " + "xxxxxxxxxxxx");
		// HttpEntity<Square[][]> entity = new
		// HttpEntity<Square[][]>(board.getSquares(), headers);
		//
		// // send request and parse result
		// ResponseEntity<ResponseData> response = restTemplate
		// .exchange(SERVER_URI + Constants.SERVER_PLAY, HttpMethod.POST,
		// entity, ResponseData.class);
		// assertTrue(response != null && response.getBody().getBoard() != null
		// && response.getBody().getBoard().getSquares().length == 3);
		//
		// board = response.getBody().getBoard();
		resp = restTemplate.postForObject(SERVER_URI + Constants.SERVER_PLAY, board.getSquares(), ResponseData.class);
		assertTrue(resp != null && resp.getBoard() != null && resp.getBoard().getSquares().length == 3);

		board = resp.getBoard();
		System.out.println("--------after--------: \n" + board);
	}

}
