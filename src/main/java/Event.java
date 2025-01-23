public class Event extends Task {
    private static String statum = "[E]";
    private String start;
    private String end;

    Event(String name, String[] strings) {
        super(name);
        this.start = strings[1];
        this.end = strings[2];
    }

    public String toString() {
        String fromTokens = start.substring(5);
        String toTokens = end.substring(3);
        return statum + super.toString() +
                String.format(" (from: %s to: %s)",
                        fromTokens, toTokens);
    }
}
