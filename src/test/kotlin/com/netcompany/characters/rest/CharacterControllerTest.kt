package com.netcompany.characters.rest

import com.netcompany.characters.dto.CharacterDto
import com.netcompany.characters.service.CharacterService
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import java.util.ArrayList

import org.junit.Assert.*
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

/**
 * Tests [CharacterController]
 */
class CharacterControllerTest {

    @InjectMocks
    lateinit var characterController: CharacterController

    @Mock
    lateinit var characterService: CharacterService

    @Test
    fun getByIdCallsServiceAndReturnsResult() {
        val expected = CharacterDto(0, "Luke Skywalker", 172)

        `when`(characterService.getById(1)).thenReturn(expected)

        val result = characterController.getById(1)

        assertNotNull(result)
        assertSame(expected, result)

        verify(characterService).getById(1)
    }

    @Test
    fun getAllCharactersCallsServiceAndReturnsResult() {
        val expected = ArrayList<CharacterDto>()
        `when`(characterService.getAllCharacters()).thenReturn(expected)

        val result = characterController.getAllCharacters()

        assertNotNull(result)
        assertSame(expected, result)

        verify(characterService).getAllCharacters()
    }

    @Test
    fun getByNameCallsServiceAndReturnsResults() {
        val expected = CharacterDto(0, "Yoda", 66)

        `when`(characterService.getByName("Yoda")).thenReturn(expected)

        val result = characterController.getByName("Yoda")

        assertNotNull(result)
        assertSame(expected, result)

        verify(characterService).getByName("Yoda")
    }
}
