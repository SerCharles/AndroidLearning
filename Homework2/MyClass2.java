import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyClass2 extends AbsClass implements ReadInfo {
    @Override
    public List<Boolean> checkStudentInfo(Student student) {
        List<Boolean> isInfoCorrect = new ArrayList<>();


        String MailsQQ = "^[1-9]\\d{4,12}@qq.com$";
        String MailsTsinghua = "^[a-z]{2,6}\\d{2}@mails.tsinghua.edu.cn$";
        String MailsNetEase = "^.{1,}@163.com$";
        String Cellphone = "^1\\d{10}$";
        String Phone = "^(\\d{3,4}-)?\\d{7,8}$";
        String ID15Male = "^\\d{8}(0[1-9]|1[0-2])(0[1-9]|[1-2]\\d|30)\\d{2}(1|3|5|7|9)$";
        String ID15Female = "^\\d{8}(0[1-9]|1[0-2])(0[1-9]|[1-2]\\d|30)\\d{2}(0|2|4|6|8)$";
        String ID18Male = "^\\d{6}(19\\d{2}|200\\d{1})(0[1-9]|1[0-2])(0[1-9]|[1-2]\\d|30)\\d{2}(1|3|5|7|9)(\\d|X)$";
        String ID18Female = "^\\d{6}(19\\d{2}|200\\d{1})(0[1-9]|1[0-2])(0[1-9]|[1-2]\\d|30)\\d{2}(0|2|4|6|8)(\\d|X)$";
        String StudentBachelor = "^20[0-1]\\d{1}[0-1]\\d{5}$";
        String StudentMaster = "^20[0-1]\\d{1}[2]\\d{5}$";
        String StudentDoctor = "^20[0-1]\\d{1}[3]\\d{5}$";

        if(student.emailType.equals(Student.EmailType.QQ))
        {
            isInfoCorrect.add(student.email.matches(MailsQQ));
        }
        else if(student.emailType.equals(Student.EmailType.TSINGHUA))
        {
            isInfoCorrect.add(student.email.matches(MailsTsinghua));
        }
        else if(student.emailType.equals(Student.EmailType.NETEASE163))
        {
            isInfoCorrect.add(student.email.matches(MailsNetEase));
        }
        if(student.phoneType.equals(Student.PhoneType.LANDLINE))
        {
            isInfoCorrect.add(student.phone.matches(Phone));
        }
        else if(student.phoneType.equals(Student.PhoneType.MOBILE))
        {
            isInfoCorrect.add(student.phone.matches(Cellphone));
        }
        if(student.sexType.equals(Student.SexType.MAN))
        {
            if(student.idCardType.equals(Student.IdCardType.NUM15))
            {
                isInfoCorrect.add(student.idCard.matches(ID15Male));
            }
            else if(student.idCardType.equals(Student.IdCardType.NUM18))
            {
                isInfoCorrect.add(student.idCard.matches(ID18Male));
            }
        }
        else if(student.sexType.equals(Student.SexType.WOMAN))
        {
            if(student.idCardType.equals(Student.IdCardType.NUM15))
            {
                isInfoCorrect.add(student.idCard.matches(ID15Female));
            }
            else if(student.idCardType.equals(Student.IdCardType.NUM18))
            {
                isInfoCorrect.add(student.idCard.matches(ID18Female));
            } 
        }
        if(student.studentType.equals(Student.StudentType.BACHELOR))
        {
            isInfoCorrect.add(student.studentId.matches(StudentBachelor));
        }
        else if(student.studentType.equals(Student.StudentType.MASTER))
        {
            isInfoCorrect.add(student.studentId.matches(StudentMaster));
        }
        else if(student.studentType.equals(Student.StudentType.DOCTOR))
        {
            isInfoCorrect.add(student.studentId.matches(StudentDoctor));
        }

        
        //System.out.println("703671196810300161".matches(ID18Female));
        //System.out.println("17093020071130113X".matches(ID18Male));
        

        /*
        System.out.println("1215129057@qq.com".matches(MailsQQ));
        System.out.println("1215129057@qq.com".matches(MailsTsinghua));
        System.out.println("sgl17@mails.tsinghua.edu.cn".matches(MailsTsinghua));
        System.out.println("sgl17@mails.tsinghua.edu.cn".matches(MailsNetEase));
        System.out.println("shenguanlin1999@163.com".matches(MailsNetEase));
        System.out.println("kebab-shenguanlin1999@163.com-reich".matches(MailsNetEase));
        System.out.println("18309858512".matches(Cellphone));
        System.out.println("28309858512".matches(Cellphone));
        System.out.println("82035328".matches(Phone));
        System.out.println("024-82035328".matches(Phone));
        System.out.println("---------------------------------------------");
        System.out.println("210106990208211".matches(ID15Male));
        System.out.println("210106990208211".matches(ID15Female));
        System.out.println("210106990208211".matches(ID18Male));
        System.out.println("210106990208211".matches(ID18Female));
        System.out.println("210106671021402".matches(ID15Male));
        System.out.println("210106671021402".matches(ID15Female));
        System.out.println("210106671021402".matches(ID18Male));
        System.out.println("210106671021402".matches(ID18Female));
        System.out.println("210106199902082118".matches(ID15Male));
        System.out.println("210106199902082118".matches(ID15Female));
        System.out.println("210106199902082118".matches(ID18Male));
        System.out.println("210106199902082118".matches(ID18Female));
        System.out.println("210106196710214020".matches(ID15Male));
        System.out.println("210106196710214020".matches(ID15Female));
        System.out.println("210106196710214020".matches(ID18Male));
        System.out.println("210106196710214020".matches(ID18Female));
        System.out.println("---------------------------------------------");
        System.out.println("2017013569".matches(StudentBachelor));
        System.out.println("2017013569".matches(StudentMaster));
        System.out.println("2017013569".matches(StudentDoctor));
        System.out.println("2017213569".matches(StudentBachelor));
        System.out.println("2017213569".matches(StudentMaster));
        System.out.println("2017213569".matches(StudentDoctor));
        System.out.println("2017313569".matches(StudentBachelor));
        System.out.println("2017313569".matches(StudentMaster));
        System.out.println("2017313569".matches(StudentDoctor));
        System.out.println("1999013569".matches(StudentBachelor));
        System.out.println("1999013569".matches(StudentMaster));
        System.out.println("1999013569".matches(StudentDoctor));
        System.out.println("---------------------------------------------");
        */
        return isInfoCorrect;
    }

    @Override
    public List<Student> readStudentInfo(String filename) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            bufferedReader.readLine();
            List<Student> studentList = new ArrayList<>();
            String paramStr;
            while ((paramStr = bufferedReader.readLine()) != null) {
                String params[] = paramStr.split(",");
                studentList.add(new Student(params[0], params[1], params[2], params[3], params[4],
                        params[5], params[6], params[7], params[8]));
            }
            return studentList;
        } catch (Exception e) {
            return null;
        }
    }
}
