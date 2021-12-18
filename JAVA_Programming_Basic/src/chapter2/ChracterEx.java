package chapter2;

public class ChracterEx {

    public static void main(String[] args) {
        // 내부적으로 저장된 값은 2진수 이므로 출력하는 타입에 따라서 값이 달라진다.
        // 예를 들면 char 'A'는 아스키코드로 65이므로, 그것을 int형으로 바꿔서 출력하면 65가 나온다.

        char ch = 'A';

        System.out.println(ch);
        System.out.println((int)ch);

        ch = 66;

        System.out.println(ch);

        int ch2 = 67;
        System.out.println(ch2);
        System.out.println((char)ch2);
    }
}
