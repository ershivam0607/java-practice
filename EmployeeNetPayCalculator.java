/*     Question:
                Take input of Basic Pay from the user and calculate and display Gross Pay and Net Pay
                Dearness Allowance = 30% of Basic Pay.
                House Rent Allowance = 15% of Basic Pay.
                Provident Fund = 12.5% of Basic Pay.
                Gross Pay = Basic Pay + Dearness Allowance + House Rent Allowance
                Net Pay = Gross Pay - Provident Fund */
import java.util.Scanner;
public class EmployeeNetPayCalculator
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        double basicPay=0.0,dearnessAllowance=0.0,houseRentAllowance=0.0,providentFund=0.0,grossPay=0.0,netPay=0.0;
        System.out.println("Enter Basic pay of Employee:");
        basicPay = sc.nextDouble();
        dearnessAllowance =  (30*basicPay)/100;
        houseRentAllowance =  (15*basicPay)/100;
        providentFund =  (12.5*basicPay)/100;
        grossPay = basicPay+dearnessAllowance+houseRentAllowance;
        netPay = grossPay-providentFund;
        System.out.println("The gross pay of the employee is: "+grossPay);
        System.out.println("The net pay of the employee is: "+netPay);
        sc.close();
    }    
}
