package org.example.Exception;

public class InvalidePasswordLenghException extends Exception {
	public InvalidePasswordLenghException() {
		System.out.println("Hum... Je ne crains que le mot de passe ne soit pas compris entre 8 et 40 caractère :/");
	}
}
