package com.netcompany.characters.repository

import com.netcompany.characters.domain.CharacterEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CharacterRepository : JpaRepository<CharacterEntity, Int>