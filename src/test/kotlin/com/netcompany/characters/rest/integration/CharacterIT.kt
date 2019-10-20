package com.netcompany.characters.rest.integration

import com.netcompany.characters.Application
import com.netcompany.characters.domain.CharacterEntity
import org.hamcrest.Matchers
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.notNullValue
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
@RunWith(SpringRunner::class)
@SpringBootTest(classes = [Application::class])
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CharacterIT {
    @Autowired
    lateinit var mvc: MockMvc


    @Test
    fun helloReturnsHelloString() {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$", `is`("Hello, Yoda!")))
    }

    @Test
    @Throws(Exception::class)
    fun getCharactersReturnsCharacters() {
        mvc.perform(MockMvcRequestBuilders.get("/characters").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.length()", `is`(2)))
            .andExpect(jsonPath("$[0].name", notNullValue()))
            .andExpect(jsonPath("$[0].height", notNullValue()))
            .andExpect(jsonPath("$[0].homeworld", notNullValue()))
            .andExpect(jsonPath("$[1].name", notNullValue()))
            .andExpect(jsonPath("$[1].height", notNullValue()))
            .andExpect(jsonPath("$[1].homeworld", notNullValue()))
    }

    @Test
    fun createCharacterCreatesCharacter() {
        val character = "{\"name\": \"Chewbacca\"," +
            "\"homeworld\": \"Kashyyyk\"," +
            "\"height\": 228}"

        mvc.perform(MockMvcRequestBuilders.post("/characters").contentType(MediaType.APPLICATION_JSON).content(character))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.name", `is`("Chewbacca")))
            .andExpect(jsonPath("$.homeworld", `is`("Kashyyyk")))
            .andExpect(jsonPath("$.height", `is`(228)))

        mvc.perform(MockMvcRequestBuilders.get("/characters").accept(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.length()", `is`(3)))
            .andExpect(jsonPath("$[2].name", `is`("Chewbacca")))
            .andExpect(jsonPath("$[2].homeworld", `is`("Kashyyyk")))
            .andExpect(jsonPath("$[2].height", `is`(228)))
    }

    @Test
    @Throws(Exception::class)
    fun getCharacterByIdReturnsExistingCharacter() {
        mvc.perform(MockMvcRequestBuilders.get("/characters/1").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.id", `is`(1)))
            .andExpect(jsonPath("$.name", `is`("Yoda")))
            .andExpect(jsonPath("$.height", `is`(66)))
            .andExpect(jsonPath("$.homeworld", `is`("unknown")))
    }

    @Test
    @Throws(Exception::class)
    fun getCharacterByIdReturnsNotFoundOnNonExistingCharacter() {
        mvc.perform(MockMvcRequestBuilders.get("/characters/42").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound)
            .andExpect(status().reason(Matchers.containsString("Could not find character")))
    }

}
