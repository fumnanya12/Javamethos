import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage {
    public static int MONTHS=12;
    public static void main(String[] args) {
        int principal=0;
        principal=(int) ReadNumber("Principle: ($1K-$1M): ",1000,1000000);
        double interest=0;
        interest=ReadNumber("Annual Interest Rate: ",0,30);
         int period =0;
        period=(int) ReadNumber("Period (Years): ",1,30);


        double answer=calculate_mortgage(principal,period,interest);
        NumberFormat currency= NumberFormat.getCurrencyInstance();
        String payment= currency.format(Math.round(answer));
        System.out.println("Mortgage payment is  "+payment);


    }
    public static double ReadNumber(String prompt,double min,double max){
        Scanner scanner=new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextInt();
            if (value >= min && value <= max) {

                break;
            }
            System.out.println("Enter a number between "+ Math.round(min) + " and " + Math.round(max) +".");

        }
        return value;
    }
    public static double  calculate_mortgage(int principal,int period,double interest){
        double Monthly_interest = interest / 100 / MONTHS;
        double rate_plus_one = Math.pow((Monthly_interest + 1), (period * MONTHS));

        double answer;
        answer = principal*(rate_plus_one*Monthly_interest)/(rate_plus_one-1);

        return  answer;
    }


}
