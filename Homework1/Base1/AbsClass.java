package Base1;

public abstract class AbsClass {
    public int myArr[][];
    public int num;
    public int pos = 6;

    public abstract long initArr();
    public abstract void initNum();
    public abstract void changeValByReference(int arr[], MyClass1 myClass);
}
