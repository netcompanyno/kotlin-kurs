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
        val character = CharacterDto("Luke Skywalker", 172, "Tatooine")

        `when`(characterService.getCharacters()).thenReturn(listOf(character))

        val result = characterController.getCharacters()

        assertNotNull(result)
        assertEquals(1, result.size)
        assertSame(character, result[0])

        verify(characterService).getCharacters()
    }

}
