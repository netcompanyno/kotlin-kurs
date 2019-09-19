package com.netcompany.characters.service;

import com.netcompany.characters.api.swapi.client.StarWarsApiClient
import com.netcompany.characters.dto.CharacterDto
import org.springframework.stereotype.Service

@Service
class StarWarsApiService(val starWarsApiClient: StarWarsApiClient) {

    fun getAllPeople(): List<CharacterDto> {
        val characters = starWarsApiClient.getAllPeople()
            .results
            .map { p -> CharacterDto(p) }

        characters.forEach { c ->
            val planetId = c.homeworld.split("/").dropLast(1).last()
            c.homeworld = starWarsApiClient.getPlanet(planetId).name
        }


        return characters
    }
}
