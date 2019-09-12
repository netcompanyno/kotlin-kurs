package com.netcompany.java.rest.integration;

import com.netcompany.java.Application;
import com.netcompany.java.repository.CharacterRepository;
import com.netcompany.java.domain.CharacterEntity;
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
public class CharacterEntityControllerMockMvcTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CharacterRepository characterRepository;

    @Test
    public void getCharacterByIdReturnsExistingCharacter() throws Exception {
        final CharacterEntity characterEntity = new CharacterEntity("Soda", "Fridge");
        characterRepository.save(characterEntity);

        mvc.perform(MockMvcRequestBuilders.get("/characterEntity/{id}", characterEntity.getId())
                                          .accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.id", is(characterEntity.getId())))
           .andExpect(jsonPath("$.name", is("Soda")))
           .andExpect(jsonPath("$.location", is("Fridge")));
    }

    @Test
    public void getCharacterByReturnsNotFoundOnNonExistingCharacter() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/characters/{id}", 42L)
                                          .accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isNotFound())
           .andExpect(status().reason(containsString("Could not find character")));
    }

    @Test
    public void getCharacterByNameReturnsExistingCharacter() throws Exception {
        final CharacterEntity characterEntity = new CharacterEntity("Soda", "Fridge");
        characterRepository.save(characterEntity);

        mvc.perform(MockMvcRequestBuilders.get("/characterEntity/name/{name}", "Soda")
                                          .accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$[0].id", is(characterEntity.getId())))
           .andExpect(jsonPath("$[0].name", is("Soda")))
           .andExpect(jsonPath("$[0].location", is("Fridge")));
    }

    @Test
    public void getCharacterByNameReturnsEmptyArrayOnNonExistingCharacter() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/characters/name/{name}", "nocharacter")
                                          .accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(content().json("[]"));
    }

    @Test
    public void getAllCharactersReturnsEmptyArrayWhenNoCharacters() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/character").accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(content().json("[]"));
    }

    @Test
    public void getAllCharactersReturnsArrayOfCharacters() throws Exception {
        final CharacterEntity tv = new CharacterEntity("TV", "Living room");
        characterRepository.save(tv);
        final CharacterEntity computer = new CharacterEntity("Computer", "Office");
        characterRepository.save(computer);

        mvc.perform(MockMvcRequestBuilders.get("/character").accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$[0].id", is(tv.getId())))
           .andExpect(jsonPath("$[0].name", is("TV")))
           .andExpect(jsonPath("$[0].location", is("Living room")))
           .andExpect(jsonPath("$[1].id", is(computer.getId())))
           .andExpect(jsonPath("$[1].name", is("Computer")))
           .andExpect(jsonPath("$[1].location", is("Office")));
    }
}
