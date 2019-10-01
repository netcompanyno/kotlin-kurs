package com.netcompany.characters.dto

import com.netcompany.characters.domain.CharacterEntity

data class CharacterDto(var name: String, var height: Int, var homeworld: String){
    constructor(entity: CharacterEntity): this(entity.name, entity.height, entity.homeworld)
}
