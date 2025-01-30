public abstract class Task {
    protected String name;
    protected String status;
    protected String des = "[ ]";
    protected boolean isDone;

    Task(String name, boolean isDone) {
        this.name = name;
        this.status  = "[ ]";
        this.isDone = isDone;
    }

    public void markTask() {
        this.status = "[x]";
        this.isDone = true;
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(toString());
        System.out.println("____________________________________________________________");
    }

    public void unmarkTask() {
        this.status = "[ ]";
        this.isDone = false;
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(toString());
        System.out.println("____________________________________________________________");
    }

    public String toString() {
        return this.status + " " + this.name;
    }

    public abstract String toFileFormat();
}
