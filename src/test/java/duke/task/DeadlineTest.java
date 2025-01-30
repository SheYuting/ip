package duke.task;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeadlineTest {
    @Test
    void deadlineTestWithString(){
        Deadline test = new Deadline("deadline", "31/01/2025");
        assertEquals("[D][ ] deadline (by: Jan 31 2025)", test.toString(), "toString() method works");

        test.markAsDone();
        assertEquals("[D][x] deadline (by: Jan 31 2025)", test.toString(), "markAsDone() method works");
    }

    @Test
    void deadlineTestWithDate(){
        Deadline test = new Deadline("deadline", "01/01/2025");
        assertEquals("[D][ ] deadline (by: Jan 01 2025)", test.toString(), "toString() method works");

        test.markAsDone();
        assertEquals("[D][x] deadline (by: Jan 01 2025)", test.toString(), "markAsDone() method works");
    }
}
