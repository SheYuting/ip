package duke.command;

import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;
import duke.task.Task;
import duke.exception.DukeException;

public class UnmarkTaskCommand extends Command {
    private int zeroIndex;

    public UnmarkTaskCommand(String command) throws DukeException {
        this.zeroIndex = parseTaskIndex(command, "unmark");
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (zeroIndex < 0 || zeroIndex >= tasks.getSize()) {
            throw new DukeException("OOPS!!! The index to mark as done cannot be less than 0 or "
                    + "greater than the length of the list.");
        }
        Task task = tasks.getTask(zeroIndex);
        tasks.unmarkTask(zeroIndex);
        ui.printMessage("OK, I've marked this task as not done yet: " );
        ui.printMessage(task.toString());
        ui.showLine();
        storage.saveTasks(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }

    private static int parseTaskIndex(String command, String action) throws DukeException {
        String[] parts = command.split(" ");
        if (parts.length < 2) throw new DukeException("Please specify a task number to " + action + ".");
        try {
            int index = Integer.parseInt(parts[1]) - 1;
            return index;
        } catch (NumberFormatException e) {
            throw new DukeException("task.Task number must be a valid integer.");
        }
    }
}
