package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

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
        List<ReadOnlyPerson> allFavoriteContacts = getPersonsInFavorite();
        return new CommandResult(getMessageForPersonListShownSummary(allFavoriteContacts), allFavoriteContacts);
    }
    
    private List<ReadOnlyPerson> getPersonsInFavorite() {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson roPerson : addressBook.getAllPersons()) {
        	Person person = new Person(roPerson);
            if (person.getIsFavorite() == true) {
            	matchedPersons.add(roPerson);
            }
        }
        return matchedPersons;
    }
}
