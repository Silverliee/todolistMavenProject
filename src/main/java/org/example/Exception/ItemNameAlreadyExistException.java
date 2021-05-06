package org.example.Exception;

public class ItemNameAlreadyExistException extends Exception {
	public ItemNameAlreadyExistException() {
		System.out.println("Hum... Je ne crains qu'un item déjà enregistré parle le nom que vous venez de saisir");
	}
}
