package duke.main;

import duke.command.AddDeadlineCommand;
import duke.command.AddEventCommand;
import duke.command.AddToDoCommand;
import duke.command.DeleteCommand;
import duke.command.MarkTaskCommand;
import duke.command.UnmarkTaskCommand;
import duke.command.ExitCommand;
import duke.command.ListTaskCommand;
import duke.exception.DukeException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {
    @Test
    void parserTest() throws DukeException  {
        assertTrue(Parser.parse("bye") instanceof ExitCommand);
        assertTrue(Parser.parse("list") instanceof ListTaskCommand);
        assertTrue(Parser.parse("mark 2") instanceof MarkTaskCommand);
        assertTrue(Parser.parse("delete 2") instanceof DeleteCommand);
        assertTrue(Parser.parse("todo todo") instanceof AddToDoCommand);
        assertTrue(Parser.parse("deadline deadline /by 25/07/2015") instanceof AddDeadlineCommand);
        assertTrue(Parser.parse("event event /at 26/07/2014") instanceof AddEventCommand);
    }
}
