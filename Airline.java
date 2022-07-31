import java.io.FileNotFoundException;
import java.util.Scanner;
//MAIN CLASS
public class Airline {
    public static void main(String[] args){
        boolean ok=true;
        while(ok){
            System.out.println();
            System.out.println();
            System.out.println("----------------------------------------------------");
            System.out.println("\tWelcome to NDS Airlines");
            System.out.println("----------------------------------------------------");
            System.out.println("----------------------------------------------------");
            System.out.println("\tchoose what you want to do??");
            System.out.println("\t 1 For Login if you have a Account");
            System.out.println("\t 2 For Sign In if you Do not have a Account");
            System.out.println("\t 3 For About Us");
            System.out.println("\t 0 For Exit");
            System.out.println("----------------------------------------------------");
            int choice;
            System.out.print("\tEnter Your Choice : ");
            Scanner sc=new Scanner(System.in);
            choice=sc.nextInt();
            System.out.println();
            switch (choice) {
                //FOR LOGIN
                case 1: 
                    System.out.println("----------------------------------------------------");
                    System.out.println("\tHow do you Want to Login ??");
                    System.out.println("----------------------------------------------------");
                    System.out.println("\t1 For as a User");
                    System.out.println("\t2 For as a Admin");
                    System.out.println("----------------------------------------------------");
                    System.out.print("\tEnter Your Choice : ");
                    int choice2=sc.nextInt();
                    System.out.println();
                    if(choice2==1){
                        Customer new_user=new Customer(); 
                        new_user.login(); 
                    }
                    else{
                        admin new_user=new admin(); 
                        new_user.login(); 
                    }
                break;

            case 2:
            //FOR SIGN IN
                System.out.println();
                System.out.println("----------------------------------------------------");
                System.out.println("\tHow do you Want to Login ??");
                System.out.println("----------------------------------------------------");
                System.out.println("\t1 For as a User");
                System.out.println("\t2 For as a Admin");
                System.out.println("----------------------------------------------------");
                System.out.print("\tEnter Your Choice : ");
                int choice3=sc.nextInt();
                System.out.println();
                if(choice3==1){
                    Customer new_user=new Customer(); 
                    new_user.signin(); 
                }
                else{
                    admin new_user=new admin(); 
                    new_user.signin(); 
                }
                break;

            case 0:
            //END THE PROGRAM
               ok=false;
               break;

            case 3:
            //FOR ABOUT US
               System.out.println();
               System.out.println("----------------------------------------------");
               System.out.println("\t|DEVELOPERS OF THE SOFTWARE |");
               System.out.println("----------------------------------------------");
               System.out.println("\t|SMIT PRAJAPATI --> 20BCE233|");
               System.out.println("\t|DURGESH NINAVE --> 20BCE173|");
               System.out.println("\t|NISARG SHAH    --> 20BCE175|");
               System.out.println("----------------------------------------------");
               System.out.println();
               System.out.println();
            }
        }
    }
}
