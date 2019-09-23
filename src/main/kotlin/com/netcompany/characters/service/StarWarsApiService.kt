package com.netcompany.characters.service;

import com.netcompany.characters.api.swapi.client.StarWarsApiClient
import com.netcompany.characters.dto.CharacterDto
import org.springframework.stereotype.Service

@Service
class StarWarsApiService(private val starWarsApiClient: StarWarsApiClient) {

    fun getAllCharacters(): List<CharacterDto> {
        val characters = starWarsApiClient.getAllPeople()
            .results
            .map { CharacterDto(it) }

        characters.forEach { updateHomeworld(it) }

        return characters
    }

    fun getCharactersByName(name: String): List<CharacterDto> {
        val characters = starWarsApiClient.getPeopleByName(name)
            .results
            .map { CharacterDto(it) }

        characters.forEach { updateHomeworld(it) }

        return characters
    }

    private fun updateHomeworld(characterDto: CharacterDto) {
        val planetId = characterDto.homeworld.split("/").dropLast(1).last()
        characterDto.homeworld = starWarsApiClient.getPlanet(planetId).name
    }
}
