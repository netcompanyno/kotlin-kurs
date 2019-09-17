package com.netcompany.characters.rest.integration

import com.netcompany.characters.Application
import com.netcompany.characters.repository.CharacterRepository
import com.netcompany.characters.domain.CharacterEntity
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

import org.hamcrest.Matchers.containsString
import org.hamcrest.Matchers.`is`
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@AutoConfigureMockMvc
@ActiveProfiles("test")
@RunWith(SpringRunner::class)
@SpringBootTest(classes = [Application::class])
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CharacterIT {
    @Autowired
    lateinit var mvc: MockMvc

    @Autowired
    lateinit var characterRepository: CharacterRepository

    @Test
    @Throws(Exception::class)
    fun getCharacterByIdReturnsExistingCharacter() {
        val characterEntity = CharacterEntity(1, "Luke Skywalker", 172)

        characterRepository.save(characterEntity)

        mvc.perform(MockMvcRequestBuilders.get("/characters/1").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.id", `is`(characterEntity.id)))
            .andExpect(jsonPath("$.name", `is`("Luke Skywalker")))
            .andExpect(jsonPath("$.height", `is`(172)))
    }

    @Test
    @Throws(Exception::class)
    fun getCharacterByIdReturnsNotFoundOnNonExistingCharacter() {
        mvc.perform(MockMvcRequestBuilders.get("/characters/42").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound)
            .andExpect(status().reason(containsString("Could not find character")))
    }

    @Test
    @Throws(Exception::class)
    fun getCharacterByNameReturnsExistingCharacter() {
        val characterEntity = CharacterEntity(1, "Yoda", 66)

        characterRepository.save(characterEntity)

        mvc.perform(MockMvcRequestBuilders.get("/characters/name/Yoda").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.id", `is`(characterEntity.id)))
            .andExpect(jsonPath("$.name", `is`("Yoda")))
            .andExpect(jsonPath("$.height", `is`(66)))
    }

    @Test
    @Throws(Exception::class)
    fun getCharacterByNameReturnsNotFoundOnNonExistingCharacter() {
        mvc.perform(MockMvcRequestBuilders.get("/characters/name/Yoda").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound)
            .andExpect(status().reason(containsString("Could not find character")))
    }

    @Test
    @Throws(Exception::class)
    fun getAllCharactersReturnsEmptyArrayWhenNoCharacters() {
        mvc.perform(MockMvcRequestBuilders.get("/characters").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().json("[]"))
    }

    @Test
    @Throws(Exception::class)
    fun getAllCharactersReturnsArrayOfCharacters() {
        val luke = CharacterEntity(1, "Luke Skywalker", 172)
        characterRepository.save(luke)
        val yoda = CharacterEntity(2, "Yoda", 66)
        characterRepository.save(yoda)

        mvc.perform(MockMvcRequestBuilders.get("/characters").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].id", `is`(luke.id)))
            .andExpect(jsonPath("$[0].name", `is`("Luke Skywalker")))
            .andExpect(jsonPath("$[0].height", `is`(172)))
            .andExpect(jsonPath("$[1].id", `is`(yoda.id)))
            .andExpect(jsonPath("$[1].name", `is`("Yoda")))
            .andExpect(jsonPath("$[1].height", `is`(66)))
    }
}
