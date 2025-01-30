import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    private static ArrayList<Task> toDoList = new ArrayList<>();

    public static void main(String[] args) {
        greet();

        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            command = scanner.nextLine().trim();
            if (command.equals("bye")) {
                break;
            } else if (command.equals("list")) {
                printList();
            } else {
                try {
                    processCommand(command);
                } catch (DukeException e) {
                    printError(e.getMessage());
                }
            }
        }

        exit();
    }

    public static void greet() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    public static void processCommand(String command) throws DukeException {
        if (command.startsWith("mark")) {
            markTask(command);
        } else if (command.startsWith("unmark")) {
            unmarkTask(command);
        } else if (command.startsWith("delete")) {
            deleteTask(command);
        } else {
            addTask(command);
        }
    }

    public static void addTask(String command) throws DukeException {
        System.out.println("____________________________________________________________");
        Task task;
        if (command.startsWith("todo")) {
            if (command.length() <= 5) {
                throw new DukeException("The description of a todo cannot be empty.");
            }
            String description = command.substring(5).trim();
            task = new Todo(description);
        } else if (command.startsWith("deadline")) {
            if (!command.contains(" /by ")) {
                throw new DukeException("A deadline must have a description and a due date (use '/by').");
            }
            String[] parts = command.substring(9).split(" /by ");
            if (parts.length < 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
                throw new DukeException("Incomplete deadline description or due date.");
            }
            task = new Deadline(parts[0].trim(), parts[1].trim());
        } else if (command.startsWith("event")) {
            if (!command.contains(" /from ") || !command.contains(" /to ")) {
                throw new DukeException("An event must have a description, start time, and end time (use '/from' and '/to').");
            }
            String[] parts = command.substring(6).split(" /from ");
            if (parts.length < 2 || parts[0].isEmpty()) {
                throw new DukeException("Incomplete event description.");
            }
            String description = parts[0].trim();
            String[] timeParts = parts[1].split(" /to ");
            if (timeParts.length < 2 || timeParts[0].isEmpty() || timeParts[1].isEmpty()) {
                throw new DukeException("Incomplete event time details.");
            }
            task = new Event(description, timeParts[0].trim(), timeParts[1].trim());
        } else {
            throw new DukeException("I'm sorry, I don't understand that command.");
        }

        toDoList.add(task);
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        checkTaskCount();
        System.out.println("____________________________________________________________");
    }

    public static void printList() {
        System.out.println("____________________________________________________________");
        if (toDoList.isEmpty()) {
            System.out.println("Your task list is empty.");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println((i + 1) + "." + toDoList.get(i));
            }
        }
        System.out.println("____________________________________________________________");
    }

    public static void deleteTask(String command) throws DukeException {
        int index = parseTaskIndex(command, "delete");
        Task task = toDoList.get(index);
        toDoList.remove(index);
        System.out.println("____________________________________________________________");
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + task);
        checkTaskCount();
        System.out.println("____________________________________________________________");
    }

    public static void markTask(String command) throws DukeException {
        int index = parseTaskIndex(command, "mark");
        Task task = toDoList.get(index);
        task.markTask();
    }

    public static void unmarkTask(String command) throws DukeException {
        int index = parseTaskIndex(command, "unmark");
        Task task = toDoList.get(index);
        task.unmarkTask();
        System.out.println("____________________________________________________________");
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + task);
        System.out.println("____________________________________________________________");
    }

    private static int parseTaskIndex(String command, String action) throws DukeException {
        String[] parts = command.split(" ");
        if (parts.length < 2) {
            throw new DukeException("Please specify the task number to " + action + ".");
        }
        try {
            int index = Integer.parseInt(parts[1]) - 1;
            if (index < 0 || index >= toDoList.size()) {
                throw new DukeException("Invalid task number. Please choose a valid task.");
            }
            return index;
        } catch (NumberFormatException e) {
            throw new DukeException("Task number must be a valid integer.");
        }
    }

    public static void checkTaskCount() {
        System.out.println(String.format("Now you have %d tasks in the list.", toDoList.size()));
    }

    public static void printError(String message) {
        System.out.println("OOPS!!! " + message);
        System.out.println("____________________________________________________________");
    }

    public static void exit() {
        System.out.println("Bye. Hope to see you again!");
        System.out.println("____________________________________________________________");
    }
}