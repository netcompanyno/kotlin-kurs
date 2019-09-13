package com.netcompany.characters.rest.integration;

import com.netcompany.characters.Application;
import com.netcompany.characters.repository.CharacterRepository;
import com.netcompany.characters.domain.CharacterEntity;
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
        final CharacterEntity characterEntity = new CharacterEntity(1, "Luke Skywalker", 172);
        characterRepository.save(characterEntity);

        mvc.perform(MockMvcRequestBuilders.get("/characters/{id}", characterEntity.getId())
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(characterEntity.getId())))
            .andExpect(jsonPath("$.name", is("Luke Skywalker")))
            .andExpect(jsonPath("$.height", is(172)));
    }

    @Test
    public void getCharacterByIdReturnsNotFoundOnNonExistingCharacter() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/characters/42")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound())
            .andExpect(status().reason(containsString("Could not find character")));
    }

    @Test
    public void getCharacterByNameReturnsExistingCharacter() throws Exception {
        final CharacterEntity characterEntity = new CharacterEntity(1, "Yoda", 66);
        characterRepository.save(characterEntity);

        mvc.perform(MockMvcRequestBuilders.get("/characters/name/Yoda")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(characterEntity.getId())))
            .andExpect(jsonPath("$.name", is("Yoda")))
            .andExpect(jsonPath("$.height", is(66)));
    }

    @Test
    public void getCharacterByNameReturnsNotFoundOnNonExistingCharacter() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/characters/name/Yoda")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound())
            .andExpect(status().reason(containsString("Could not find character")));
    }

    @Test
    public void getAllCharactersReturnsEmptyArrayWhenNoCharacters() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/characters")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json("[]"));
    }

    @Test
    public void getAllCharactersReturnsArrayOfCharacters() throws Exception {
        final CharacterEntity luke = new CharacterEntity(1, "Luke Skywalker", 172);
        characterRepository.save(luke);
        final CharacterEntity yoda = new CharacterEntity(2, "Yoda", 66);
        characterRepository.save(yoda);

        mvc.perform(MockMvcRequestBuilders.get("/characters").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id", is(luke.getId())))
            .andExpect(jsonPath("$[0].name", is("Luke Skywalker")))
            .andExpect(jsonPath("$[0].height", is(172)))
            .andExpect(jsonPath("$[1].id", is(yoda.getId())))
            .andExpect(jsonPath("$[1].name", is("Yoda")))
            .andExpect(jsonPath("$[1].height", is(66)));
    }
}
