package duke.main;

import java.util.ArrayList;
import duke.task.Task;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task removeTask(int index) {
        return tasks.remove(index);
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

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

    public ArrayList<Task> findTask(String toFind) {
        ArrayList<Task> filteredTask = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getName().contains(toFind)) {
                filteredTask.add(task);
            }
        }
        return filteredTask;
    }
}
