package com.shazam.app.stepdefinitions.api;

import io.cucumber.java.en.*;
import com.shazam.app.tasks.api.*;
import net.serenitybdd.screenplay.*;

public class SongsStepDefinitions {
    @When("{actor} desea buscar una cancion en la api de shazam con")
    public void actor_desea_buscar_una_cancion_en_la_api_de_shazam_con(Actor actor, String args) {
        actor.attemptsTo(DetectSong.withHeaders(args));
    }

    @When("{actor} desea buscar el detalle de una cancion en la api de shazam con")
    public void actor_desea_buscar_el_detalle_de_una_cancion_en_la_api_de_shazam_con(Actor actor, String args) {
        actor.attemptsTo(DetailSong.withId(args));
    }

    @Then("{actor} verifica que la respuesta del endpoint sea")
    public void actor_verifica_que_la_respuesta_del_endpoint_sea(Actor actor, String args) {
        actor.attemptsTo(ValidateResponse.validate(args));
    }
}
