package com.netcompany.characters.rest

import com.netcompany.characters.dto.CharacterDto
import com.netcompany.characters.service.CharacterService
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertSame
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.Test

/**
 * Tests [CharacterController]
 */
@RunWith(MockitoJUnitRunner::class)
class CharacterControllerTest {

    @InjectMocks
    lateinit var characterController: CharacterController

    @Mock
    lateinit var characterService: CharacterService


    @Test
    fun getByIdCallsServiceAndReturnsResult() {
        val expected = CharacterDto(0, "Luke Skywalker", 172, "Tatooine")

        `when`(characterService.getById(1)).thenReturn(expected)

        val result = characterController.getById(1)

        assertNotNull(result)
        assertSame(expected, result)

        verify(characterService).getById(1)
    }

    @Test
    fun getCharactersCallGetAllCharactersInServiceIfNameIsNotSupplied() {
        val expected = ArrayList<CharacterDto>()
        `when`(characterService.getAllCharacters()).thenReturn(expected)

        val result = characterController.getCharacters(null)

        assertNotNull(result)
        assertSame(expected, result)

        verify(characterService).getAllCharacters()
    }

    @Test
    fun getCharactersCallsGetByNameInServiceIfNameIsSupplied() {
        val expected = listOf(CharacterDto(0, "Yoda", 66, "unknown"))

        `when`(characterService.getByName("Yoda")).thenReturn(expected)

        val result = characterController.getCharacters("Yoda")

        assertNotNull(result)
        assertSame(expected, result)

        verify(characterService).getByName("Yoda")
    }
}
