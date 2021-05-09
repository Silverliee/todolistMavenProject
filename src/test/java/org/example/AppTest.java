package org.example;

import static org.junit.Assert.assertEquals;

import org.example.Entity.Item;
import org.example.Entity.Todolist;
import org.example.Entity.User;
import org.example.Exception.*;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * User creation test
	 */
	@Test
	public void createUserTest() {
		User myTestUser = new User("John", "Doe", LocalDate.of(1998, 9, 9), "testmail@testmailbox.fr", "mytestpassword", new Todolist());
		assertEquals("John", myTestUser.getFirstname());
		assertEquals("Doe", myTestUser.getLastname());
		assertEquals(LocalDate.of(1998, 9, 9), myTestUser.getBirthday());
		assertEquals("testmail@testmailbox.fr", myTestUser.getMailAddress());
		assertEquals("mytestpassword", myTestUser.getPassword());
		assertEquals(0, myTestUser.getTodolist().getItems().size());
	}

	/**
	 * test if is user.isValid() function throw the correct exception when user is under 13 years old
	 */
	@Test(expected = InvalideOldException.class)
	public void userIsValidShouldThrowInvalideOldException() throws InvalideEmailException, InvalidePasswordLengthException, InvalideOldException {
		User myTestUser = new User("John", "Doe", LocalDate.now(), "testmail@testmailbox.fr", "mytestpassword", new Todolist());
		myTestUser.isValid();
	}

	/**
	 * test if is user.isValid() function throw the correct exception when user mail address is invalid
	 */
	@Test(expected = InvalideEmailException.class)
	public void userIsValidShouldThrowInvalideEmailException() throws InvalideEmailException, InvalidePasswordLengthException, InvalideOldException {
		User myTestUser = new User("John", "Doe", LocalDate.of(1998, 9, 9), "testmailtestmailboxfr", "mytestpassword", new Todolist());
		myTestUser.isValid();
	}

	/**
	 * test if is user.isValid() function throw the correct exception when user password is under 8 char or upper than 40 char
	 */
	@Test(expected = InvalidePasswordLengthException.class)
	public void userIsValidShouldThrowInvalidePasswordLengthException() throws InvalideEmailException, InvalideOldException, InvalidePasswordLengthException {
		User myTestUser = new User("John", "Doe", LocalDate.of(1998, 9, 9), "testmail@testmailbox.fr", "myt", new Todolist());
		myTestUser.isValid();
	}

	/**
	 * Todolist creation test
	 */
	@Test
	public void createTodolistTest() {
		Todolist myTestTodolist = new Todolist();
		assertEquals(0, myTestTodolist.getItems().size());
	}

	/**
	 * test if is todolist.add() function throw the correct exception when item reached 10 elements
	 */
	@Test(expected = TodolistMaxItemsReached.class)
	public void todolistAddShouldThrowTodolistMaxItemsReachedException() throws TodolistMaxItemsReached, InvalideItemContentException, ItemNameAlreadyExistException {
		Todolist myTestTodolist = new Todolist();
		for (int i = 0; i <= 11; i++) {
			long testNow = LocalDateTime.of(1998, 9, 9, 3, 3, 3).toEpochSecond(ZoneOffset.UTC);
			myTestTodolist.add(
					new Item("testName" + Integer.toString(i), "testContent" + Integer.toString(i), new Date(testNow + ((i + 1) * 30 * 60 * 1000)))
					);
		}
	}

	/**
	 * test if is todolist.add() function throw the correct exception when item content over 100 char
	 */
	@Test(expected = InvalideItemContentException.class)
	public void todolistAddShouldThrowInvalidItemContentException() throws TodolistMaxItemsReached, InvalideItemContentException, ItemNameAlreadyExistException {
		Todolist myTestTodolist = new Todolist();
		myTestTodolist.add(
				new Item("testName",
						"azerazerazerazerazerazerazerazerazerazerazerazeazerazerazerazerazerazerazerazerazerazerazerazeazerazerazerazerazerazerazerazerazerazerazerazeazerazerazerazerazerazerazerazerazerazerazerazeazerazerazerazerazerazerazerazerazerazerazerazeazerazerazerazerazerazerazerazerazerazerazeraze",
						new Date())
		);
	}

	/**
	 * test if is todolist.add() function throw the correct exception when item name already exist in the todolist
	 */
	@Test(expected = ItemNameAlreadyExistException.class)
	public void todolistAddShouldThrowItemNameAlreadyExistException() throws TodolistMaxItemsReached, InvalideItemContentException, ItemNameAlreadyExistException {
		Todolist myTestTodolist = new Todolist();
		for (int i = 0; i <= 3; i++) {
			long testNow = LocalDateTime.of(1998, 9, 9, 3, 3, 3).toEpochSecond(ZoneOffset.UTC);
			myTestTodolist.add(
					new Item("testName" , "testContent", new Date(testNow + ((i + 1) * 30 * 60 * 1000)))
			);
		}
	}

	/**
	 * Item creation test
	 */
	@Test
	public void createItemTest() {
		Date myTestDate = new Date();
		Item myTestItem = new Item("testItemName", "testItemContent", myTestDate);
		assertEquals("testItemName", myTestItem.getName());
		assertEquals("testItemContent", myTestItem.getContent());
		assertEquals(myTestDate, myTestItem.getCreationDate());
	}
}
