package com.netcompany.java.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Representation of a thing.
 */
@Entity
class Thing(var name: String, var location: String) {
    // TODO denne virker nok ikke som den skal...
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    constructor(id: Long, name: String, location: String) : this(name, location) {
        this.id = id
    }

    constructor() : this("", "")

}
