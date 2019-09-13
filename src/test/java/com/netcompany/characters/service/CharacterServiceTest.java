package com.netcompany.characters.service;

import com.netcompany.characters.repository.CharacterRepository;
import com.netcompany.characters.domain.CharacterEntity;
import com.netcompany.characters.exception.CharacterNotFoundException;
import com.netcompany.characters.dto.CharacterDto;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link CharacterService}.
 */
@RunWith(MockitoJUnitRunner.class)
public class CharacterServiceTest {

    @InjectMocks
    private CharacterService characterService;

    @Mock
    private CharacterRepository characterRepository;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    @Test
    public void getByIdInvokesRepository() {
        when(characterRepository.findById(1)).thenReturn(Optional.of(new CharacterEntity()));

        characterService.getById(1);

        verify(characterRepository).findById(1);
    }

    @Test
    public void getByIdConvertsAndReturnsResult() {
        final CharacterEntity characterEntity = new CharacterEntity(1, "Luke Skywalker", 172);
        when(characterRepository.findById(1)).thenReturn(Optional.of(characterEntity));

        final CharacterDto retrievedThing = characterService.getById(1);

        assertNotNull(retrievedThing);
        assertEquals(1L, retrievedThing.getId());
        assertEquals("Luke Skywalker", retrievedThing.getName());
        assertEquals(172, retrievedThing.getHeight());
    }

    @Test
    public void getByIdThrowsExceptionWhenElementNotFound() {
        expectedException.expect(CharacterNotFoundException.class);
        expectedException.expectMessage("Character with id 1 not found");

        characterService.getById(1);
    }

    @Test
    public void getAllThingsInvokesRepository() {
        when(characterRepository.findAll()).thenReturn(new ArrayList<>());

        characterService.getAllCharacters();

        verify(characterRepository).findAll();
    }

    @Test
    public void getAllThingsConvertsAndReturnsResult() {
        final List<CharacterEntity> characterEntities =
                List.of(new CharacterEntity(1, "Luke Skywalker", 172), new CharacterEntity(2, "Yoda", 66));

        when(characterRepository.findAll()).thenReturn(characterEntities);

        final List<CharacterDto> characterDtos = characterService.getAllCharacters();

        assertNotNull(characterDtos);
        assertEquals(2, characterDtos.size());

        assertEquals(1L, characterDtos.get(0).getId());
        assertEquals("Luke Skywalker", characterDtos.get(0).getName());
        assertEquals(172, characterDtos.get(0).getHeight());

        assertEquals(2L, characterDtos.get(1).getId());
        assertEquals("Yoda", characterDtos.get(1).getName());
        assertEquals(66, characterDtos.get(1).getHeight());
    }

    @Test
    public void getByNameInvokesRepository() {
        final CharacterEntity characterEntity = new CharacterEntity(1, "Luke Skywalker", 172);

        when(characterRepository.findByName("Luke Skywalker")).thenReturn(List.of(characterEntity));

        characterService.getByName("Luke Skywalker");

        verify(characterRepository).findByName("Luke Skywalker");
    }

    @Test
    public void getByNameConvertsAndReturnsResult() {
        final CharacterEntity characterEntity = new CharacterEntity(1, "Luke Skywalker", 172);

        when(characterRepository.findByName("Luke Skywalker")).thenReturn(List.of(characterEntity));

        final CharacterDto characterDto = characterService.getByName("Luke Skywalker");

        assertNotNull(characterDto);

        assertEquals(1L, characterDto.getId());
        assertEquals("Luke Skywalker", characterDto.getName());
        assertEquals(172, characterDto.getHeight());
    }
}
