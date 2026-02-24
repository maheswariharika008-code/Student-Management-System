import java.io.*;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class StudentFileHandler {

    private static final String FILE_NAME = "students.json";
    private static Gson gson = new Gson();

    public static List<Student> readStudents() {
        try (Reader reader = new FileReader(FILE_NAME)) {
            return gson.fromJson(reader, new TypeToken<List<Student>>(){}.getType());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void writeStudents(List<Student> students) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(students, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

