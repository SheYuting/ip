public class Parser {
    public static Command parse(String fullCommand) throws DukeException {
        String commandWord = fullCommand.split(" ")[0];

        switch (commandWord) {
            case "todo":
                return new AddToDoCommand(fullCommand);
            case "deadline":
                return new AddDeadlineCommand(fullCommand);
            case "event":
                return new AddEventCommand(fullCommand);
            case "mark":
                return new MarkTaskCommand(fullCommand);
            case "unmark":
                return new UnmarkTaskCommand(fullCommand);
            case "delete":
                return new DeleteCommand(fullCommand);
            case "list":
                return new ListTaskCommand();
            case "bye":
                return new ExitCommand();
            default:
                throw new DukeException("Unknown command.");
        }
    }
}
