package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;

import java.util.ArrayList;
import java.util.List;


/**
 * Lists all persons in the address book to the user.
 */
public class ShowFavoriteCommand extends Command {

    public static final String COMMAND_WORD = "showfav";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" 
            + "Displays all persons in the favorite list as a list with index numbers.\n\t"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<Person> allFavoriteContacts = getPersonsInFavorite();
        return new CommandResult(getMessageForPersonListShownSummary(allFavoriteContacts), allFavoriteContacts);
    }
    
    private List<Person> getPersonsInFavorite() {
        final List<Person> matchedPersons = new ArrayList<>();
        for (Person person : addressBook.getAllPersons()) {
            if (person.getIsFavorite() == true) {
            	matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }
}
