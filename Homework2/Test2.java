import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public int getScore() {
        MyClass2 myClass2 = new MyClass2();
        if (!(myClass2 instanceof AbsClass) || !(myClass2 instanceof ReadInfo))
            return 0;
        List<Student> studentList = myClass2.readStudentInfo(myClass2.infoSrc);
        BufferedReader bufferedReader;
        List<List<Boolean>> realRlt = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader("rlt.txt"));
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String corrects[] = line.split(",");
                List<Boolean> list = new ArrayList<>();
                for (String correct : corrects)
                    list.add(Boolean.valueOf(correct));
                realRlt.add(list);
            }
        } catch (Exception e) {
            return 0;
        }
        int totalInfoNum = studentList.size() * 4, rltMatchNum = 0;
        try {
            for (int i = 0; i < studentList.size(); ++i) {
                List<Boolean> predRlt = myClass2.checkStudentInfo(studentList.get(i)),
                        trueRlt = realRlt.get(i);
                for (int j = 0; j < predRlt.size(); ++j) {
                    if (predRlt.get(j) == trueRlt.get(j))
                        ++rltMatchNum;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (rltMatchNum * 100) / totalInfoNum;
    }

    public void checkStudentInfos() {
        MyClass2 myClass2 = new MyClass2();
        List<Student> studentList = myClass2.readStudentInfo(myClass2.infoSrc);
        List<Boolean> booleans;
        OutputStream outputStream;
        PrintWriter printWriter;
        try {
            File file = new File("rlt.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            outputStream = new FileOutputStream(file);
            printWriter = new PrintWriter(outputStream);
            printWriter.write("邮箱格式是否正确,电话格式是否正确,身份证格式是否正确,学号格式是否正确\r\n");
        } catch (Exception e) {
            printWriter = null;
        }
        for (Student student : studentList) {
            booleans = myClass2.checkStudentInfo(student);
            if (printWriter != null) {
                for (boolean b : booleans)
                    printWriter.write(b + ",");
                printWriter.write("\r\n");
            }
        }
        if (printWriter != null)
            printWriter.close();
    }
}
