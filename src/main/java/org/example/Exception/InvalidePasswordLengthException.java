package org.example.Exception;

public class InvalidePasswordLengthException extends Exception {
	public InvalidePasswordLengthException() {
		System.out.println("Hum... Je ne crains que le mot de passe ne soit pas compris entre 8 et 40 caractère :/");
	}
}
