package com.netcompany.characters.service;

import com.netcompany.characters.api.swapi.client.StarWarsApiClient
import com.netcompany.characters.dto.CharacterDto
import org.springframework.stereotype.Service

@Service
class StarWarsApiService(private val starWarsApiClient: StarWarsApiClient) {

    fun getAllCharacters(): List<CharacterDto> {
        return starWarsApiClient.getAllPeople()
            .results
            .map(::CharacterDto)
            .map(this::updateHomeworld)
    }

    fun getCharactersByName(name: String): List<CharacterDto> {
        return starWarsApiClient.getPeopleByName(name)
            .results
            .map(::CharacterDto)
            .map(this::updateHomeworld)
    }

    private fun updateHomeworld(characterDto: CharacterDto): CharacterDto {
        val planetId = characterDto.homeworld.split("/").dropLast(1).last()
        return characterDto.copy(homeworld = starWarsApiClient.getPlanet(planetId).name)
    }
}
