package duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *  This class represents a Deadline.
 *  A Deadline: tasks that need to be done before a specific date/time.
 *
 * @author Ryan Tian Jun.
 */
public class DeadLine extends Task {

    private String by;
    private LocalDate date;

    public DeadLine(String description, Task.TYPE type, String by) {
        super(description, type);
        try {
            LocalDate d1 = LocalDate.parse(by);
            this.date = d1;
            this.by = d1.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        } catch (DateTimeParseException dateTimeParseException) {
            this.by = by;
        }
    }

    public DeadLine(Task.TYPE type, boolean isDone, String description, String by) {
        super(type, isDone, description);
        this.by = by;
    }

    @Override
    public String getTime() {
        return by;
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + by + ")";
    }
}