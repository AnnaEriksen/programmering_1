package udleveret_if;

public class MetoderEksempel {
    public static void main(String[] args) {
        System.out.println("Max af 34 og 56: "+ max(34,56));
        System.out.println("Max af 9 og 4: "+ max(9,4));
        System.out.println("Max af 123 og 111: "+ max(123,111));


        System.out.println("sum af 234: " + sumDigits(234));
        System.out.println("sum af 123: " + sumDigits(123));
        System.out.println("sum af 555: " + sumDigits(555));
        System.out.println("sum af 23: " + sumDigits(23));
        System.out.println("sum af 2: " + sumDigits(2));


    }

    public static int max(int num1, int num2) {
        int result;
        if (num1 > num2) {
            result = num1;
        } else {
            result = num2;
        }
        return result;
    }

    public static int sumDigits(int tal) {
        int digit1 = tal % 10;
        tal = tal / 10;

        int digit2 = tal % 10;
        tal = tal / 10;

        int digit3 = tal % 10;

        return digit1 + digit2 + digit3;
    }
}
