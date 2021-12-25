package chapter3;

public class OperationEx {
    public static void main(String[] args) {

        // 대입연산자의 우선순위는 제일 낮다
        int age = 24;
        System.out.println(age);

        int num = 10;
        int num2 = -num;
        System.out.println(num);
        System.out.println(num2);

        // num의 값을 바꾸고 싶으면 대입연산자를 써서 바꿔야함
        num = -num;
        System.out.println(num);
    }
}
