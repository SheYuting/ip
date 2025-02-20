package xuxin.main;

import java.util.ArrayList;
import xuxin.task.Task;

/**
 * Manages the list of tasks, including adding, removing, and displaying tasks.
 */
public class TaskList {

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
        assert task != null;
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
        assert index >= 0 && index < tasks.size();
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

    /**
     * Returns the tasks in the list.
     *
     * @return The tasks in the task list.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void markTask(int index) {
        assert index >= 0 && index < tasks.size();
        getTask(index).markTask();
    }

    public void unmarkTask(int index) {
        assert index >= 0 && index < tasks.size();
        getTask(index).unmarkTask();
    }

    public ArrayList<Task> findTask(String toFind) {
        assert toFind != null && !toFind.isEmpty();
        ArrayList<Task> filteredTask = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getName().contains(toFind)) {
                filteredTask.add(task);
            }
        }
        return filteredTask;
    }
}
