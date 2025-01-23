public class Task {
    protected String name;
    protected String status;

    Task(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public void markTask() {
        this.status = "[x]";
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(getName());
        System.out.println("____________________________________________________________");
    }

    public void unmarkTask() {
        this.status = "[ ]";
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(getName());
        System.out.println("____________________________________________________________");
    }

    public String getName() {
        return this.status + " " + this.name;
    }
}
