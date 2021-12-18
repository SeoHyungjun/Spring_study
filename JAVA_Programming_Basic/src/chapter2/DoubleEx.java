package chapter2;

public class DoubleEx {

    public static void main(String[] args) {
        double dNum = 3.14;
        // java에서는 기본적으로 소수는 double형으로 사용되는데,
        // float형으로 사용하려면 뒤에 식벽자 F 또는 f를 넣어줘야한다.
        float fNum = 3.14F;

        // java10 이상 버전 부터는 변수형 추론이 가능
        // var num = 10;을 사용한다면 num은 int형으로 저장된다.
        // 그러나 그 뒤에 num = 3.14를 넣으려한다면, 처음 정해진 변수형이 아니므로 불가능
    }
}
