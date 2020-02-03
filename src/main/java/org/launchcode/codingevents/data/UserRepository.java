package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUserName(String username);

}
