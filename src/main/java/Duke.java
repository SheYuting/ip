import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    private static ArrayList<Task> toDoList = new ArrayList<>();
    private static final String FILE_PATH = "./data/duke.txt";

    public static void main(String[] args) {
        greet();

        toDoList = Storage.loadTasks(FILE_PATH); // Load tasks at startup
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
                    Storage.saveTasks(FILE_PATH, toDoList); // Save tasks after modification
                } catch (DukeException e) {
                    printError(e.getMessage());
                }
            }
        }

        exit();
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
        Task task;
        if (command.startsWith("todo")) {
            if (command.length() <= 5) throw new DukeException("The description of a todo cannot be empty.");
            task = new Todo(command.substring(5).trim());
        } else if (command.startsWith("deadline")) {
            if (!command.contains(" /by ")) throw new DukeException("A deadline must have '/by '.");
            String[] parts = command.substring(9).split(" /by ");
            if (parts.length < 2) throw new DukeException("Incomplete deadline format.");
            task = new Deadline(parts[0].trim(), parts[1].trim());
        } else if (command.startsWith("event")) {
            if (!command.contains(" /from ") || !command.contains(" /to ")) throw new DukeException("An event must have '/from' and '/to'.");
            String[] parts = command.substring(6).split(" /from ");
            String[] timeParts = parts[1].split(" /to ");
            task = new Event(parts[0].trim(), timeParts[0].trim(), timeParts[1].trim());
        } else {
            throw new DukeException("Unknown command.");
        }

        toDoList.add(task);
        System.out.println("Got it. I've added this task:\n  " + task);
        checkTaskCount();
    }

    public static void deleteTask(String command) throws DukeException {
        int index = parseTaskIndex(command, "delete");
        Task task = toDoList.remove(index);
        System.out.println("Noted. I've removed this task:\n  " + task);
        checkTaskCount();
    }

    public static void markTask(String command) throws DukeException {
        int index = parseTaskIndex(command, "mark");
        toDoList.get(index).markTask();
        Storage.saveTasks(FILE_PATH, toDoList);
    }

    public static void unmarkTask(String command) throws DukeException {
        int index = parseTaskIndex(command, "unmark");
        toDoList.get(index).unmarkTask();
        Storage.saveTasks(FILE_PATH, toDoList);
    }

    public static void printList() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < toDoList.size(); i++) {
            System.out.println((i + 1) + ". " + toDoList.get(i));
        }
    }

    private static int parseTaskIndex(String command, String action) throws DukeException {
        String[] parts = command.split(" ");
        if (parts.length < 2) throw new DukeException("Please specify a task number to " + action + ".");
        try {
            int index = Integer.parseInt(parts[1]) - 1;
            if (index < 0 || index >= toDoList.size()) throw new DukeException("Invalid task number.");
            return index;
        } catch (NumberFormatException e) {
            throw new DukeException("Task number must be a valid integer.");
        }
    }

    public static void checkTaskCount() {
        System.out.println("Now you have " + toDoList.size() + " tasks in the list.");
    }

    public static void printError(String message) {
        System.out.println("OOPS!!! " + message);
    }

    public static void greet() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    public static void exit() {
        System.out.println("Bye. Hope to see you again!");
    }
}