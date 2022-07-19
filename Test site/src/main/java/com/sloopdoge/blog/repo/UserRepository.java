package com.sloopdoge.blog.repo;

import com.sloopdoge.blog.models.MyUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<MyUser, Long> {
    MyUser findUserByEmail(String email);
}
