package duke.command;

import duke.exception.DukeException;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;
import duke.task.Task;

import java.util.ArrayList;

/**
 * Find Command is a command to find a task from the tasklist.
 */
public class FindCommand extends Command {
    private String toFind;

    public FindCommand(String toFind) throws DukeException {
        this.toFind = toFind.substring(5);
        if (toFind.isEmpty()) {
            throw new DukeException("Please enter a search term");
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ArrayList<Task> filteredTasks = tasks.findTask(toFind);
        ui.addMessage("Here are the matching tasks in your list:");
        ui.showTaskList(filteredTasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}