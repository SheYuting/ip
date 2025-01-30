public class Event extends Task {
    private static String statum = "[E]";
    private String start;
    private String end;

    Event(String name, String start, String end) {
        super(name, false);
        this.start = start;
        this.end = end;
    }

    Event(String name, String start, String end, boolean isDone) {
        super(name, isDone);
        this.start = start;
        this.end = end;
    }

    public String toString() {
        return statum + super.toString() +
                String.format(" (from: %s to: %s)", start, end);
    }

    @Override
    public String toFileFormat() {
        return "E | " + (isDone ? "1" : "0") + " | " + this.name + " | "
                + String.format(" (from: %s to: %s)", start, end);
    }
}
