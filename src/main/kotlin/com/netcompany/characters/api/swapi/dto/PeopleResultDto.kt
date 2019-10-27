package com.netcompany.characters.api.swapi.dto

data class PeopleResultDto(val count: Int, val next: String?, val previous: String?, val results: List<PeopleDto>)
