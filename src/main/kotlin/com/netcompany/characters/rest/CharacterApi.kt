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
     * @return a {@link CharacterDto character}, if one is found
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
     * Get {@link CharacterDto characters} with the given name.
     *
     * @param name name of the character we want to retrieve
     * @return a list of {@link CharacterDto characters}
     */
    @ApiOperation("Get characters by name")
    @ApiResponses(
        ApiResponse(code = 200, message = "Successfully retrieved at least one character"),
        ApiResponse(code = 404, message = "No characters with given name found")
    )
    fun getByName(
        @ApiParam(value = "The name of the characters to retrieve", required = true, example = "R2D2") name: String
    ): CharacterDto

    /**
     * Get all characters.
     *
     * @return a list of {@link CharacterDto characters}
     */
    @ApiOperation("Get all the characters!")
    @ApiResponse(code = 200, message = "Successfully retrieved all the characters")
    fun getAllCharacters(): List<CharacterDto>
}
