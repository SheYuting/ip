public class Event extends Task {
    private static String statum = "[E]";
    private String start;
    private String end;

    Event(String name, String start, String end) {
        super(name);
        this.start = start;
        this.end = end;
    }

    public String toString() {
        return statum + super.toString() +
                String.format(" (from: %s to: %s)", start, end);
    }
}
