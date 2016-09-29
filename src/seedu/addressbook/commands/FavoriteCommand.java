package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

public class FavoriteCommand extends Command{
	public static final String COMMAND_WORD = "fav";

	public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" + "Marks a person as favorite. "
			+ "Parameters: NAME\n\t" + "Example: " + COMMAND_WORD + " John Doe";

	public static final String MESSAGE_SUCCESS = "New person added to favorites: %1$s";
	public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in favorites";
	public static final String MESSAGE_PERSON_NOT_FOUND = "Person not found in address book";
	
	private String searchName;
	
	public FavoriteCommand(String name) {
		this.searchName = name;
	}

	private Person getPersonWithExactName(String searchName) {
		for (ReadOnlyPerson readOnlyPerson : addressBook.getAllPersons()) {
			if (readOnlyPerson.getName().toString().equals(searchName)) {
				Person person = new Person(readOnlyPerson);
				return person;
			}
		}
		return null;
	}

	@Override
	public CommandResult execute() {
		final Person personToFavorite = getPersonWithExactName(searchName);
		if (personToFavorite == null) {
			return new CommandResult(MESSAGE_PERSON_NOT_FOUND);
		} else {
			if (personToFavorite.getIsFavorite() == true) {
				return new CommandResult(MESSAGE_DUPLICATE_PERSON);
			}
			personToFavorite.setIsFavorite(true);
			return new CommandResult(String.format(MESSAGE_SUCCESS, personToFavorite));
		}
	}
}
