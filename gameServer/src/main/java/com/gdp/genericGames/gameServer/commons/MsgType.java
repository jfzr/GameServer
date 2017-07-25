package com.gdp.genericGames.gameServer.commons;

/**
 * Created by fzelada on 16/02/2017.
 */
public enum MsgType {
	INIT        (0),
	GAME        (1),
	CLOSURE     (2)
	;
	private int msgTypeCode;

	MsgType(int msgTypeCode) {
		this.msgTypeCode = msgTypeCode;
	}

	public int getMsgTypeCode() {
		return this.msgTypeCode;
	}
}
