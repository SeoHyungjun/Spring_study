package chapter3;

public class OperationEx3 {
    public static void main(String[] args) {

        int num1 = 10;
        int i = 2;

        // && (논리 곱)의 경우 앞의 항이 false면 뒤에 항을 실행 안하므로 i의 값이 변하지 않음
        // || (논리 합)의 경우 앞의 항이 true면 뒤에 항을 실행하지 않음
        boolean value = (((num1 = num1 + 10) < 10) && ((i = i+2) > 10));

        System.out.println(value);
        System.out.println(num1);
        System.out.println(i);
    }
}
