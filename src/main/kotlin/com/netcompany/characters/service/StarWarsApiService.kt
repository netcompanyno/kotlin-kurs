package com.netcompany.characters.service;

import com.netcompany.characters.api.swapi.client.StarWarsApiClient
import com.netcompany.characters.api.swapi.dto.PeopleDto
import com.netcompany.characters.dto.CharacterDto
import org.springframework.stereotype.Service

@Service
class StarWarsApiService(private val starWarsApiClient: StarWarsApiClient) {

    fun getAllCharacters(): List<CharacterDto> {
        return starWarsApiClient.getAllPeople()
                .results
                .map(this::updateHomeworld)
    }

    fun getCharactersByName(name: String): List<CharacterDto> {
        return starWarsApiClient.getPeopleByName(name)
                .results
                .map(this::updateHomeworld)
    }

    private fun updateHomeworld(peopleDto: PeopleDto): CharacterDto {
        val planetId = peopleDto.homeworld.split("/").dropLast(1).last()
        return CharacterDto(peopleDto).copy(homeworld = starWarsApiClient.getPlanet(planetId).name)
    }
}
