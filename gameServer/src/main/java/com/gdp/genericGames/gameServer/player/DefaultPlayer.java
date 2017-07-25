package com.gdp.genericGames.gameServer.player;

/**
 * Default class for IPlayer contains basic info.
 *
 * Created by fzelada on 15/03/2017.
 */
public class DefaultPlayer implements IPlayer<DefaultPlayer> {

	private long playerId;
	private long bet;
	private long win;

	private long balance;

	@Override
	public long getBalance() {
		return balance;
	}

	public DefaultPlayer setBalance(long balance) {//TODO May require further implementation
		this.balance = balance;
		return this;
	}

	@Override
	public long getPlayerId() {
		return playerId;
	}

	@Override
	public DefaultPlayer setPlayerId(long playerId) {
		this.playerId = playerId;
		return this;
	}

	@Override
	public long getBet() {
		return bet;
	}

	@Override
	public DefaultPlayer setBet(long bet) {
		this.bet = bet;
		return this;
	}

	@Override
	public long getWin() {
		return win;
	}

	@Override
	public DefaultPlayer setWin(long win) {
		this.win = win;
		return this;
	}

	@Override
	public long takeBet(long betAmount) {
		return 0;
	}

	@Override
	public long addWin(long amount) {
		return 0;
	}

	@Override
	public void updatePlayer() {

	}

	@Override
	public boolean authenticate() {
		return false;
	}
}
