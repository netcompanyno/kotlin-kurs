package com.netcompany.characters.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Oppgave 4
 *
 * Lag en klasse som representerer databaseentiteten for en character.
 * Den skal ha samme felter som CharacterDto.
 *
 * I tillegg må vi ha et felt som kan være nøkkel i tabellen. Legg derfor også til feltet id.
 */
@Entity(name = "Character")
data class CharacterEntity(var name: String, var height: Int, var homeworld: String) {
    @Id
    @GeneratedValue
    var id: Int = 0
}
