import java.util.List;

public interface ReadInfo {
    String infoSrc = "infos.txt";

    List<Student> readStudentInfo(String infoSrc);
}
