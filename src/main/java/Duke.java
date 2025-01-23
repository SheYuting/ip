import java.util.Scanner;

public class Duke {
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
            }
            echo(command);
        }

        exit();
    }

    public static void greet() {
        String logo = "Duke";
        System.out.println("Hello! I'm " + logo);
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    public static void echo(String command) {
        System.out.println("____________________________________________________________");
        System.out.println(command);
        System.out.println("____________________________________________________________");
    }

    public static void exit() {
        System.out.println("Bye. Hope to see you again");
        System.out.println("____________________________________________________________");
    }
}
