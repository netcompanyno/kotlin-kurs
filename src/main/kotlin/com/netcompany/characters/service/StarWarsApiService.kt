package com.netcompany.characters.service;

import com.netcompany.characters.api.swapi.client.StarWarsApiClient
import com.netcompany.characters.dto.CharacterDto
import org.springframework.stereotype.Service

@Service
class StarWarsApiService (val starWarsApiClient: StarWarsApiClient) {

    fun getAllPeople(): List<CharacterDto> {
        return starWarsApiClient.getAllPeople()
            .results
            .map { p -> CharacterDto(p) }
    }
}
