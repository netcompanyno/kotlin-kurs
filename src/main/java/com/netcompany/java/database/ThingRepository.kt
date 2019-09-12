package com.netcompany.java.database;

import com.netcompany.java.domain.Thing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository for {@link Thing}.
 *
 * By extending JpaRepository you get a lot of basic JPA methods for free. Standard methods for persisting, getting an
 * entity by, etc. It is also easy to extend with more quite basic queries, just by defining methods that follow the
 * naming conventions. In many cases, this is all you need.
 */
@Transactional
interface ThingRepository : JpaRepository<Thing, Long> {

    /**
     * Finds {@link Thing things} based on their name.
     *
     * @param name the name of the {@link Thing things} we want to get
     * @return a list of {@link Thing things}
     */
    fun findByName(name: String) : List<Thing>
}
