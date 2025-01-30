public class MarkTaskCommand extends Command {
    private int zeroIndex;

    MarkTaskCommand(String command) throws DukeException {
        this.zeroIndex = parseTaskIndex(command, "mark");
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (zeroIndex < 0 || zeroIndex >= tasks.getSize()) {
            throw new DukeException("OOPS!!! The index to mark as done cannot be less than 0 or "
                    + "greater than the length of the list.");
        }

        tasks.markTask(zeroIndex);
        ui.printMessage("Nice! I've marked this task as done: \n" + tasks.getTask(zeroIndex));
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
            throw new DukeException("Task number must be a valid integer.");
        }
    }
}
