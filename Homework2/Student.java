public class Student {
    enum EmailType {
        TSINGHUA, QQ, NETEASE163
    }

    enum PhoneType {
        MOBILE, LANDLINE
    }

    enum SexType {
        MAN, WOMAN
    }

    enum IdCardType {
        NUM15, NUM18
    }

    enum StudentType {
        BACHELOR, MASTER, DOCTOR
    }

    Student(String emailType, String email, String phoneType,
                   String phone, String sexType, String idCardType,
                   String idCard, String studentType, String studentId) {
        this.emailType = EmailType.valueOf(emailType);
        this.email = email;
        this.phoneType = PhoneType.valueOf(phoneType);
        this.phone = phone;
        this.sexType = SexType.valueOf(sexType);
        this.idCardType = IdCardType.valueOf(idCardType);
        this.idCard = idCard;
        this.studentType = StudentType.valueOf(studentType);
        this.studentId = studentId;
    }

    EmailType emailType;
    PhoneType phoneType;
    SexType sexType;
    IdCardType idCardType;
    StudentType studentType;

    String email, phone, idCard, studentId;
}
