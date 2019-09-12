package com.netcompany.java.rest.integration;

import com.netcompany.java.Application;
import com.netcompany.java.database.CharacterRepository;
import com.netcompany.java.domain.Character;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CharacterControllerMockMvcTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CharacterRepository characterRepository;

    @Test
    public void getThingByIdReturnsExistingThing() throws Exception {
        final Character character = new Character("Soda", "Fridge");
        characterRepository.save(character);

        mvc.perform(MockMvcRequestBuilders.get("/character/{id}", character.getId())
                                          .accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.id", is(character.getId())))
           .andExpect(jsonPath("$.name", is("Soda")))
           .andExpect(jsonPath("$.location", is("Fridge")));
    }

    @Test
    public void getThingByReturnsNotFoundOnNonExistingThing() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/thing/{id}", 42L)
                                          .accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isNotFound())
           .andExpect(status().reason(containsString("Could not find thing")));
    }

    @Test
    public void getThingByNameReturnsExistingThing() throws Exception {
        final Character character = new Character("Soda", "Fridge");
        characterRepository.save(character);

        mvc.perform(MockMvcRequestBuilders.get("/character/name/{name}", "Soda")
                                          .accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$[0].id", is(character.getId())))
           .andExpect(jsonPath("$[0].name", is("Soda")))
           .andExpect(jsonPath("$[0].location", is("Fridge")));
    }

    @Test
    public void getThingByNameReturnsEmptyArrayOnNonExistingThing() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/thing/name/{name}", "nothing")
                                          .accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(content().json("[]"));
    }

    @Test
    public void getAllThingsReturnsEmptyArrayWhenNoThings() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/thing").accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(content().json("[]"));
    }

    @Test
    public void getAllThingsReturnsArrayOfThings() throws Exception {
        final Character tv = new Character("TV", "Living room");
        characterRepository.save(tv);
        final Character computer = new Character("Computer", "Office");
        characterRepository.save(computer);

        mvc.perform(MockMvcRequestBuilders.get("/thing").accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$[0].id", is(tv.getId())))
           .andExpect(jsonPath("$[0].name", is("TV")))
           .andExpect(jsonPath("$[0].location", is("Living room")))
           .andExpect(jsonPath("$[1].id", is(computer.getId())))
           .andExpect(jsonPath("$[1].name", is("Computer")))
           .andExpect(jsonPath("$[1].location", is("Office")));
    }
}
