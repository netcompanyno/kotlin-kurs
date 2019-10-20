package com.netcompany.characters.rest

import com.netcompany.characters.dto.CharacterDto
import com.netcompany.characters.service.CharacterService
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertSame
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertEquals

@RunWith(MockitoJUnitRunner::class)
class CharacterControllerTest {

    @InjectMocks
    lateinit var characterController: CharacterController

    @Mock
    lateinit var characterService: CharacterService


    @Test
    fun getCharactersCallsGetCharactersInService() {
        val character = CharacterDto(1, "Luke Skywalker", 172, "Tatooine")

        `when`(characterService.getCharacters()).thenReturn(listOf(character))

        val result = characterController.getCharacters()

        assertNotNull(result)
        assertEquals(1, result.size)
        assertSame(character, result[0])

        verify(characterService).getCharacters()
    }

    @Test
    fun createCharacterCallsCreateCharacterInService() {
        val character = CharacterDto(null, "Luke Skywalker", 172, "Tatooine")

        characterController.createCharacter(character)

        verify(characterService).createCharacter(character)
    }

    @Test
    fun getByIdCallsServiceAndReturnsResult() {
        val expected = CharacterDto(1, "Luke Skywalker", 172, "Tatooine")

        `when`(characterService.getById(1)).thenReturn(expected)

        val result = characterController.getById(1)

        assertNotNull(result)
        assertSame(expected, result)

        verify(characterService).getById(1)
    }
}
