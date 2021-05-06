package org.example.Exception;

public class TodolistMaxItemsReached extends Exception {
	public TodolistMaxItemsReached() {
		System.out.println("Hum... Je ne crains que vous ayez atteint le nombre maximum de 10 items autorisé");
	}
}
