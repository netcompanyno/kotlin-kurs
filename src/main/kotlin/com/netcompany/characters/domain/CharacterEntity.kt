package com.netcompany.characters.domain

import com.netcompany.characters.dto.CharacterDto
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "Character")
data class CharacterEntity(var name: String, var height: Int, var homeworld: String) {
    @Id
    @GeneratedValue
    var id: Int = 0

    constructor(dto: CharacterDto): this(dto.name, dto.height, dto.homeworld)
}
