package duke.task;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EventTest {
    @Test
    void eventTestWithDate(){
        Event test = new Event("event", "12/01/2025");
        assertEquals("[E][ ] event (at: Jan 12 2025)", test.toString(), "toString() method works");

        test.markAsDone();
        assertEquals("[E][x] event (at: Jan 12 2025)", test.toString(), "markAsDone() method works");
    }
}