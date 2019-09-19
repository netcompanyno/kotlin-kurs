package com.netcompany.characters.service

import com.netcompany.characters.domain.CharacterEntity
import com.netcompany.characters.exception.CharacterNotFoundException
import com.netcompany.characters.repository.CharacterRepository
import org.junit.jupiter.api.assertThrows
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

/**
 * Tests for {@link CharacterService}.
 */
@RunWith(MockitoJUnitRunner::class)
class CharacterServiceTest {

    @InjectMocks
    lateinit var characterService: CharacterService

    @Mock
    lateinit var characterRepository: CharacterRepository

    @Test
    fun getByIdInvokesRepository() {
        `when`(characterRepository.findById(1))
            .thenReturn(Optional.of(CharacterEntity(1, "Luke Skywalker", 172, "Tatooine")))

        characterService.getById(1)

        verify(characterRepository).findById(1)
    }

    @Test
    fun getByIdConvertsAndReturnsResult() {
        val characterEntity = CharacterEntity(1, "Luke Skywalker", 172, "Tatooine")
        `when`(characterRepository.findById(1)).thenReturn(Optional.of(characterEntity))

        val retrievedThing = characterService.getById(1)

        assertNotNull(retrievedThing)
        assertEquals(1, retrievedThing.id)
        assertEquals("Luke Skywalker", retrievedThing.name)
        assertEquals(172, retrievedThing.height)
    }

    @Test
    fun getByIdThrowsExceptionWhenElementNotFound() {
        assertThrows<CharacterNotFoundException>("Character with id 1 not found") {
            characterService.getById(1)
        }
    }

    @Test
    fun getAllThingsInvokesRepository() {
        `when`(characterRepository.findAll()).thenReturn(emptyList())

        characterService.getAllCharacters()

        verify(characterRepository).findAll()
    }

    @Test
    fun getAllThingsConvertsAndReturnsResult() {
        val characterEntities =
            listOf(CharacterEntity(1, "Luke Skywalker", 172, "Tatooine"), CharacterEntity(2, "Yoda", 66, "unknown"))

        `when`(characterRepository.findAll()).thenReturn(characterEntities)

        val characterDtos = characterService.getAllCharacters()

        assertNotNull(characterDtos)
        assertEquals(2, characterDtos.size)

        assertEquals(1, characterDtos[0].id)
        assertEquals("Luke Skywalker", characterDtos[0].name)
        assertEquals(172, characterDtos[0].height)

        assertEquals(2, characterDtos[1].id)
        assertEquals("Yoda", characterDtos[1].name)
        assertEquals(66, characterDtos[1].height)
    }

    @Test
    fun getByNameInvokesRepository() {
        val characterEntity = CharacterEntity(1, "Luke Skywalker", 172, "Tatooine")

        `when`(characterRepository.findByName("Luke Skywalker")).thenReturn(listOf(characterEntity))

        characterService.getByName("Luke Skywalker")

        verify(characterRepository).findByName("Luke Skywalker")
    }

    @Test
    fun getByNameConvertsAndReturnsResult() {
        val characterEntity = CharacterEntity(1, "Luke Skywalker", 172, "Tatooine")

        `when`(characterRepository.findByName("Luke Skywalker")).thenReturn(listOf(characterEntity))

        val characterDto = characterService.getByName("Luke Skywalker")

        assertNotNull(characterDto)

        assertEquals(1, characterDto.id)
        assertEquals("Luke Skywalker", characterDto.name)
        assertEquals(172, characterDto.height)
    }
}
