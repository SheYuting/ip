package duke.command;

import duke.main.Statistics;
import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;
import duke.exception.DukeException;
import duke.task.Task;
import duke.task.Deadline;


public class StatsCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage,
                        Statistics stats) throws DukeException {
        ui.addMessage(stats.toString());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
