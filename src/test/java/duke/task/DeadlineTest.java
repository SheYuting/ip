package duke.task;

import org.junit.jupiter.api.Test;
import duke.exception.DukeException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeadlineTest {
    @Test
    void deadlineTestWithDate() throws DukeException {
        Deadline test = new Deadline("ddl", "01/01/2025");
        assertEquals("[D][ ] deadline (by: Jan 01 2025)", test.toString(), "toString() method works");

        test.markTask();
        assertEquals("[D][x] ddl (by: Jan 01 2025)", test.toString(), "markTask() method works");
    }
}
