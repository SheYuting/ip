public class Duke {
    public static void main(String[] args) {
        /*String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);*/
        greet();
        exit();
    }

    public static void greet() {
        String logo = "Duke";
        System.out.println("Hello! I'm " + logo);
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    public static void exit() {
        System.out.println("Bye. Hope to see you again");
        System.out.println("____________________________________________________________");
    }
}
