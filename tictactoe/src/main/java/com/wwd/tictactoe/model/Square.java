package com.wwd.tictactoe.model;

/**
 * Model of the square - an unit of game board
 * @author Wendong Wang
 * @version 1 (June 2017)
 */

import java.io.Serializable;

public class Square implements Serializable {
	private static final long serialVersionUID = -1651648469746014237L;
	private String id; //square identifier
	private String value; //square value - represents who occupies 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Square(String id, String value) {
		this.id = id;
		this.value = value;
	}

	public Square() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * String express of the Square (JSON format)
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("{\"id\":\"").append(id).append("\", \"value\":\"").append(value).append("\"}");

		return sb.toString();
	}

}
