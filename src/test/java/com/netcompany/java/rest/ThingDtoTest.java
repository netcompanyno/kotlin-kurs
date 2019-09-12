package com.netcompany.java.rest;

import com.netcompany.java.domain.Thing;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link ThingDto}.
 */
public class ThingDtoTest {

    @Test
    public void constructorSetsFieldsToCorrectValues() {
        final Thing thing = new Thing("Toothbrush", "Bathroom");
        thing.setId(42);

        final ThingDto thingDto = new ThingDto(thing);

        assertEquals(42L, thingDto.getId());
        assertEquals("Toothbrush", thingDto.getName());
        assertEquals("Bathroom", thingDto.getLocation());
    }
}
