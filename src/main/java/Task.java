public class Task {
    protected String name;
    protected String status;
    protected String des = "[ ]";

    Task(String name) {
        this.name = name;
        this.status  = "[ ]";
    }

    public void markTask() {
        this.status = "[x]";
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(toString());
        System.out.println("____________________________________________________________");
    }

    public void unmarkTask() {
        this.status = "[ ]";
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(toString());
        System.out.println("____________________________________________________________");
    }

    public String toString() {
        return this.status + " " + this.name;
    }
}
