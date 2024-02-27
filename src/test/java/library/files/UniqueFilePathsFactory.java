package library.files;

import java.util.UUID;

public class UniqueFilePathsFactory {
    public static final String defaultFilePath = "src/test/java/library/files/";

    public static String generateAvailableCoursesFilePath() {
        return defaultFilePath + UUID.randomUUID() + "availableCourses.txt";
    }
}
