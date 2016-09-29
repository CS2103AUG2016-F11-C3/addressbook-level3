package seedu.addressbook.commands;

public class FavoriteCommand {
	public static final String COMMAND_WORD = "fav";

	public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" + "Marks a person as favorite. "
			+ "Parameters: NAME\n\t" 
			+ "Example: " + COMMAND_WORD + " John Doe";

	public static final String MESSAGE_SUCCESS = "New person added to favorites: %1$s";
	public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in favorites";
	public static final String NOT_FOUND = "Person not found in address book";
	
	 public FavoriteCommand(String name) {
		 
	 }
}
