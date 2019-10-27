package com.netcompany.characters.dto

import com.netcompany.characters.domain.CharacterEntity

data class CharacterDto(val name: String, val height: Int, val homeworld: String){
    constructor(entity: CharacterEntity): this(entity.name, entity.height, entity.homeworld)
}
