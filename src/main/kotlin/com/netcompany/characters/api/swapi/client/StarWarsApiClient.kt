package com.netcompany.characters.api.swapi.client;

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.kittinunf.fuel.httpGet
import com.netcompany.characters.api.swapi.dto.PeopleResultDto;
import org.springframework.stereotype.Service;

@Service
class StarWarsApiClient {
    private val mapper = jacksonObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    private val BASE_URL = "https://swapi.co/api"

    fun getAllPeople(): PeopleResultDto {
        val (_, _, result) = "$BASE_URL/people?format?json".httpGet().responseString()
        val (body, _) = result

        return mapper.readValue(body!!)
    }
}
