package com.netcompany.characters.repository

import com.netcompany.characters.domain.CharacterEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Oppgave 4
 *
 * Fullfør initialiseringen av dette interfacet for å gjøre det mulig å håndtere databaseoperasjoner for characters.
 * Entitetsobjektet er CharacterEntity, og id skal være av typen Int.
 */
@Repository
interface CharacterRepository : JpaRepository<CharacterEntity, Int>