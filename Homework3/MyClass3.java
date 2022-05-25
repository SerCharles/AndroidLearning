import java.util.*;

import javax.lang.model.util.ElementScanner6;

public class MyClass3 extends AbsClass{

    // Q1----------------------------------------------------------------------------------------
    static class MyListIndexOutOfBoundsException extends Exception {
        MyListIndexOutOfBoundsException(ArrayList arrayList)
        {
            super(arrayList.size() + "");
        }
    }

    @Override
    public int getEle(ArrayList<Integer> list, int pos, boolean handle) throws MyListIndexOutOfBoundsException {
        int Length = list.size();
        if(pos < 0 || pos >= Length)
        {
            MyListIndexOutOfBoundsException TheException = new MyListIndexOutOfBoundsException(list);
            if(handle)
            {
                return Integer.MAX_VALUE;
            }
            else
            {
                throw TheException;
            }
        }
        else
        {
            int result = list.get(pos).intValue();
            return result;
        }
    }

    // Q2----------------------------------------------------------------------------------------

    static class Student {
        public double grade;
        public boolean gender;
        public String stuId;

        public Student(double grade, boolean gender, String stuId) {
            this.grade = grade;
            this.gender = gender;
            this.stuId = stuId;
        }
    }

    @Override
    public void sortEle(ArrayList<Student> arrayList) {

        //自定义排序
        Collections.sort(arrayList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
              if(o1.grade > o2.grade) 
              {
                return -1;  //成绩高放前面
              }
              else if(o1.grade < o2.grade)
              {
                return 1;
              }
              else
              {
                  if(o1.gender == true && o2.gender == false)
                  {
                      return -1;    //性别优先放前面
                  }
                  else if(o1.gender == false && o2.gender == true)
                  {
                      return 1;
                  }
                  else
                  {
                      return o1.stuId.compareTo(o2.stuId); //字典序比较
                  }
              }
            }
          });
        
    }


    // Q3----------------------------------------------------------------------------------------
    private String SwapPlaces(String TheString, int Place1, int Place2)
    {
        char[] TheList = TheString.toCharArray();
        char temp = TheList[Place1];
        TheList[Place1] = TheList[Place2];
        TheList[Place2] = temp;
        String NewString = new String(TheList);
        return NewString;
    }
    private String Jump(String TheState, int Bias)
    {
        int ZeroPlace = TheState.indexOf('0');
        int NewPlace = ZeroPlace + Bias;
        if(NewPlace < 0)
        {
            NewPlace = NewPlace + 9;
        }
        else
        {
            NewPlace = NewPlace % 9;
        }
        String NewString = SwapPlaces(TheState, ZeroPlace, NewPlace);
        return NewString;
    }


    @Override
    public int lessJump(String startState) {

        int JumpDirections[] = {-1, -2, 1, 2};
        ArrayList<String> TheQueue = new ArrayList<String>();
        ArrayList<Integer> StepQueue = new ArrayList<Integer>();
        HashMap<String, String> VisitHash= new HashMap<String, String>();          
        String EndState = "087654321";
        if(startState.equals(EndState))
        {
            return 0;
        }
        TheQueue.add(startState);
        StepQueue.add(0);
        VisitHash.put(startState, "1");
        int head = 0;
        int tail = 0;

        while(head <= tail)
        {
            
            for(int i = 0; i <= 3; i ++)
            {
                String TheState = TheQueue.get(head);
                int TheStep = StepQueue.get(head).intValue();
                String NewState = new String();
                NewState = Jump(TheState, JumpDirections[i]);
                if(VisitHash.containsKey(NewState) == false)
                {
                    VisitHash.put(NewState, "1");
                    TheQueue.add(NewState);
                    StepQueue.add(TheStep + 1);
                    tail ++;
                    if(NewState.equals(EndState))
                    {
                        //System.out.println(TheStep + 1);
                        return TheStep + 1;
                    }
                }
            }
            head ++;
        }
        return -1;
    }

}
