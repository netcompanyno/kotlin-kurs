package com.netcompany.characters.dto

import com.netcompany.characters.domain.CharacterEntity

data class CharacterDto(
    var id: Int?,
    var name: String,
    var height: Int,
    var homeworld: String) {

    constructor(entity: CharacterEntity) : this(entity.id, entity.name, entity.height, entity.homeworld)
}
