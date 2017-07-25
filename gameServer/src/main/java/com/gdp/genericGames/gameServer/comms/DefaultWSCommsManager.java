package com.gdp.genericGames.gameServer.comms;

import com.gdp.genericGames.gameServer.comms.data.CommsData;
import com.gdp.genericGames.gameServer.comms.data.GameData;
import com.gdp.genericGames.gameServer.core.ISystemCore;
import com.gdp.genericGames.gameServer.exceptions.CommsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

/**
 * Controls data distribution, game loading. It is created once per connection and destroyed in a similar fashion
 *
 * Created by fzelada on 24/02/2017.
 */


@Service
public class DefaultWSCommsManager<G extends GameData> extends TextWebSocketHandler implements  ICommsManager<G> {

	private static Logger log = LoggerFactory.getLogger(DefaultWSCommsManager.class);

	private JSONCoder coder;
	private WebSocketSession session;
	private ISystemCore<G> systemCore;

	@Autowired
	public void setSystemCore(ISystemCore<G> systemCore) {
		this.systemCore = systemCore;
	}

	@Autowired
	public void setJSONCoder(JSONCoder jsonCoder) {
		this.coder = jsonCoder;
	}


	@Override
	public void afterConnectionEstablished(WebSocketSession session) {
		this.session = session;
		log.info("New websocket connection established: " + this.session.getId());
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message){

		log.trace("Incoming message of session -" + session.getId() + "-: " + message.getPayload());

		try {
			CommsData commsData = coder.extractCommsData(message.getPayload());

			if (commsData != null) {

				CommsData toSend = systemCore.process(commsData);//TODO: check for queue blocking // reduce var use by modifying commsData only

				session.sendMessage(coder.prepareCommsData(toSend));//TODO: Must handle null-pointer ex

			}
			else {
				session.sendMessage(new TextMessage("Continue.. in test mode!"));
				////////////////////////////////////////TODO add exception
			}

		} catch (CommsException e) {
			//TODO: Handle properly
			log.error("Comms error: " + e.getMessage());
			System.out.println("COMMS ERROR:");
			e.printStackTrace();
			//session.sendMessage(new TextMessage(e.getMessage()));

		} catch (IOException e) {
			e.printStackTrace();//TODO check for this unexpected error
		}
		//session.sendMessage(new TextMessage("Closing session: " + session.getId()));
		//session.close(); //TODO define closing level // Should close... session was created and since there comms error better to destroy session
		//TODO: add close connexion system -- add field on CommsData*/

	}


	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception)
			throws Exception {
		System.out.println("ERROR!!!"); //TODO delete and handle properly
		session.close(CloseStatus.SERVER_ERROR);
		log.info("Connection session " + this.session.getId() + "was closed.");
	}

}
