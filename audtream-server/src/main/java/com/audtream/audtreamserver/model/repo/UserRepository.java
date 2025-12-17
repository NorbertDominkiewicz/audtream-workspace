package com.audtream.audtreamserver.model.repo;

import com.audtream.audtreamserver.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
