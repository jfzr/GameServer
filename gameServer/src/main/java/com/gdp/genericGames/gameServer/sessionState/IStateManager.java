package com.gdp.genericGames.gameServer.sessionState;


import com.gdp.genericGames.gameServer.comms.data.CommsData;
import com.gdp.genericGames.gameServer.comms.data.GameData;
import com.gdp.genericGames.gameServer.player.IPlayer;
import org.springframework.context.ApplicationContextAware;

/**
 * Manager for states(game). Handle all request regarding states and index them by session object
 * Uses ApplicationContextAware to be able to create multiple State objects(prototypes) that are internally wired
 * by Spring Container
 *
 * Created by fzelada on 1/03/2017.
 */
public interface IStateManager<S extends StateBean> extends ApplicationContextAware{

	S createState(long id);
	void initState(S state, IPlayer player, CommsData<? super GameData> incomingData);
	void save(S state, String id);
	boolean delete(String id);
	S recover(String id);

}
