package com.netcompany.java.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Swagger-specific annotations are kept in an interface, to keep the implementation code clean.
 */
interface ThingApi {

    /**
     * Get a {@link ThingDto} based on it's id.
     *
     * @param id id of the {@link ThingDto thing} to be retrieved
     * @return a {@link ThingDto thing}, if one is found
     */
    @ApiOperation("Get the thing with the given id")
    @ApiResponses(
        ApiResponse(code = 200, message = "Successfully retrieved a thing"),
        ApiResponse(code = 404, message = "Could not find a thing with the given id")
    )
    fun getById(@ApiParam(value = "The id of the thing to be retrieved", required = true, example = "42")
                id: Long): ThingDto

    /**
     * Get all things.
     *
     * @return a list of {@link ThingDto things}
     */

    @ApiOperation("Get all the things!")
    @ApiResponse(code = 200, message = "Successfully retrieved all the things")
    fun getAllThings(): List<ThingDto>

    /**
     * Get {@link ThingDto things} with the given name.
     *
     * @param name name of the thing we want to retrieve
     * @return a list of {@link ThingDto things}
     */
    @ApiOperation("Get things by name")
    @ApiResponses(
        ApiResponse(code = 200, message = "Successfully retrieved at least one thing"),
        ApiResponse(code = 404, message = "No things with given name found")
    )
    fun getByName(@ApiParam(value = "The name of the things to retrieve", required = true, example = "something")
                  name: String): ThingDto
}
