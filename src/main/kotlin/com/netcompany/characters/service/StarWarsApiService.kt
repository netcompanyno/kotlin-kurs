package com.netcompany.characters.service;

import com.netcompany.characters.api.swapi.client.StarWarsApiClient
import com.netcompany.characters.dto.CharacterDto
import org.springframework.stereotype.Service

/**
 * Oppgave 9
 *
 * Vi har nå integrert tjenesten vår med SWAPI, men det er fortsatt en ting som ikke er optimal.
 * Hvis man ser på det som per nå returneres, vil man se at det for homeworld vises en link. Vi ønsker å hente ut selve
 * planeten fra SWAPI i stedet, og vise navnet fra denne.
 *
 * Implementer dette her.
 */
@Service
class StarWarsApiService(private val starWarsApiClient: StarWarsApiClient) {

    fun getAllCharacters(): List<CharacterDto> {
        return starWarsApiClient.getAllPeople()
            .results
            .map(::CharacterDto)
    }

    fun updateHomeworld(characterDto: CharacterDto) {
        val planetId = characterDto.homeworld.split("/").dropLast(1).last()

    }
}
