package com.netcompany.java.rest;

import com.netcompany.java.service.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * It is good practice to keep REST-services as simple as possible, and leave the bulk of the functionality to services.
 *
 * This example is using Swagger annotations, placed in an interface to keep the code clean. As an alternative is it
 * possible to write the Swagger spec as yaml by hand, and generate the interface and dto classes.
 */
@RestController
class ThingController(private val thingService: ThingService) : ThingApi {
    @RequestMapping(path = ["/thing/{id}"], method = [RequestMethod.GET])
    override fun getById(@PathVariable("id") id: Long): ThingDto {
        return thingService.getById(id)
    }

    @RequestMapping(path = ["/thing"], method = [RequestMethod.GET])
    override fun getAllThings(): kotlin.collections.List<ThingDto> {
        return thingService.getAllThings()
    }

    @RequestMapping(path = ["/thing/name/{name}"], method = [RequestMethod.GET])
    override fun getByName(name: String): ThingDto {
        return thingService.getByName(name)
    }
}

