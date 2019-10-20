package com.netcompany.characters.service

import com.netcompany.characters.domain.CharacterEntity
import com.netcompany.characters.dto.CharacterDto
import com.netcompany.characters.repository.CharacterRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@RunWith(MockitoJUnitRunner::class)
class CharacterServiceTest {
    @InjectMocks
    lateinit var characterService: CharacterService

    @Mock
    lateinit var characterRepository: CharacterRepository


    @Test
    fun getCharactersInvokesRepository() {
        `when`(characterRepository.findAll()).thenReturn(emptyList())

        characterService.getCharacters()

        verify(characterRepository).findAll()
    }

    @Test
    fun getCharactersConvertsAndReturnsResult() {
        val characterEntities =
            listOf(CharacterEntity("Luke Skywalker", 172, "Tatooine"), CharacterEntity("Yoda", 66, "unknown"))

        `when`(characterRepository.findAll()).thenReturn(characterEntities)

        val characterDtos = characterService.getCharacters()

        assertNotNull(characterDtos)
        assertEquals(2, characterDtos.size)

        assertEquals("Luke Skywalker", characterDtos[0].name)
        assertEquals(172, characterDtos[0].height)

        assertEquals("Yoda", characterDtos[1].name)
        assertEquals(66, characterDtos[1].height)
    }

    @Test
    fun createCharacterInvokesRepository() {
        val characterDto = CharacterDto(null, "Luke Skywalker", 172, "Tattooine")

       `when`(characterRepository.save(any(CharacterEntity::class.java)))
           .thenReturn(CharacterEntity("Luke Skywalker", 172, "Tattooine"))

        characterService.createCharacter(characterDto)

        verify(characterRepository).save(any(CharacterEntity::class.java))
    }

    @Test
    fun createCharacterReturnsCreatedCharacter() {

        val characterEntity = CharacterEntity("Luke Skywalker", 172, "Tattooine")
        `when`(characterRepository.save(any(CharacterEntity::class.java)))
            .thenReturn(characterEntity)

        val createdCharacterDto = characterService.createCharacter(CharacterDto(null, "Luke Skywalker", 172, "Tattooine"))


        assertEquals(characterEntity.name, createdCharacterDto.name)
        assertEquals(characterEntity.homeworld, createdCharacterDto.homeworld)
        assertEquals(characterEntity.height, createdCharacterDto.height)
    }
}
