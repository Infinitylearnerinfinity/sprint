package com.batch2.onlineShopping.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.batch2.onlineshopping.controller.UserController;
import com.batch2.onlineshopping.entity.User;
import com.batch2.onlineshopping.service.UserService;

@ExtendWith(MockitoExtension.class)
public class Usertest {
	@Mock
	private UserService userService;
	@InjectMocks
	private UserController userController;

	@Test
	public void testUserRegistration() {
		User user = new User();
		user.setUsername("testuser");
		user.setPassword("testpassword");
		when(userService.saveUserDetails(any(User.class))).thenReturn(user);
		User response = userController.userRegistration(user);
		assertNotNull(response);
		assertEquals("testuser", response.getUsername());
		assertEquals("testpassword", response.getPassword());
	}

	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setUsername("testuser");
		user.setPassword("testpassword");
		when(userService.updateUser(any(User.class), eq(1))).thenReturn(user);
		User response = userController.updateUser(user, 1);
		assertNotNull(response);
		assertEquals("testuser", response.getUsername());
		assertEquals("testpassword", response.getPassword());
	}

	@Test
	public void testGetUser() {
		User user = new User();
		user.setUsername("testuser");
		user.setPassword("testpassword");
		when(userService.getUserDetails(eq(1))).thenReturn(Optional.of(user));
		Optional<User> response = userController.getUser(1);
		assertNotNull(response);
		assertEquals("testuser", response.get().getUsername());
		assertEquals("testpassword", response.get().getPassword());
	}

	@Test
	public void testDeleteUser()
	{
		userController.deleteUser(1);
    }
}
