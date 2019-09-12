package com.netcompany.java.service;

import com.netcompany.java.database.ThingRepository;
import com.netcompany.java.domain.Thing;
import com.netcompany.java.exception.ThingNotFoundException;
import com.netcompany.java.rest.ThingDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service for functionality regarding {@link Thing}.
 */
@Service
open class ThingService(val thingRepository: ThingRepository) {

    /**
     * Gets a {@link Thing} with the given id.
     *
     * @param id id of the thing to be retrieved
     * @return a {@link Thing} with the given id
     * @throws ThingNotFoundException if no {@link Thing} with given id exists
     */
    @Transactional(readOnly = true)
    open fun getById(id: Long): ThingDto {
        val thing: Thing = thingRepository.findByIdOrNull(id)
            ?: throw ThingNotFoundException("Thing with id $id not found")

        return ThingDto(thing)
    }

    /**
     * Gets all the {@link Thing things}!
     *
     * @return a list of {@link Thing things}
     */

    @Transactional(readOnly = true)
    open fun getAllThings(): List<ThingDto> {
        return thingRepository.findAll()
            .map { t -> ThingDto(t) }
            .toList()
    }

    /**
     * Get all {@link Thing things} with the given name.
     *
     * @param name name of the things to be retrieved
     * @return a list of {@link Thing things}
     */
    @Transactional(readOnly = true)
    open fun getByName(name: String): ThingDto {
        return thingRepository.findByName(name)
            .map{t -> ThingDto(t)}
            .firstOrNull() ?: throw ThingNotFoundException("Thing with name $name not found")
    }
}
