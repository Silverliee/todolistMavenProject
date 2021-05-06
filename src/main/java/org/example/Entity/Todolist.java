package org.example.Entity;

import org.example.Exception.InvalideItemContentException;
import org.example.Exception.ItemNameAlreadyExistException;
import org.example.Exception.TodolistMaxItemsReached;

import java.util.ArrayList;
import java.util.Date;

public class Todolist {
	private final ArrayList<Item> items;

	public Todolist() {
		this.items = new ArrayList<Item>();
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * @param item [type Item]
	 * @return true if item is valid, else return false
	 */
	public boolean isValidItem(Item item) throws InvalideItemContentException, ItemNameAlreadyExistException {
		if (item.getContent().length() > 100) {
			throw new InvalideItemContentException();
		}
		for (Item registeredItem : this.items
		) {
			if (registeredItem.getName().equals(item.getName())) {
				throw new ItemNameAlreadyExistException();
			}
		}
		return true;
	}

	/**
	 * @param item [type Item]
	 * @return true if item added, else return false
	 */
	public boolean add(Item item) throws InvalideItemContentException, ItemNameAlreadyExistException, TodolistMaxItemsReached {
		if (!this.isValidItem(item)) {
			return false;
		}
		if (this.items.size() >= 10) {
			throw new TodolistMaxItemsReached();
		}
		if (this.items.size() == 7) {
			return true;
		}
		if (this.items.size() > 1) {
			Date lastItemCreationDatetime = this.items.get(this.items.size() - 1).getCreationDate();
			Date now = new Date();
			if ((now.getTime() - lastItemCreationDatetime.getTime()) >= 30 * 60 * 1000) {
				this.items.add(item);
				return true;
			}
		}
		return false;
	}
}
