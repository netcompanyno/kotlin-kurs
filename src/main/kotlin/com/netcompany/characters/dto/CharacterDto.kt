package com.netcompany.characters.dto

import com.netcompany.characters.domain.CharacterEntity

data class CharacterDto(
    var id: Int?,
    var name: String,
    var height: Int,
    var homeworld: String) {

    init {
        require(name.length >= 2) { "Name must have length >= 2!" }
        require(height in 1..4000) { "Height must be between 0 and 4000!" }
        require(homeworld.length >= 2) { "Homeworld must have length >= 2!" }
    }

    constructor(entity: CharacterEntity) : this(entity.id, entity.name, entity.height, entity.homeworld)
}
