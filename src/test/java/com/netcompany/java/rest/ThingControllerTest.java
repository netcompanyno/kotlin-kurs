package com.netcompany.java.rest;

import com.netcompany.java.service.ThingService;
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
 * Tests {@link ThingController}
 */
@RunWith(MockitoJUnitRunner.class)
public class ThingControllerTest {

    @InjectMocks
    private ThingController thingController;

    @Mock
    private ThingService thingService;

    @Test
    public void getByIdCallsServiceAndReturnsResult() {
        final ThingDto expected = new ThingDto(0, "Soda", "Fridge");
        when(thingService.getById(1L)).thenReturn(expected);

        final ThingDto result = thingController.getById(1L);

        assertNotNull(result);
        assertSame(expected, result);

        verify(thingService).getById(1L);
    }

    @Test
    public void getAllThingsCallsServiceAndReturnsResult() {
        final List<ThingDto> expected = new ArrayList<>();
        when(thingService.getAllThings()).thenReturn(expected);

        final List<ThingDto> result = thingController.getAllThings();

        assertNotNull(result);
        assertSame(expected, result);

        verify(thingService).getAllThings();
    }

    @Test
    public void getByNameCallsServiceAndReturnsResults() {
        final ThingDto expected = new ThingDto(0, "Soda", "Fridge");

        when(thingService.getByName("something")).thenReturn(expected);

        final ThingDto result = thingController.getByName("something");

        assertNotNull(result);
        assertSame(expected, result);

        verify(thingService).getByName("something");
    }
}
