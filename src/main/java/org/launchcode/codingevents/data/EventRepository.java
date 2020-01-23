package org.launchcode.codingevents.data;

// also sometimes called DAO - data access object

import org.launchcode.codingevents.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// add Event object type and Integer class type (for primary key)
// it will autobox and convert id between primitive and object types

// this is a special interface, and because CrudRepository is so standardized,
// Spring can create a class to implement the interface and then autowire it to the field

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
}
