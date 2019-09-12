package com.netcompany.characters.rest;

import com.netcompany.characters.dto.CharacterDto;
import com.netcompany.characters.service.CharacterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests {@link CharacterController}
 */
@RunWith(MockitoJUnitRunner.class)
public class CharacterEntityControllerTest {

    @InjectMocks
    private CharacterController characterController;

    @Mock
    private CharacterService characterService;

    @Test
    public void getByIdCallsServiceAndReturnsResult() {
        final CharacterDto expected = new CharacterDto(0, "Soda", "Fridge");
        when(characterService.getById(1L)).thenReturn(expected);

        final CharacterDto result = characterController.getById(1L);

        assertNotNull(result);
        assertSame(expected, result);

        verify(characterService).getById(1L);
    }

    @Test
    public void getAllCharactersCallsServiceAndReturnsResult() {
        final List<CharacterDto> expected = new ArrayList<>();
        when(characterService.getAllCharacters()).thenReturn(expected);

        final List<CharacterDto> result = characterController.getAllCharacters();

        assertNotNull(result);
        assertSame(expected, result);

        verify(characterService).getAllCharacters();
    }

    @Test
    public void getByNameCallsServiceAndReturnsResults() {
        final CharacterDto expected = new CharacterDto(0, "Soda", "Fridge");

        when(characterService.getByName("someCharacter")).thenReturn(expected);

        final CharacterDto result = characterController.getByName("someCharacter");

        assertNotNull(result);
        assertSame(expected, result);

        verify(characterService).getByName("someCharacter");
    }
}
