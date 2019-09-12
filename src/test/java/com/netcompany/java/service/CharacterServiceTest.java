package com.netcompany.java.service;

import com.netcompany.java.repository.CharacterRepository;
import com.netcompany.java.domain.CharacterEntity;
import com.netcompany.java.exception.CharacterNotFoundException;
import com.netcompany.java.dto.CharacterDto;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

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
        when(characterRepository.findById(1L)).thenReturn(Optional.of(new CharacterEntity()));

        characterService.getById(1L);

        verify(characterRepository).findById(1L);
    }

    @Test
    public void getByIdConvertsAndReturnsResult() {
        final CharacterEntity characterEntity = new CharacterEntity("Jacket", "Closet");
        when(characterRepository.findById(1L)).thenReturn(Optional.of(characterEntity));

        final CharacterDto retrievedThing = characterService.getById(1L);

        assertNotNull(retrievedThing);
        assertEquals(1L, retrievedThing.getId());
        assertEquals("Jacket", retrievedThing.getName());
        assertEquals("Closet", retrievedThing.getLocation());
    }

    @Test
    public void getByIdThrowsExceptionWhenElementNotFound() {
        expectedException.expect(CharacterNotFoundException.class);
        expectedException.expectMessage("No thing with id=1");

        characterService.getById(1L);
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
                List.of(new CharacterEntity(1, "banana", "kitchen"), new CharacterEntity(2, "tv", "bedroom"));

        when(characterRepository.findAll()).thenReturn(characterEntities);

        final List<CharacterDto> characterDtos = characterService.getAllCharacters();

        assertNotNull(characterDtos);
        assertEquals(2, characterDtos.size());

        assertEquals(1L, characterDtos.get(0).getId());
        assertEquals("banana", characterDtos.get(0).getName());
        assertEquals("kitchen", characterDtos.get(0).getLocation());

        assertEquals(2L, characterDtos.get(1).getId());
        assertEquals("tv", characterDtos.get(1).getName());
        assertEquals("bed room", characterDtos.get(1).getLocation());
    }

    @Test
    public void getByNameInvokesRepository() {
        when(characterRepository.findByName("something")).thenReturn(new ArrayList<>());

        characterService.getByName("something");

        verify(characterRepository).findByName("something");
    }

    @Test
    public void getByNameConvertsAndReturnsResult() {
        final List<CharacterEntity> characterEntities =
                List.of(new CharacterEntity(1, "tv", "living room"), new CharacterEntity(2, "tv", "bedroom"));

        when(characterRepository.findByName("tv")).thenReturn(characterEntities);

        final CharacterDto characterDto = characterService.getByName("tv");

        assertNotNull(characterDto);

        assertEquals(1L, characterDto.getId());
        assertEquals("tv", characterDto.getName());
        assertEquals("living room", characterDto.getLocation());
    }
}
