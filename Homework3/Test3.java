import java.util.ArrayList;
import java.util.Comparator;

public class Test3 {
    private MyClass3 myClass;

    ArrayList<Integer> mainTestList = new ArrayList<Integer>();
    ArrayList<MyClass3.Student> stuList = new ArrayList<MyClass3.Student>();

    public Test3(MyClass3 myClass) {
        this.myClass = myClass;
        int cnt;
        long id = 10000000;
        for (int i = 0; i < 20; i++) {
            cnt = (int) (Math.random() * (100 - 90) + 90);
            mainTestList.add(cnt);
            MyClass3.Student newstu = new MyClass3.Student(cnt, Math.random() > 0.5 ? Boolean.TRUE : Boolean.FALSE,
                    String.valueOf(id));
            stuList.add(newstu);
            id++;
        }
        stuList.add(new MyClass3.Student(95, true, "20000000"));
        stuList.add(new MyClass3.Student(95, true, "20000001"));
    }

    private boolean checkSort() {
        ArrayList<MyClass3.Student> bufList = new ArrayList<MyClass3.Student>(stuList);
        bufList.sort((student, t1) -> {
            if (student.grade != t1.grade)
                return student.grade < t1.grade ? 1 : -1;
            else if (student.gender != t1.gender)
                return student.gender == false ? 1 : -1;
            else
                return student.stuId.compareTo(t1.stuId);
        });
        myClass.sortEle(stuList);
        if (bufList.size() != stuList.size())
            return false;
        for (int i = 0; i < bufList.size(); i++) {
            MyClass3.Student stu1 = bufList.get(i);
            MyClass3.Student stu2 = stuList.get(i);
            if (!stu1.stuId.equals(stu2.stuId) || stu1.gender != stu2.gender || stu1.grade != stu2.grade) {
                return false;
            }
        }
        return true;
    }



    private boolean checkGet() {
        boolean tag1 = false;
        int ans3;
        mainTestList.add(0);
        try {
            ans3 = myClass.getEle(mainTestList, mainTestList.size(), true);
            if (ans3 != Integer.MAX_VALUE)
                return false;
        } catch (Exception e) {
            return false;
        }
        try {
            ans3 = myClass.getEle(mainTestList, mainTestList.size(), false);
        } catch (MyClass3.MyListIndexOutOfBoundsException e) {
            if (! e.getMessage().equals(String.valueOf(mainTestList.size())))
                return false;
            tag1 = true;
        } catch (Exception e) {
            return false;
        }
        try {
            ans3 = myClass.getEle(mainTestList, 0, false);
            if (ans3 != mainTestList.get(0))
                return false;
            ans3 = myClass.getEle(mainTestList, 0, true);
            if (ans3 != mainTestList.get(0))
                return false;
        } catch (Exception e) {
            return false;
        }
        return tag1;
    }

    private boolean checkJump() {
        if(myClass.lessJump("012345678") != 20)
            return false;
        if(myClass.lessJump("012543678") != 17)
            return false;
        if(myClass.lessJump("140758326") != 12)
            return false;
        if(myClass.lessJump("370842516") != 14)
            return false;
        return true;
    }

    public int getScore() {
        int score = 0;
        boolean isSelCorrect, isClearCorrect, isGetCorrect;

        try {
            isSelCorrect = checkSort();
        } catch (Exception e) {
            isSelCorrect = false;
        }
        score += isSelCorrect ? 30 : 0;

        try {
            isClearCorrect = checkJump();
        } catch (Exception e) {
            isClearCorrect = false;
        }
        score += isClearCorrect ? 40 : 0;
        try {
            isGetCorrect = checkGet();
        } catch (Exception e) {
            isGetCorrect = false;
        }
        score += isGetCorrect ? 30 : 0;
        return score;
    }
}
