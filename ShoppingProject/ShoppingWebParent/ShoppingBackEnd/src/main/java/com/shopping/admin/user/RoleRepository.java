package com.shopping.admin.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopping.common.entity.Role;

//Spring Data JPA tarafından sağlanan CrudRepository arayüzünü genişleten bu arayüze sahibiz.

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{ // T is for the entity type, ID field is Integer

}
