package duke.command;

import duke.main.Storage;
import duke.main.TaskList;
import duke.main.Ui;
import duke.exception.DukeException;
import duke.task.Task;
import duke.task.Deadline;

/**
 * AddToDo Command is a command to add a deadline task into the tasklist.
 */
public class AddDeadlineCommand extends Command {
    private String description;
    private String date;

    public AddDeadlineCommand(String command) throws DukeException {
        assert command.length() > 0;
        if (!command.contains(" /by "))
            throw new DukeException("A deadline must have '/by '.");
        String[] parts = command.substring(9).split(" /by ");
        if (parts.length < 2) throw new DukeException("Incomplete deadline format.");
        this.description = parts[0].trim();
        this.date = parts[1].trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (description.isEmpty()) {
            throw new DukeException("The description of a deadline cannot be empty.");
        }
        Task task = new Deadline(description, date);
        tasks.addTask(task);
        ui.addSuccess(task);
        ui.showTaskCount(tasks.getSize());
        try {
            storage.saveTasks(tasks);
        } catch (DukeException e) {
            ui.showError(e.getMessage());
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}