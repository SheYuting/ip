import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    public void showWelcome() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    public String readCommand() {
        return new Scanner(System.in).nextLine().trim();
    }

    public void showError(String message) {
        System.out.println("OOPS!!! " + message);
        System.out.println("____________________________________________________________");
    }

    public void showLine() {
        System.out.println("____________________________________________________________");
    }

    public void showLoadingError() {
        System.out.println("There was an error loading the tasks.");
    }

    public void showGoodbye() {
        System.out.println("Bye. Hope to see you again!");
        System.out.println("____________________________________________________________");
    }

    public void showTaskList(ArrayList<Task> tasks) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void showTaskCount(int count) {
        System.out.println("Now you have " + count + " tasks in the list.");
    }

    public void addSuccess(Task task) {
        System.out.println("Got it. I've added this task:\n  " + task);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
