import java.util.*;
public class Map {
    public static void main(String[] args) {
        Map<String, List<String>> StudentCourses = new HashMap<>();
        StudentCourses.put("Ikenna", new ArrayList<>());
        StudentCourses.get("Ikenna").add("CS10");

        //check
        System.out.println(studentCourses.get("Ikenna"));
    }
}
