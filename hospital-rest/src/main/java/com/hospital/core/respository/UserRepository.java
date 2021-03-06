package com.hospital.core.respository;

import com.hospital.core.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByName(String name);

    User findByName(String name);

}
