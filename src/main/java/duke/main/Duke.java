package duke.main;

import duke.command.Command;
import duke.exception.DukeException;
import duke.main.Storage;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * Duke is a chatbot that helps users manage their tasks.
 */
public class Duke extends Application {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private static final String DEFAULT_FILE_PATH = "./data/duke.txt";

    /**
     * The main entry point of the Duke application.
     * Loads tasks from storage and processes user commands in a loop.
     *
     */

    public Duke() throws DukeException {
        this(DEFAULT_FILE_PATH);
    }

    public Duke(String filePath) throws DukeException {
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