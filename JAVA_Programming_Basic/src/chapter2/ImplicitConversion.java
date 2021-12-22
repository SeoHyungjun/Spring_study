package chapter2;

public class ImplicitConversion {
    public static void main(String[] args) {

        // 더 적은수(덜 정밀한 수)에서 더 큰수(더 정밀한 수)로 형변환은 가능
        // ex) float(덜 정밀한 수)는 4byte인데 double(더 정밀한 수)은 8byte니까 형변환 가능

        byte bNum = 10;
        int num = bNum;

        System.out.println(num);

        long lNum = 10;
        float fNum = lNum;

        System.out.println(fNum);

        double dNum = fNum + num;
        System.out.println(dNum);
    }
}
