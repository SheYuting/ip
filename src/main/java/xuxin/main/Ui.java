package xuxin.main;

import java.util.ArrayList;
import xuxin.task.Task;

/**
 * A Ui class to manage IO output.
 */
public class Ui {
    private StringBuilder output;

    public Ui() {
        output = new StringBuilder();
    }

    void resetOutput() {
        output.setLength(0);
    }

    String showOutput() {
        return output.toString();
    }

    private void appendToOutput(String message) {
        output.append(message + "\n");
    }

    public void showError(String message) {
        appendToOutput("OOPS!!! " + message);
    }

    /**
     * Prints the exit message.
     *
     */
    public void showGoodbye() {
        appendToOutput("Bye. Hope to see you again!");
    }

    public void showTaskList(ArrayList<Task> tasks) {
        appendToOutput("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            appendToOutput((i + 1) + ". " + tasks.get(i));
        }
    }

    public void showTaskCount(int count) {
        appendToOutput("Now you have " + count + " tasks in the list.");
    }

    public void addSuccess(Task task) {
        appendToOutput("Got it. I've added this task: \n" + task);
    }

    public void addMessage(String message) {
        appendToOutput(message);
    }
}
