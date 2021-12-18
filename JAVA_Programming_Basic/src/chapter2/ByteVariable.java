package chapter2;

public class ByteVariable {
    public static void main(String[] args) {
        byte bData = -128;
        System.out.println(bData);

        // byte는 127까지 표현가능한데, 128을 넣으면 에러 발생
        //byte bData2 = 128;
        byte bData2 = 127;
        System.out.println(bData2);
    }
}
