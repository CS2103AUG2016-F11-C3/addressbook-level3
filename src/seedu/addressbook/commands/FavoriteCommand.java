package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

public class FavoriteCommand extends Command{
	public static final String COMMAND_WORD = "fav";

	public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" + "Marks a person as favorite. "
			+ "Parameters: NAME\n\t" + "Example: " + COMMAND_WORD + " John Doe";

	public static final String MESSAGE_SUCCESS = "New person added to favorites: %1$s";
	public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in favorites";
	public static final String NOT_FOUND = "Person not found in address book";
	
	private String searchName;
	
	public FavoriteCommand(String name) {
		this.searchName = name;
	}

	private Person getPersonWithExactName(String searchName) {
		for (ReadOnlyPerson readOnlyPerson : addressBook.getAllPersons()) {
			if (readOnlyPerson.getName().equals(searchName)) {
				Person person = new Person(readOnlyPerson);
				return person;
			}
		}
		return null;
	}

	@Override
	public CommandResult execute() {
		final ReadOnlyPerson PersonToAdd = getPersonWithExactName(searchName);
		return null;
	}
}
