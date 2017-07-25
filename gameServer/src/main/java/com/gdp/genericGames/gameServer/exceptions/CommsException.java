package com.gdp.genericGames.gameServer.exceptions;

import java.io.IOException;

/**
 * Created by fzelada on 15/02/2017.
 */
public class CommsException extends IOException {

	public CommsException(){
		super();
	}

	public CommsException(IOException e) {
		super(e);
	}

	public CommsException (String e){
		super(e);
	}
}
