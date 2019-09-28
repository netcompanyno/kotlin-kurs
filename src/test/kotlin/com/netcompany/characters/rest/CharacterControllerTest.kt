package com.netcompany.characters.rest

import com.netcompany.characters.dto.CharacterDto
import com.netcompany.characters.service.CharacterService
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertEquals

/**
 * Oppgave 3
 *
 * Denne testen er kommentert ut fordi koden i utgangspunktet ikke vil kompilere. Når du har gjort oppgaven kan du
 * kommentere inn testen igjen og kjøre den.
 */
@RunWith(MockitoJUnitRunner::class)
class CharacterControllerTest {

    @InjectMocks
    lateinit var characterController: CharacterController

    @Mock
    lateinit var characterService: CharacterService


/*
    @Test
    fun getCharactersCallsGetCharactersInService() {
        val character = CharacterDto("Luke Skywalker", 172, "Tatooine")

        `when`(characterService.getCharacters()).thenReturn(listOf(character))

        val result = characterController.getCharacters()

        assertNotNull(result)
        assertEquals(1, result.size)
        assertSame(character, result[0])

        verify(characterService).getCharacters()
    }
*/

}
