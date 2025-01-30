package duke.main;

import java.util.ArrayList;
import duke.task.Task;

public class TaskList {

    /**
     * Manages the list of tasks, including adding, removing, and displaying tasks.
     */
    private ArrayList<Task> tasks;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a task to the list.
     *
     * @param task The task to add.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes a task from the list.
     *
     * @param index The index of the task to be deleted.
     * @return The deleted task.
     */
    public Task removeTask(int index) {
        return tasks.remove(index);
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return The size of the task list.
     */
    public int getSize() {
        return tasks.size();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void markTask(int index) {
        getTask(index).markTask();
    }

    public void unmarkTask(int index) {
        getTask(index).unmarkTask();
    }
}
