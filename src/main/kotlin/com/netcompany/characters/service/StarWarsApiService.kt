package com.netcompany.characters.service;

import com.netcompany.characters.api.swapi.client.StarWarsApiClient
import com.netcompany.characters.dto.CharacterDto
import org.springframework.stereotype.Service

/**
 * Oppgave 8
 *
 * Returner en liste med alle karakterene ved å kalle metoden i StarWarsApiClient.
 */
@Service
class StarWarsApiService(private val starWarsApiClient: StarWarsApiClient) {

    fun getAllCharacters(): List<CharacterDto> {
        TODO()
    }
}
