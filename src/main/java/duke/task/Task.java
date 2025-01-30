package duke.task;

public abstract class Task {
    protected String name;
    protected String status;
    protected String des = "[ ]";
    protected boolean isDone;

    public Task(String name, boolean isDone) {
        this.name = name;
        this.status  = "[ ]";
        this.isDone = isDone;
    }

    public void markTask() {
        this.status = "[x]";
        this.isDone = true;
    }

    public void unmarkTask() {
        this.status = "[ ]";
        this.isDone = false;
    }

    public String toString() {
        return this.status + " " + this.name;
    }

    public abstract String toFileFormat();
}
