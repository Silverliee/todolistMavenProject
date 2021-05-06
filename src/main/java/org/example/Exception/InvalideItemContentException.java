package org.example.Exception;

public class InvalideItemContentException extends Exception {
	public InvalideItemContentException() {
		System.out.println("Hum... Je ne crains que vous ayez dépassé la limite de 100 caractères pour le champ contenue ");
	}
}
