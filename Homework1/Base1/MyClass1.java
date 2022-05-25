package Base1;

public class MyClass1 extends AbsClass {

    @Override
    public long initArr() {
        this.myArr = new int [3][];
        this.myArr[0] = new int [2];
        this.myArr[1] = new int [3];
        this.myArr[2] = new int [4];
        this.myArr[0][0] = 2147483647;
        this.myArr[0][1] = 10;
        for(int i = 0; i < 3; i ++)
        {
            this.myArr[1][i] = 0;
        }
        for(int i = 0; i < 4; i ++)
        {
            this.myArr[2][i] = 0;
        }
        long answer = 0;
        for(int i = 0; i < 2; i ++)
        {
            answer = answer + this.myArr[0][i];
        }
        for(int i = 0; i < 3; i ++)
        {
            answer = answer + this.myArr[1][i];
        }
        for(int i = 0; i < 4; i ++)
        {
            answer = answer + this.myArr[2][i];
        }
        return answer;
    }

    @Override
    public void initNum() {
        this.num = 128;
    }

    @Override
    public void changeValByReference(int arr[], MyClass1 myClass) {
        myClass.pos = arr.length - 1;
        arr[myClass.pos] = -2147483648;
    }
}


