package com.netcompany.characters.service

import com.netcompany.characters.dto.CharacterDto
import org.springframework.stereotype.Service

/**
 * Oppgave 4
 *
 * Foreløpig intialiserer vi kun en character her i Servicen - vi ønsker nå å bruke databasen i stedet.
 *
 * For at dette skal være mulig må vi først opprette en klasse som representerer databaseobjektet.
 * Gå til filen CharacterEntity og fullfør denne, og kom så tilbake hit.
 *
 * For å hente ut fra databasen trenger man også et Repository. Dette er påbegynt i filen CharacterRepository.
 * Fullfør dette, og kall det i stedet i getCharacters().
 *
 * Siden vi foreløpig kun har laget en metode for å hente ut data fra databasen vil det i utgangspunktet ikke finnes
 * noe data der. Vi har derimot satt opp et script som setter inn noen characters i databasen slik at man har noe å
 * hente ut.
 */
@Service
class CharacterService {
    /**
     * Gets all the characters.
     *
     * @return a list of characters
     */
    fun getCharacters(): List<CharacterDto> {
        return listOf(CharacterDto("Yoda", 66, "unknown"))
    }
}
