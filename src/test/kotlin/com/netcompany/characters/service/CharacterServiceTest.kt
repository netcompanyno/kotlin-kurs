package com.netcompany.characters.service

import com.netcompany.characters.domain.CharacterEntity
import com.netcompany.characters.repository.CharacterRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

/**
 * Oppgave 4
 *
 * Når du er ferdig med oppgaven kan du kommentere inn disse testene og kjøre dem.
 */
@RunWith(MockitoJUnitRunner::class)
class CharacterServiceTest {
    @InjectMocks
    lateinit var characterService: CharacterService

    @Mock
    lateinit var characterRepository: CharacterRepository

/*

    @Test
    fun getCharactersInvokesRepository() {
        Mockito.`when`(characterRepository.findAll()).thenReturn(emptyList())

        characterService.getCharacters()

        Mockito.verify(characterRepository).findAll()
    }

    @Test
    fun getCharactersConvertsAndReturnsResult() {
        val characterEntities =
            listOf(CharacterEntity("Luke Skywalker", 172, "Tatooine"), CharacterEntity("Yoda", 66, "unknown"))

        Mockito.`when`(characterRepository.findAll()).thenReturn(characterEntities)

        val characterDtos = characterService.getCharacters()

        assertNotNull(characterDtos)
        assertEquals(2, characterDtos.size)

        assertEquals("Luke Skywalker", characterDtos[0].name)
        assertEquals(172, characterDtos[0].height)

        assertEquals("Yoda", characterDtos[1].name)
        assertEquals(66, characterDtos[1].height)
    }
*/

}