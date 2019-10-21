package com.netcompany.characters.rest.integration

import com.netcompany.characters.Application
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.notNullValue
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
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
        mvc.perform(get("/hello").accept(APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$", `is`("Hello, Yoda!")))
    }

    @Test
    @Throws(Exception::class)
    fun getCharactersReturnsCharacters() {
        mvc.perform(get("/characters").accept(APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.length()", `is`(2)))
            .andExpect(jsonPath("$[0].name", notNullValue()))
            .andExpect(jsonPath("$[0].height", notNullValue()))
            .andExpect(jsonPath("$[0].homeworld", notNullValue()))
            .andExpect(jsonPath("$[1].name", notNullValue()))
            .andExpect(jsonPath("$[1].height", notNullValue()))
            .andExpect(jsonPath("$[1].homeworld", notNullValue()))
    }
}
