import java.util.Scanner;
import java.io.*;
//CUSTOMER CLASS FOR CUSTOMER DATA
public class Customer {
    protected String username;
    String password;
    long phone_no;
    String name;
    Scanner sc=new Scanner(System.in);
    
    //METHOD FOR SIGN IN
    void inputfor_sigin(){
        System.out.println();
        System.out.println("----------------------------------------------------");
        //GET NAME, PHONE NUMBER, USERNAME, PASSWORD
        System.out.print("\tName : ");   
        name=sc.nextLine();

        System.out.print("\tPhone_No : ");   
        phone_no=sc.nextLong();

        System.out.print("\tUsername : ");  
        sc.nextLine(); 
        username=sc.nextLine();
       
        System.out.print("\tPassword : "); 
        password=sc.nextLine();
        System.out.println("----------------------------------------------------");
        System.out.println();
    }  
    
    //METHOD FOR WRITE SIGN IN DATA IN FILE
    void signin(){
        inputfor_sigin();
        try {
            //USE FWRITER FOR WRITE IN THE FILE
            FileWriter fWriter = new FileWriter("userdetails.txt",true);
            fWriter.write('\n');
            fWriter.write(username);
            fWriter.write(' ');
            fWriter.write(password);
            System.out.println("\tYour Account is Created Now !!");
            fWriter.close();
            System.out.println("----------------------------------------------------");
            System.out.println();
            fWriter.close();
        }
        catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }

    //METHOD FOR PROCESS AFTER LOGIN
    void afterlogin(){
        boolean ok=true;
        Flight new_flight=new Flight();
        while(ok){
            System.out.println();
            System.out.println("----------------------------------------------------");
            System.out.println("\tChoose What You Want to Do ???");
            System.out.println("----------------------------------------------------");
            System.out.println("\t1 For Booking the Ticket");
            System.out.println("\t2 For Checking the Details of Flights");
            System.out.println("\t3 For Canceling the Ticket");
            System.out.println("\t0 For Exit");
            System.out.println("----------------------------------------------------");
            System.out.print("\tEnter Your Choice : ");
            int choice=sc.nextInt();
            switch (choice) {
                case 1:
                //FOR BOOK NEW FLIGHT
                   
                    new_flight.UserName(username);
                    new_flight.booking();
                    break;

                case 2:
                //FOR DISPLAY FLIGHTS
             
                    new_flight.display();
                    break;

                case 3:
                //FOR CANCEL FLIGHTS
                   
                    new_flight.UserName(username);
                    new_flight.cancellation();
                    break;

                case 0:
                //EXIT 
                   ok=false;
                   break;

                default:
                    break;
            }
        }
    }

    //METHOD FOR LOG IN
    void inputfor_login(){
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.print("\tEnter the Username : ");
        username=sc.nextLine();
        System.out.print("\tEnter the Password : ");
        password=sc.nextLine();
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.println();
    }

    //METHOD FOR WRITE LOG IN DATA IN FILE
    void login(){
        inputfor_login();
        try{
        File file = new File("userdetails.txt");
        Scanner sc1 = new Scanner(file);
        int i=0;
        boolean check=false;
        while (sc1.hasNext()){
            //FOR CHECK DATA PRESENT IN THE FILE OR NOT
                if((sc1.next()).equals(username)){  
                    check=true;
                    if(sc1.next().equals(password)){
                           System.out.println("\tYou are Logged in NOW !!");
                           System.out.println("----------------------------------------------------");

                           afterlogin();
                           break;
                     }
                    else{
                        //IF PASSWORD IS WRONG
                        System.out.println("\tYour Password is Wrong !!!");
                        System.out.println("----------------------------------------------------");
                    }
                 }
            }
            if(!check){
                        System.out.println("\tusername does not exist !!!");
                        System.out.println("----------------------------------------------------");
            }
            sc1.close(); 
         }
         catch (Exception e)  
         {
             e.printStackTrace();
         }   
             
    }
}

//INHERIT ADMIN CLASS 
class admin extends Customer{

    //METHOD FOR SIGN IN
    void signin(){
        //OVERRIDE INPUTFOR_SIGNIN() METHOD
       super.inputfor_sigin();
       try {
            FileWriter fWriter = new FileWriter("admindetails.txt",true);
            fWriter.write(username);
            fWriter.write(' ');
            fWriter.write(password);
            fWriter.write('\n');
            System.out.println("\tYour Acount is Created as Admin Now !!");
            System.out.println("----------------------------------------------------");
            fWriter.close();
        }
        catch (IOException e) {
            System.out.print(e.getMessage());
        }
    } 

    //METHOD FOR PROCESS AFTER LOGIN
    void afterlogin(){
        boolean ok=true;
        Flight new_flight1=new Flight();
        while(ok){
            System.out.println();
            System.out.println("----------------------------------------------------");
            System.out.println("\tChoose What You Want to Do???");
            System.out.println("----------------------------------------------------");
            System.out.println("\t1 For Adding the Flight Details");
            System.out.println("\t2 For Deleting the Flight Details");
            System.out.println("\t3 For checking the Flight Details");
            System.out.println("\t0 For exit");
            System.out.println("----------------------------------------------------");
            System.out.print("\tEnter Your Choice : ");
            int choice=sc.nextInt();
            switch (choice) {
                case 1:
                //FOR ADD NEW FLIGHT
                    
                    new_flight1.add_flight();
                    break;

                case 2:
                //FOR DELETE FLIGHT
                    
                    new_flight1.delete_flight();
                    break;

                case 3:
                   
                   new_flight1.display();
                   break;

                case 0:
                //EXIT
                   ok=false;
                   break;
                   
                default:
                    break;
            } 
            System.out.println();
        } 

    }  

    //METHOD FOR LOGIN
    void login(){
        //OVERRIDE METHOD 
         super.inputfor_login();
         try{
            File file = new File("admindetails.txt");
            Scanner sc1 = new Scanner(file);
            int i=0;
            boolean check=false;
            while (sc1.hasNext()){
                //CHECK DATA PRESENT OR NOT
                  
                    if((sc1.next()).equals(username)){  
                        check=true;
                        if(sc1.next().equals(password)){
                               System.out.println("\tYou are Logged in NOW !!");
                                System.out.println("----------------------------------------------------");
                               afterlogin();
                               break;
                             }
                        else{
                            System.out.println("\tYour password is Wrong !!!");
                            System.out.println("----------------------------------------------------");
                        }
                    }
                }
                if(!check){
                    System.out.println("\tusername does not exist !!!");
                        System.out.println("----------------------------------------------------");
                }
                sc1.close();
            }
        catch (Exception e)  
        {
            e.printStackTrace();
        }        
    }
}

