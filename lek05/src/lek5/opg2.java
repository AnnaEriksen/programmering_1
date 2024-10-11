package lek5;

public class opg2 {
    public static void main(String[] args) {
        int tal = 222 ;
        int sum = 0;
        int tal1 = 32677 ;
        int sum1 = 0;

        sum = sumOfNum(tal);
        System.out.println("sumOfNum er: " + sum);

        sum1 = sumofOddNum(tal1);
        System.out.println("sumOfOddNum er: " + sum1);
    }

    public static int sumOfNum(int n){
        int tal = n;
        int rest = 0;
        int sum = 0;
        while (tal > 0) {
            System.out.println("før summering af " + tal);
            rest = tal % 10;
            tal = tal / 10;

            sum = sum + rest;
            System.out.println("Efter suummering af " + tal);
        }
        return sum;
    }

    public static int sumofOddNum(int n) {
        int tal = n;
        int rest = 0;
        int sum = 0;
        while (tal > 0) {
            System.out.println("Tal of sumofOddNum før summering " + tal);
            rest = tal % 10;
            tal = tal / 10;

            //hvis rest & 2 == 1, så er rest er ulige tal
            System.out.println(" rest er: " + rest + " tal er: " + tal + "sum er: " + sum );
            if (rest % 2 == 1) {
                sum = sum + rest;
            }
        }
        System.out.println("Sum of sumofOddNum efter suummering af " + sum);
        return sum;
    }
}
