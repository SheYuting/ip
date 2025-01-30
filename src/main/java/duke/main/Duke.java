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

    /**
     * The main entry point of the Duke application.
     * Loads tasks from storage and processes user commands in a loop.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) throws DukeException {
        new Duke("./data/duke.txt").runDuke();
    }

    private Duke(String filePath) throws DukeException {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        this.tasks = storage.loadTasks(ui);
    }

    private void runDuke() {
        ui.showWelcome();

        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            }
        }
    }
}