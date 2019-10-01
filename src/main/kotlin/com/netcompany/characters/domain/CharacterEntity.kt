package com.netcompany.characters.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "Character")
data class CharacterEntity(var name: String, var height: Int, var homeworld: String) {
    @Id
    @GeneratedValue
    var id: Int = 0
}
