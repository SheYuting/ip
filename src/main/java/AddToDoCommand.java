public class AddToDoCommand extends Command {
    private String description;

    public AddToDoCommand(String command) {
        this.description = command.substring(5).trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (description.isEmpty()) {
            throw new DukeException("The description of a todo cannot be empty.");
        }
        Task task = new Todo(description);
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