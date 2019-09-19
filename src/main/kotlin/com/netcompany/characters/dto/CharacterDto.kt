package com.netcompany.characters.dto

import com.netcompany.characters.api.swapi.dto.PeopleDto
import com.netcompany.characters.domain.CharacterEntity

/**
 * Data transfer object representing a character.
 */
data class CharacterDto(var id: Int?, var name: String, var height: Int, var homeworld: String) {
    constructor(characterEntity: CharacterEntity) :
        this(characterEntity.id, characterEntity.name, characterEntity.height, characterEntity.homeworld)

    constructor(peopleDto: PeopleDto) :
        this(null, peopleDto.name, peopleDto.height.toInt(), peopleDto.homeworld)
}
