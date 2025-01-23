import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {
    private static String statum = "[D]";
    private String date;

    Deadline(String name, String date) {
        super(name);
        this.date = date;
    }

    @Override
    public String toString() {
        return statum + super.toString() + String.format(" (by: %s)", this.date);
    }

}
