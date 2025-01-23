import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    private static ArrayList<Task> toDoList = new ArrayList<>();
    public static void main(String[] args) {
        greet();

        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            command = scanner.nextLine();
            if (command.equals("bye")) {
                break;
            } else if (command.equals("list")) {
                printList();
            } else if (command.startsWith("mark")) {
                markTask(command);
            } else if (command.startsWith("unmark")) {
                unmarkTask(command);
            } else {
                addList(command);
            }
        }

        exit();
    }

    public static void greet() {
        String logo = "Duke";
        System.out.println("Hello! I'm " + logo);
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    public static void addList(String command) {
        System.out.println("____________________________________________________________");
        System.out.println("Got it. I've added this task:");
        Task task;
        if (command.startsWith("todo")) {
            String taskDescription = command.substring(5);
            task = new Todo(taskDescription);
            toDoList.add(task);
        } else if (command.startsWith("deadline")) {
            command = command.substring(9);
            String[] taskDescription = command.split(" /by ");
            task = new Deadline(taskDescription[0], taskDescription[1]);
            toDoList.add(task);
        } else if (command.startsWith("event")) {
            command = command.substring(6);
            String[] taskDescription = command.split(" /");
            task = new Event(taskDescription[0], taskDescription);
            toDoList.add(task);
        } else {
            task = new Task(command);
            toDoList.add(task);
        }
        System.out.println(task.toString());
        check();
        System.out.println("____________________________________________________________");
    }

    public static void exit() {
        System.out.println("Bye. Hope to see you again");
        System.out.println("____________________________________________________________");
    }

    public static void printList() {
        System.out.println("____________________________________________________________");
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < toDoList.size(); i++) {
            int index = i + 1;
            System.out.println(index + "." + toDoList.get(i).toString());
        }
        System.out.println("____________________________________________________________");
    }

    public static void unmarkTask(String command) {
        int index = Integer.parseInt(command.split(" ")[1]);
        Task targetTask = toDoList.get(index - 1);
        targetTask.unmarkTask();
    }

    public static void markTask(String command) {
        int index = Integer.parseInt(command.split(" ")[1]);
        Task targetTask = toDoList.get(index - 1);
        targetTask.markTask();
    }

    public static void check() {
        System.out.println(String.format("Now you have %d tasks in the list.", toDoList.size()));
    }


}
