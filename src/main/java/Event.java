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
        String fromTokens = start.substring(5);
        String toTokens = end.substring(3);
        return statum + super.toString() +
                String.format(" (from: %s to: %s)",
                        fromTokens, toTokens);
    }
}
