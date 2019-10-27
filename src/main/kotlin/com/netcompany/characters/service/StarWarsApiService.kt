package com.netcompany.characters.service;

import com.netcompany.characters.api.swapi.client.StarWarsApiClient
import com.netcompany.characters.dto.CharacterDto
import org.springframework.stereotype.Service

/**
 * Oppgave 10
 *
 * Legg til en metode som henter karakterer basert på navn, og la denne kalle tilhørende metode i StarWarsApiClient.
 */
@Service
class StarWarsApiService(private val starWarsApiClient: StarWarsApiClient) {

    fun getAllCharacters(): List<CharacterDto> {
        return starWarsApiClient.getAllPeople()
            .results
            .map(::CharacterDto)
            .map(::updateHomeworld)
    }

    fun updateHomeworld(characterDto: CharacterDto) : CharacterDto {
        val planetId = characterDto.homeworld.split("/").dropLast(1).last()

        val homeworld = starWarsApiClient.getPlanet(planetId).name

        return characterDto.copy(homeworld = homeworld)
    }
}
