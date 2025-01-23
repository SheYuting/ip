import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    private static ArrayList<String> toDoList = new ArrayList<>();
    public static void main(String[] args) {
        /*String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);*/
        greet();

        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            command = scanner.nextLine();
            if (command.equals("bye")) {
                break;
            } else if (command.equals("list")) {
                printList();
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
        toDoList.add(command);
        System.out.println("added: " + command);
        System.out.println("____________________________________________________________");
    }

    public static void exit() {
        System.out.println("Bye. Hope to see you again");
        System.out.println("____________________________________________________________");
    }

    public static void printList() {
        System.out.println("____________________________________________________________");
        for (String s : toDoList) {
            System.out.println(s);
        }
        System.out.println("____________________________________________________________");
    }
}
