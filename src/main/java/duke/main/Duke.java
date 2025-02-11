package duke.main;

import duke.command.Command;
import duke.exception.DukeException;
import duke.main.Storage;

/**
 * Duke is a chatbot that helps users manage their tasks.
 */
public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private Statistics stats;
    private static final String DEFAULT_FILE_PATH = "./data/duke.txt";
    private boolean isExit = false;

    /**
     * The main entry point of the Duke application.
     * Loads tasks from storage and processes user commands in a loop.
     *
     */
    public Duke() {
        storage = new Storage(DEFAULT_FILE_PATH);
        ui = new Ui();

        try {
            tasks = storage.loadTasks(ui);
        } catch (DukeException e) {
            ui.addMessage(e.getMessage());
            tasks = new TaskList();
        }

        stats = new Statistics(tasks);
    }

    public String getOutput(String input) {
        if (isExit) {
            return "";
        }

        try {
            ui.resetOutput();
            Command command = Parser.parse(input);
            command.execute(tasks, ui, storage, stats);
            isExit = command.isExit();
            return ui.showOutput();
        } catch (DukeException e) {
            return e.getMessage();
        }
    }

}