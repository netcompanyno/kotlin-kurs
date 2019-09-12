package com.netcompany.java.service;

import com.netcompany.java.database.ThingRepository;
import com.netcompany.java.domain.Thing;
import com.netcompany.java.exception.ThingNotFoundException;
import com.netcompany.java.rest.ThingDto;
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
 * Tests for {@link ThingService}.
 */
@RunWith(MockitoJUnitRunner.class)
public class ThingServiceTest {

    @InjectMocks
    private ThingService thingService;

    @Mock
    private ThingRepository thingRepository;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private String thingCreatedQueue;
    private String messageReceivedQueue;
    private String thingChangedQueue;

    @Before
    public void setup() {
        thingCreatedQueue = "thing.created";
        messageReceivedQueue = "message.received";
        thingChangedQueue = "thing.changed";

        ReflectionTestUtils.setField(thingService, "thingCreatedQueue", thingCreatedQueue);
        ReflectionTestUtils.setField(thingService, "messageReceivedQueue", messageReceivedQueue);
        ReflectionTestUtils.setField(thingService, "thingChangedQueue", thingChangedQueue);
    }

    @Test
    public void getByIdInvokesRepository() {
        when(thingRepository.findById(1L)).thenReturn(Optional.of(new Thing()));

        thingService.getById(1L);

        verify(thingRepository).findById(1L);
    }

    @Test
    public void getByIdConvertsAndReturnsResult() {
        final Thing thing = new Thing("Jacket", "Closet");
        when(thingRepository.findById(1L)).thenReturn(Optional.of(thing));

        final ThingDto retrievedThing = thingService.getById(1L);

        assertNotNull(retrievedThing);
        assertEquals(1L, retrievedThing.getId());
        assertEquals("Jacket", retrievedThing.getName());
        assertEquals("Closet", retrievedThing.getLocation());
    }

    @Test
    public void getByIdThrowsExceptionWhenElementNotFound() {
        expectedException.expect(ThingNotFoundException.class);
        expectedException.expectMessage("No thing with id=1");

        thingService.getById(1L);
    }

    @Test
    public void getAllThingsInvokesRepository() {
        when(thingRepository.findAll()).thenReturn(new ArrayList<>());

        thingService.getAllThings();

        verify(thingRepository).findAll();
    }

    @Test
    public void getAllThingsConvertsAndReturnsResult() {
        final List<Thing> things =
                List.of(new Thing(1, "banana", "kitchen"), new Thing(2, "tv", "bedroom"));

        when(thingRepository.findAll()).thenReturn(things);

        final List<ThingDto> thingDtos = thingService.getAllThings();

        assertNotNull(thingDtos);
        assertEquals(2, thingDtos.size());

        assertEquals(1L, thingDtos.get(0).getId());
        assertEquals("banana", thingDtos.get(0).getName());
        assertEquals("kitchen", thingDtos.get(0).getLocation());

        assertEquals(2L, thingDtos.get(1).getId());
        assertEquals("tv", thingDtos.get(1).getName());
        assertEquals("bed room", thingDtos.get(1).getLocation());
    }

    @Test
    public void getByNameInvokesRepository() {
        when(thingRepository.findByName("something")).thenReturn(new ArrayList<>());

        thingService.getByName("something");

        verify(thingRepository).findByName("something");
    }

    @Test
    public void getByNameConvertsAndReturnsResult() {
        final List<Thing> things =
                List.of(new Thing(1, "tv", "living room"), new Thing(2, "tv", "bedroom"));

        when(thingRepository.findByName("tv")).thenReturn(things);

        final ThingDto thingDto = thingService.getByName("tv");

        assertNotNull(thingDto);

        assertEquals(1L, thingDto.getId());
        assertEquals("tv", thingDto.getName());
        assertEquals("living room", thingDto.getLocation());

    }
}
