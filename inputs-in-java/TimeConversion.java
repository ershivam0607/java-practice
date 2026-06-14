import java.util.*;
public class TimeConversion
{
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int input=0,hr=0,min=0,sec=0,left1=0,left2=0;
            System.out.println("Enter input: ");
            input = sc.nextInt();
            hr = input/3600;
            left1 = input-(hr*3600);
            min = left1/60;
            left2 = left1-(min*60);
            sec = left2;
            System.out.println(hr+" Hours "+min+" minutes "+sec+" seconds ");
            sc.close();
        }  
}