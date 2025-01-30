import java.io.*;
import java.util.ArrayList;

public class Storage {
    public static void saveTasks(String filePath, ArrayList<Task> tasks) throws DukeException {
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs(); // Ensure directory exists

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (Task task : tasks) {
                writer.write(task.toFileFormat());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            throw new DukeException("Error saving tasks.");
        }
    }

    public static ArrayList<Task> loadTasks(String filePath) {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);

        if (file.exists()) { file.delete(); }
        if (!file.exists()) return tasks; // No file? Return empty list.

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    tasks.add(parseTask(line)); // Try parsing each line
                } catch (DukeException e) {  // Catch DukeException here
                    System.out.println("Corrupt data detected. Deleting existing file.");
                    file.delete(); // Delete corrupted file
                    return new ArrayList<>(); // Return empty list
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }

        return tasks;
    }

    private static Task parseTask(String line) throws DukeException {
        String[] parts = line.split(" \\| ");
        if (parts.length < 3) throw new DukeException("Invalid file format.");

        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String description = parts[2];

        switch (type) {
            case "T":
                return new Todo(description, isDone);
            case "D":
                return new Deadline(description, parts[3], isDone);
            case "E":
                String[] timeParts = parts[3].split(" to ");
                return new Event(description, timeParts[0], timeParts[1], isDone);
            default:
                throw new DukeException("Unknown task type.");
        }
    }
}
