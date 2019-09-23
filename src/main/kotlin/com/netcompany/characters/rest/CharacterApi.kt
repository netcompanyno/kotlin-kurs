package com.netcompany.characters.rest

import com.netcompany.characters.dto.CharacterDto
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses

interface CharacterApi {
    /**
     * Get a character based on its id.
     *
     * @param id id of the {@link CharacterDto character} to be retrieved
     * @return a character, if one is found
     */
    @ApiOperation("Get the character with the given id")
    @ApiResponses(
        ApiResponse(code = 200, message = "Successfully retrieved a character"),
        ApiResponse(code = 404, message = "Could not find a character with the given id")
    )
    fun getById(
        @ApiParam(value = "The id of the character to be retrieved", required = true, example = "42") id: Int
    ): CharacterDto

    /**
     * Get a character with the given name.
     *
     * @param name name of the character we want to retrieve
     * @return a list of characters
     */
    @ApiOperation("Get character by name")
    @ApiResponses(
        ApiResponse(code = 200, message = "Successfully retrieved a character"),
        ApiResponse(code = 404, message = "No characters with given name found")
    )
    fun getByName(
        @ApiParam(value = "The name of the character to retrieve", required = true, example = "R2D2") name: String
    ): CharacterDto

    /**
     * Get all characters.
     *
     * @return a list of characters
     */
    @ApiOperation("Get all characters")
    @ApiResponse(code = 200, message = "Successfully retrieved all the characters")
    fun getAllCharacters(): List<CharacterDto>

    /**
     * Create a character.
     *
     * @return the created character
     */
    @ApiOperation("Create a character")
    @ApiResponse(code = 200, message = "Created a character")
    fun createCharacter(@ApiParam(value = "The character to create", required = true) character: CharacterDto): CharacterDto

    /**
     * Get all characters from the Star Wars API.
     *
     * @return a list of characters
     */
    @ApiOperation("Get all characters from the Star Wars API")
    @ApiResponse(code = 200, message = "Successfully retrieved all the characters")
    fun getAllCharactersFromStarWarsApi(): List<CharacterDto>

    /**
     * Get characters from the Star Wars API by name.
     *
     * @return a list of characters
     */
    @ApiOperation("Get all characters from the Star Wars API with a given name")
    @ApiResponse(code = 200, message = "Successfully retrieved characters")
    fun getCharacterFromStarWarsApiByName(
        @ApiParam(value = "The name of the character(s) to retrieve", required = true, example = "Yoda") name: String
    ): List<CharacterDto>
}
