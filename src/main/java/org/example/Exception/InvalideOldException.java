package org.example.Exception;

public class InvalideOldException extends Exception {
	public InvalideOldException() {
		System.out.println("Hum... Je ne crains que l'utilisateur ne soit pas assez agé, en effet il faut avoir minimum 13 ans");
	}
}
