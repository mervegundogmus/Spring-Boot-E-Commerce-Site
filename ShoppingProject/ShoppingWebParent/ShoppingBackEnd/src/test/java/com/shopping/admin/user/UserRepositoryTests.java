package com.shopping.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.shopping.common.entity.Role;
import com.shopping.common.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository repo;

	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateNewUserWithOneRole() {
		Role roleAdmin = entityManager.find(Role.class, 1);
		User userMerve = new User("mervegundogmus@outlook.com", "merve2022", "Merve", "Gundogmus");
		userMerve.addRole(roleAdmin);
		
		User savedUser = repo.save(userMerve);
		
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateNewUserWithTwoRoles() {
		User userJack = new User("jackshephard@gmail.com", "jack2022", "Jack", "Shephard");
		Role roleEditor = new Role(3);
		Role roleAssistant = new Role(5);
		
		userJack.addRole(roleEditor);
		userJack.addRole(roleAssistant);
		
		User savedUser = repo.save(userJack);
		
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testListAllUsers() {
		Iterable<User> listUsers = repo.findAll();
		listUsers.forEach(user -> System.out.println(user));
	}
	
	@Test
	public void testGetUserById() {
		User userMerve = repo.findById(1).get();
		System.out.println(userMerve);
		assertThat(userMerve).isNotNull();
	}
	
	@Test
	public void testUpdateUserDetails() {
		User userMerve = repo.findById(1).get();
		userMerve.setEnabled(true);
		userMerve.setEmail("merveegundogmus@gmail.com");
		
		repo.save(userMerve);
	}
	
	@Test
	public void testUpdateUserRoles() {
		User userJack = repo.findById(2).get();
		Role roleEditor = new Role(3);
		Role roleSalesperson = new Role(2);
		
		userJack.getRoles().remove(roleEditor);
		userJack.addRole(roleSalesperson);
		
		repo.save(userJack);
	}
	
	@Test
	public void testDeleteUser() {
		Integer userId = 2;
		repo.deleteById(userId);
	}

}
