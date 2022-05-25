import java.util.ArrayList;

public abstract class AbsClass {
    public ArrayList<Integer> arrayList1;
    public ArrayList<Integer> arrayList2;

    public abstract void sortEle(ArrayList<MyClass3.Student> arrayList);
    public abstract int getEle(ArrayList<Integer> list, int pos, boolean handle) throws Exception;
    public abstract int lessJump(String startState);
}
