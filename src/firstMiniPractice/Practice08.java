package firstMiniPractice;

import java.util.Scanner;

public class Practice08 {

    public static void main(String[] args) {

        /*
            서채영
            연소득 과세 금액 계산 프로그램
         */
        Scanner sc = new Scanner(System.in);
        TaxCalculation start = new TaxCalculation();

        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해주세요.:");
        TaxCalculation.userIncome = Double.parseDouble(sc.nextLine());

        start.generalCalculation(TaxCalculation.userIncome);
        start.deductCalculation(TaxCalculation.userIncome);
    }
}

class TaxCalculation {

    public static double userIncome = 0; //유저의 연간소득
    double userTax = 0; //세금에 따른 세율값을 곱한 값
    double taxResult = 0; //최종세금(userTax를 각각 더한 최종)
    public static final double [] taxBase = {0, 12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000};
                    // 과세 표준
                    /*

                     */
    public static double[] taxMinus = {12000000, 34000000, 42000000, 62000000, 150000000,200000000,500000000,1000000000};
                        // 표준 구간에 따른
    public static double[] taxRate = {0.06, 0.15, 0.24, 0.35, 0.38, 0.40, 0.42, 0.45}; // 세율
    public static double[] taxDeduction = {0, 1080000, 5220000, 14900000, 19400000, 25400000, 35400000, 65400000};


    public void generalCalculation(double userIncome) {


        for (int i = 0; i < taxBase.length; i++) {

            if( taxBase[i] < userIncome && userIncome <= taxBase[i+1]) { // 반복문이라 계속 돌아감, 범위 만족하면

                for (int j = 0; j < i; j++) {
                    userTax = taxMinus[j] * taxRate[j]; // 빼는 값 x 세율 = 유저세금
                    System.out.printf("%10.0f * %3.0f%% = %10.0f\n", taxMinus[j], taxRate[j] * 100, userTax);
                    userIncome -= taxMinus[j]; // 소득에서 minus값 빼줌
                    taxResult += userTax;
                }
                userTax = taxRate[i] * userIncome; //
                System.out.printf("%10.0f * %3.0f%% = %10.0f\n",  userIncome, taxRate[i] * 100, userTax);
                taxResult += userTax;
            }
        }
        System.out.println();
        System.out.printf("[세율에 의한 세금]:\t%18.0f\n", taxResult);
    }

    public void deductCalculation(double userIncome) {
        int deductIndex = 0;

        if (userIncome <= taxBase[1]) {
            deductIndex = 0;
        } else if (userIncome <= taxBase[2]) {
            deductIndex = 1;
        } else if (userIncome <= taxBase[3]) {
            deductIndex = 2;
        } else if (userIncome <= taxBase[4]) {
            deductIndex = 3;
        } else if (userIncome <= taxBase[5]) {
            deductIndex = 4;
        } else if (userIncome <= taxBase[6]) {
            deductIndex = 5;
        } else if (userIncome <= taxBase[7]) {
            deductIndex = 6;
        } else {
            deductIndex = 7;
        }

            taxResult = userIncome * taxRate[deductIndex] - taxDeduction[deductIndex];

            System.out.printf("[누진공제 계산에 의한 세금]:\t%10.0f\n", taxResult);

    }
}