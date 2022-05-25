package Base1;

public class Test1 {
    private MyClass1 myClass;

    public Test1(MyClass1 myClass) {
        this.myClass = myClass;
    }

    private boolean checkNum() {
        myClass.initNum();
        byte bNum = (byte)myClass.num;
        short sNum = (short)myClass.num;
        long lNum = myClass.num;
        return sNum == lNum && bNum != lNum && (bNum + lNum == 0);
    }

    private boolean checkArr() {
        long total = myClass.initArr();
        int myArr[][] = myClass.myArr;
        if (myArr.length != 3 || myArr[0].length != 2 || myArr[1].length != 3 || myArr[2].length != 4)
            return false;
        long checkTotal = 0;
        int falseTotal = 0;
        for (int subArr[] : myClass.myArr)
            for (int myNum : subArr) {
                checkTotal += myNum;
                falseTotal += myNum;
            }
        return checkTotal == total && checkTotal != falseTotal;
    }

    private boolean checkReference() {
        int arr[] = new int[myClass.pos - 1];
        myClass.changeValByReference(arr, myClass);
        int superNum = arr[myClass.pos];
        int shiftNum1 = superNum >> 1;
        int shiftNum2 = superNum >>> 1;
        return superNum < 0 && (shiftNum1 + shiftNum2 == 0);
    }

    public int getScore() {
        int score = 0;
        boolean isArrCorrect, isNumCorrect, isReferenceCorrect;

        try {
            isArrCorrect = checkArr();
        } catch (Exception e) {
            isArrCorrect = false;
        }
        score += isArrCorrect ? 30 : 0;

        try {
            isNumCorrect = checkNum();
        } catch (Exception e) {
            isNumCorrect = false;
        }
        score += isNumCorrect ? 30 : 0;
        try {
            isReferenceCorrect = checkReference();
        } catch (Exception e) {
            isReferenceCorrect = false;
        }
        score += isReferenceCorrect ? 40 : 0;
        return score;
    }
}
