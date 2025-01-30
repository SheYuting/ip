import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {
    private static String statum = "[D]";
    private String date;

    Deadline(String name, String date) {
        super(name, false);
        this.date = date;
        this.isDone = isDone;
    }

    Deadline(String name, String date, boolean isDone) {
        super(name, isDone);
        this.date = date;
    }

    @Override
    public String toString() {
        return statum + super.toString() + String.format(" (by: %s)", this.date);
    }

    @Override
    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + this.name + " | "
                + String.format(" (by: %s)", this.date);
    }

}
