package com.shopping.admin.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopping.common.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
