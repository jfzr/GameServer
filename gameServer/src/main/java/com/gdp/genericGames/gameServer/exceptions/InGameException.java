package com.gdp.genericGames.gameServer.exceptions;

/**
 * Exception for errors that occur while game processing. It's sub-classes must be caught
 * inside the class while this exception should arise from game to communicate error to the
 * system.
 *
 * Created by fzelada on 27/03/2017.
 */
public class InGameException extends Exception{
	public InGameException(){
		super();
	}

	public InGameException(String e){
		super(e);
	}
}
