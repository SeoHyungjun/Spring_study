package chapter2;

public class ExplicitConversion {
    public static void main(String[] args) {

        int iNum = 1000;

        // 이 경우 iNum이 더 큰수이므로 byte에 넣을 수 없어서 오류 발생
        // byte bNum = iNum;
        byte bNum = (byte)iNum;

        System.out.println(iNum);
        // bNum의 경우 iNum을 형변환 했는데, byte의 경우 256까지 표현 가능한데,
        // 1000은 들어갈 수 없으므로 일부가 잘려서 첫자리는 1로 들어가고 음수료 출력됨
        System.out.println(bNum);

        double dNum = 3.14;
        // double을 형변환을 통해 int로 변경하면 소수점이 유실된다.
        iNum = (int)dNum;
        System.out.println(iNum);
        float fNum = 0.9F;

        // 이 경우 소수점을 자르고 더하므로 3이 나오고 (3 + 0)
        int num1 = (int)dNum + (int)fNum;
        // 이 경우에는 더한 뒤 소수점을 자르므로 4가 나온다 (3.14 + 0.9 = 4.04)
        int num2 = (int)(dNum + fNum);

        System.out.println(num1);
        System.out.println(num2);
    }
}
