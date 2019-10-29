package com.netcompany.characters.api.swapi.client;

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.kittinunf.fuel.httpGet
import com.netcompany.characters.api.swapi.dto.PeopleResultDto
import com.netcompany.characters.api.swapi.dto.PlanetDto
import com.netcompany.characters.exception.SwapiResultException
import org.springframework.stereotype.Service

@Service
class StarWarsApiClient {
    private val mapper = jacksonObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    private val BASE_URL = "https://swapi.co/api"

    fun getAllPeople(): PeopleResultDto {
        val responseBody = makeGetRequest("$BASE_URL/people?format=json")

        return mapper.readValue(responseBody)
    }

    fun getPeopleByName(name: String): PeopleResultDto {
        val responseBody = makeGetRequest("$BASE_URL/people?search=$name&format=json")

        return mapper.readValue(responseBody)
    }

    fun getPlanet(planetId: String): PlanetDto {
        val responseBody = makeGetRequest("$BASE_URL/planets/$planetId?format=json")

        return mapper.readValue(responseBody)
    }

    private fun makeGetRequest(url: String): String {
        val (_, _, result) = url.httpGet().responseString()
        val (body, error) = result

        return body ?: throw SwapiResultException("$error")
    }
}
