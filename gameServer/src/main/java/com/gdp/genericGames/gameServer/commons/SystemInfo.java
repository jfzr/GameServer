package com.gdp.genericGames.gameServer.commons;

/**
 * Created by fzelada on 30/03/2017.
 */
public class SystemInfo {
	private long sessionId;
	private long msgId;
	private long brandId;
	private long gameInstance;
	private long eventId;
	private long gameId;
	private long jackpotId;
	private boolean completedFlag;

	private long balance;
	private int  totalBet;
	private long totalWin;
	private long currentWin;
	private int points;
	private boolean playThrough;


	private boolean realPlay;
	private boolean recoveryFlag;
	private long recoveryPending;


	public long getSessionId() {
		return sessionId;
	}

	public SystemInfo setSessionId(long sessionId) {
		this.sessionId = sessionId;
		return this;
	}

	public long getMsgId() {
		return msgId;
	}

	public SystemInfo setMsgId(long msgId) {
		this.msgId = msgId;
		return this;
	}

	public long getBrandId() {
		return brandId;
	}

	public SystemInfo setBrandId(long brandId) {
		this.brandId = brandId;
		return this;
	}

	public long getGameInstance() {
		return gameInstance;
	}

	public SystemInfo setGameInstance(long gameInstance) {
		this.gameInstance = gameInstance;
		return this;
	}

	public long getEventId() {
		return eventId;
	}

	public SystemInfo setEventId(long eventId) {
		this.eventId = eventId;
		return this;
	}

	public long getGameId() {
		return gameId;
	}

	public SystemInfo setGameId(long gameId) {
		this.gameId = gameId;
		return this;
	}

	public long getJackpotId() {
		return jackpotId;
	}

	public SystemInfo setJackpotId(long jackpotId) {
		this.jackpotId = jackpotId;
		return this;
	}

	public boolean isCompletedFlag() {
		return completedFlag;
	}

	public SystemInfo setCompletedFlag(boolean completedFlag) {
		this.completedFlag = completedFlag;
		return this;
	}

	public long getBalance() {
		return balance;
	}

	public SystemInfo setBalance(long balance) {
		this.balance = balance;
		return this;
	}

	public int getTotalBet() {
		return totalBet;
	}

	public SystemInfo setTotalBet(int totalBet) {
		this.totalBet = totalBet;
		return this;
	}

	public long getTotalWin() {
		return totalWin;
	}

	public SystemInfo setTotalWin(long totalWin) {
		this.totalWin = totalWin;
		return this;
	}

	public long getCurrentWin() {
		return currentWin;
	}

	public SystemInfo setCurrentWin(long currentWin) {
		this.currentWin = currentWin;
		return this;
	}

	public int getPoints() {
		return points;
	}

	public SystemInfo setPoints(int points) {
		this.points = points;
		return this;
	}

	public boolean isPlayThrough() {
		return playThrough;
	}

	public SystemInfo setPlayThrough(boolean playThrough) {
		this.playThrough = playThrough;
		return this;
	}

	public boolean isRealPlay() {
		return realPlay;
	}

	public SystemInfo setRealPlay(boolean realPlay) {
		this.realPlay = realPlay;
		return this;
	}

	public boolean isRecoveryFlag() {
		return recoveryFlag;
	}

	public SystemInfo setRecoveryFlag(boolean recoveryFlag) {
		this.recoveryFlag = recoveryFlag;
		return this;
	}

	public long getRecoveryPending() {
		return recoveryPending;
	}

	public SystemInfo setRecoveryPending(long recoveryPending) {
		this.recoveryPending = recoveryPending;
		return this;
	}
}