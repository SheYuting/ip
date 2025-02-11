package duke.command;

import duke.main.Statistics;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;
import duke.exception.DukeException;

/**
 * ListTask Command is a command to list all the tasks in the tasklist.
 */
public class ListTaskCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage, Statistics stats) {
        ui.showTaskList(tasks.getTasks());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
