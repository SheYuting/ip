package duke.command;

import duke.main.Statistics;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;
import duke.exception.DukeException;

/**
 * Command is an abstract command to make some changes to the tasks in the tasklist.
 */
public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage,
                                 Statistics stats) throws DukeException;
    public abstract boolean isExit();
}