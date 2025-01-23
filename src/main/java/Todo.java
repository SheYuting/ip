public class Todo extends Task {
    private static String statum = "[T]";

    Todo(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return statum + super.toString();
    }
}
