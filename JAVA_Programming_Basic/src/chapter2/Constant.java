package chapter2;

public class Constant {
    public static void main(String[] args) {
        final int MAX_NUM = 100;
        final float PI = 3.14F;

        // PI는 상수(final)로 선언되어 중간에 변경 불가능
        // PI = 3.15;

        // 상수를 사용하는 이유는 아래와 같이 STUDENT_NUM을 사용할 경우 STUDENT_NUM의 선언된 값만 변경하면 전체에 적용
        // 그러나 아래와 같이 30으로 사용하면 모든 값을 하나하나 변경해야 함
        final int STUDENT_NUM = 30;
        int num = 0;
        if ( num == STUDENT_NUM ) {
            System.out.println(STUDENT_NUM);
        }
        if (num == 30) {
            System.out.println(30);
        }
    }
}
