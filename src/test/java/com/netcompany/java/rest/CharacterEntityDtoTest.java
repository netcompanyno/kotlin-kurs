package com.netcompany.java.rest;

import com.netcompany.java.domain.Character;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link ThingDto}.
 */
public class CharacterDtoTest {

    @Test
    public void constructorSetsFieldsToCorrectValues() {
        final Character character = new Character("Toothbrush", "Bathroom");
        character.setId(42);

        final ThingDto thingDto = new ThingDto(character);

        assertEquals(42L, thingDto.getId());
        assertEquals("Toothbrush", thingDto.getName());
        assertEquals("Bathroom", thingDto.getLocation());
    }
}
