package chapter2;

public class VariableEx2 {

    public static void main(String[] args) {

        // num과 level은 모두 int 형으로 안의 값과 상관없이 4byte로 저장된다.
        int num = 10;
        int level = 50;

        // java에서 숫자는 모두 int형으로 보기때문에 Long형은 따로 명시해야 함
        // 1234567890은 int로 저장 불가능하므로, 맨 뒤에 L 또는 l을 추가하여 Long인것을 알려준다
        long longNum = 12345678900L;
    }
}
