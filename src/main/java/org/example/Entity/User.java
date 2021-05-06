package org.example.Entity;

import org.example.Exception.InvalideEmailException;
import org.example.Exception.InvalideOldException;
import org.example.Exception.InvalidePasswordLenghException;

import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

	private final String firstname;
	private final String lastname;
	private final LocalDate birthday;
	private final String mailAddress;
	private final String password;
	private final Todolist todolist;

	public User(String firstname, String lastname, LocalDate birthday, String mailAddress, String password, Todolist todolist) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.mailAddress = mailAddress;
		this.password = password;
		this.todolist = todolist;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public Todolist getTodolist() {
		return todolist;
	}

	/**
	 * @return true if user is valid else return false or exception
	 */
	public boolean isValid() throws InvalideOldException, InvalideEmailException, InvalidePasswordLenghException {
		LocalDate now = LocalDate.now();
		Pattern emailRegex = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$");
		Matcher emailIsValid = emailRegex.matcher(this.mailAddress);
		if (!this.birthday.isBefore(now.minusYears(13))) {
			throw new InvalideOldException();
		}
		if (!emailIsValid.matches()) {
			throw new InvalideEmailException();
		}
		if ((this.password.length() < 8) || (this.password.length() > 40)) {
			throw new InvalidePasswordLenghException();
		}
		return true;
	}
}
