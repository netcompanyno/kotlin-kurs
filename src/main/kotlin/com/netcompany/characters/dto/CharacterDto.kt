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
    @get: Size(min = 2) val name: String,
    @get: Min(1) @get: Max(4000) val height: Int,
    @get: Size(min = 2) val homeworld: String) {

    constructor(entity: CharacterEntity) : this(entity.id, entity.name, entity.height, entity.homeworld)

    constructor(peopleDto: PeopleDto) : this(null, peopleDto.name, peopleDto.height.toInt(), peopleDto.homeworld)
}
