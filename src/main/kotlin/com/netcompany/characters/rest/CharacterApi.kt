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
    @ApiOperation("Get the character with the given id", nickname = "getCharacterById", produces = "application/json")
    @ApiResponses(
        ApiResponse(code = 200, message = "Successfully retrieved a character"),
        ApiResponse(code = 404, message = "Could not find a character with the given id")
    )
    fun getById(
        @ApiParam(value = "The id of the character to be retrieved", required = true, example = "42") id: Int
    ): CharacterDto

    /**
     * Get all characters with the given name.
     *
     * @param name name of the character(s). If null, all characters will be returned.
     * @return a list of characters
     */
    @ApiOperation("Get characters", nickname = "getCharacters", produces = "application/json")
    @ApiResponse(code = 200, message = "Successfully retrieved all the characters")
    fun getCharacters(
        @ApiParam(value = "The name of the character to retrieve", required = false, example = "R2-D2") name: String?
    ): List<CharacterDto>

    /**
     * Create a character.
     *
     * @return the created character
     */
    @ApiOperation("Create a character", nickname = "createCharacter", consumes = "application/json", produces = "application/json")
    @ApiResponse(code = 200, message = "Created a character")
    fun createCharacter(@ApiParam(value = "The character to create", required = true) character: CharacterDto): CharacterDto

    /**
     * Get characters from the Star Wars API.
     *
     * @param name the name of the character(s). If null, all characters will be returned.
     *
     * @return a list of characters
     */
    @ApiOperation("Get characters from the Star Wars API", nickname = "getCharactersFromSWAPI", produces = "application/json")
    @ApiResponse(code = 200, message = "Successfully retrieved characters")
    fun getCharactersFromStarWarsApi(
        @ApiParam(value = "The name of the character(s) to retrieve", required = false, example = "Yoda") name: String?
    ): List<CharacterDto>
}
