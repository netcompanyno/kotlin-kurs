package com.netcompany.characters.dto

import com.netcompany.characters.api.swapi.dto.PeopleDto
import com.netcompany.characters.domain.CharacterEntity
import org.springframework.validation.annotation.Validated
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Size

/**
 * Data transfer object representing a character.
 */
@Validated
data class CharacterDto(
    var id: Int?,
    @get: Size(min = 2) var name: String,
    @get: Min(1) @get: Max(4000) var height: Int,
    @get: Size(min = 2) var homeworld: String) {

    constructor(characterEntity: CharacterEntity) :
        this(characterEntity.id, characterEntity.name, characterEntity.height, characterEntity.homeworld)

    constructor(peopleDto: PeopleDto) :
        this(null, peopleDto.name, peopleDto.height.toInt(), peopleDto.homeworld)
}
