package com.netcompany.characters.dto

import com.netcompany.characters.domain.CharacterEntity

/**
 * Oppgave 7
 *
 * Legg på validering av feltene i denne klassen. For eksempel bør ikke name kunne være tomt, eller høyde være negativ
 * eller 0.
 *
 * Når du har løst oppgaven kan du prøve å lage en ugyldig karakter fra frontend og skal da kunne se feilmeldingenen.
 * Du kan også kjøre testene i CharacterIT.
 */
data class CharacterDto(
    val id: Int?,
    val name: String,
    val height: Int,
    val homeworld: String) {

    constructor(entity: CharacterEntity) : this(entity.id, entity.name, entity.height, entity.homeworld)
}
