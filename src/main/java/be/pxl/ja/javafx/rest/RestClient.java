package be.pxl.ja.javafx.rest;

import be.pxl.ja.javafx.model.Game;
import be.pxl.ja.javafx.model.GameEvaluation;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import java.util.Arrays;
import java.util.List;

public class RestClient {
    private static final String WS_URI = "http://localhost:8080/game-api/rest/game";

    public static List<Game> findAllGames() throws RuntimeException {
        Client client = null;
        try {
            client = ClientBuilder.newClient();
            WebTarget target = client.target(WS_URI);
            List<Game> games = Arrays.asList(target.request(MediaType.APPLICATION_JSON).get(Game[].class));
            return games;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            if (client != null) client.close();
        }
    }

    public static void postSpelEvaluatie(GameEvaluation gameEvaluation) {
        Client client = null;
        try {
            client = ClientBuilder.newClient();
            WebTarget target = client.target(WS_URI);
            target.path("evaluate").request()
                    .post(Entity.entity(gameEvaluation, MediaType.APPLICATION_JSON), GameEvaluation.class);
        } catch (RuntimeException e) {
            throw e;
        } finally {
            if (client != null) client.close();
        }
    }

}
