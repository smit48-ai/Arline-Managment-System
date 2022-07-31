import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
import java.util.StringTokenizer;

//FLIGHT CLASS FOR FLIGHT DATA
public class Flight {
     String flight_id;
     String source;
     String destination;
     int total_set;
     int booked;
     String date;
     String time;
     String complete;
     String cost;
     String username;
     Scanner sc= new Scanner(System.in);

     void UserName(String un){
         username=un;
     }
     //METHOD FOR BOOKING THE FLIGHT
     void booking(){
        System.out.println();
        System.out.print("\tEnter the ID of the Flight in Which You Want to Travel : ");
        flight_id=sc.next();
        System.out.println("----------------------------------------------------------------");
        try{
            File file2 = new File("flights.txt");
            Scanner sc1 = new Scanner(file2);
            int i=0;
            boolean done=false;
            StringTokenizer st;
            
            boolean check=false;
            while (sc1.hasNextLine()){
                complete=sc1.nextLine();
                st = new StringTokenizer(complete," ");  
                if(st.nextToken().equals(flight_id)){
                    check=true;
                    source=st.nextToken();
                    destination=st.nextToken();
                    total_set=Integer.parseInt(st.nextToken());
                    booked=Integer.parseInt(st.nextToken());

                    //CHECK SEATS ARE PRESENT OR NOT
                    if(total_set==booked){
                        System.out.println("\tSorry!! Flight is Full"); 
                        System.out.println("----------------------------------------------------");
                        System.out.println();
                        break;
                    }
                    else{
                        System.out.print("\tEnter the No of Seats Required : ");
                        int seat_required=sc.nextInt();
                        if(seat_required>total_set-booked){
                            System.out.println("\tSorry !! Required No of Seats are Not Avaliable");
                            System.out.println("-------------------------------------------------------");
                            System.out.println();
                            break;
                        }
                        else{
                            //ADD SEAT_REQUIRED IN BOOKED SHEET
                            booked+=seat_required;
                            done=true;
                            date=st.nextToken();
                            time=st.nextToken();
                            cost=st.nextToken();
                            double cst=Double.parseDouble(cost);
                            System.out.println();
                            System.out.println("\tFlight is Booked For You !! ");
                            System.out.println();
                            System.out.println("---------------------------------------------------------------------");
                            System.out.println("\t|Automatic Generated Bill|");
                            System.out.println("---------------------------------------------------------------------");
                            System.out.println("\tUsername             : "+username);
                            System.out.println("\tTotal Seats Booked   : "+seat_required);
                            System.out.println("\tFlight ID            : "+flight_id);
                            System.out.println("\tFlight               : "+source+" to "+destination);
                            System.out.println("\tDate                 : "+date);
                            System.out.println("\tTime                 : "+time);
                            System.out.println("\tTotal Payable Amount : "+(cst*seat_required));
                            System.out.println("---------------------------------------------------------------------");
                            System.out.println();
                            break;
                        }
                    }
                }
            }

            sc1.close();
            if(!check){
                System.out.println("\tNO FLIGHT exist");
                System.out.println("----------------------------------------------------");
                System.out.println();
            }
            if(done){
                File inputFile = new File("flights.txt");
                File tempFile = new File("flightss.txt");
                    
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
                    
                String lineToRemove = complete;
                String currentLine;
                    
                while((currentLine = reader.readLine()) != null) {
                    if(currentLine.equals(lineToRemove)) continue;
                    writer.write(currentLine);
                    writer.write('\n');
                }

                writer.close();
                reader.close(); 
                inputFile.delete();
                //tempFile.close();
                try {
                    FileWriter fWriter = new FileWriter("flightss.txt",true);
                    //WRITE DATA IN FILE
                    fWriter.write(flight_id);
                    fWriter.write(' ');
                    fWriter.write(source);
                    fWriter.write(' ');
                    fWriter.write(destination);
                    fWriter.write(' ');
                    fWriter.write(String.valueOf(total_set));
                    fWriter.write(' ');
                    fWriter.write(String.valueOf(booked));
                    fWriter.write(' ');
                    fWriter.write(date);
                    fWriter.write(' ');
                    fWriter.write(time);
                    fWriter.write(' ');
                    fWriter.write(cost);
                    fWriter.write('\n');
                    fWriter.close();
                    File file3=new File("flightss.txt");
                    File file4=new File("flights.txt");
                    System.out.println(file3.renameTo(file4));
                    file3.delete();    
                    
                    //file3.close();
                }
                catch (IOException e) {
                    System.out.print(e.getMessage());
                }

            }
        }
        catch (Exception e)  
        {
            e.printStackTrace();
        }        
    }

    //METHOD FOR TICKET CANCELLATION
    void cancellation(){
        System.out.print("\tEnter the ID of the Flight in Which You Want to Cancel : ");
        flight_id=sc.next();
        System.out.println("--------------------------------------------------------------");
        try{
            File files = new File("flights.txt");
            Scanner sc2 = new Scanner(files);     
            boolean done=false;
            StringTokenizer st;

            boolean check=false;;
            while (sc2.hasNextLine()){
                complete=sc2.nextLine();
                st = new StringTokenizer(complete," ");  
                if(st.nextToken().equals(flight_id)){
                    check=true;
                    source=st.nextToken();
                    destination=st.nextToken();
                    total_set=Integer.parseInt(st.nextToken());
                    booked=Integer.parseInt(st.nextToken());
                    //CHECK SHEATS ARE PRESENT OR NOT
                    if(booked==0){
                        System.out.println("\tYou have not Booked any Flight "); 
                        System.out.println("----------------------------------------------------");
                        System.out.println();
                        break;
                    }
                    else{
                        System.out.print("\tEnter the No of Seats to be Cancelled : ");
                        int seat_cancelled=sc.nextInt();
                        if(seat_cancelled>booked){
                            System.out.println("\tSorry !! This Much No of Seats are not Booked by You");
                            System.out.println("---------------------------------------------------------");
                            System.out.println();
                            break;
                        }
                        else{
                            booked-=seat_cancelled;
                            done=true;
                            date=st.nextToken();
                            time=st.nextToken();
                            cost=st.nextToken();
                            System.out.println();
                            double cst=Double.parseDouble(cost);
                            System.out.println();
                            System.out.println("\tFlight is cancelled For You !! ");
                            System.out.println();
                            System.out.println("---------------------------------------------------------------------");
                            System.out.println("\t|Automatic cancellation slip|");
                            System.out.println("---------------------------------------------------------------------");
                            System.out.println("\tUsername                : "+username);
                            System.out.println("\tTotal Seats cancelled   : "+seat_cancelled);
                            System.out.println("\tFlight ID               : "+flight_id);
                            System.out.println("\tFlight                  : "+source+" to "+destination);
                            System.out.println("\tDate                    : "+date);
                            System.out.println("\tTime                    : "+time);
                            System.out.println("\tTotal Refundable Amount : "+(cst*seat_cancelled));
                            System.out.println("---------------------------------------------------------------------");
                            System.out.println();
                            break;
                        
                        }
                    }
                }
            }
            sc2.close();
            if(!check){
                System.out.println("\tNO FLIGHT EXISTS");
                System.out.println("----------------------------------------------------");
                System.out.println();
            }
            if(done){
                //File inputFile1= new File("flights.txt");
                File tempFile1= new File("flightss.txt");
                    
                BufferedReader reader = new BufferedReader(new FileReader(files));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile1));
                    
                String lineToRemove = complete;
                String currentLine;
                    
                while((currentLine = reader.readLine()) != null) {
                    if(currentLine.equals(lineToRemove)) continue;
                    writer.write(currentLine);
                    writer.write("\n");
                }

                writer.close();
                reader.close(); 
                //tempFile.close();
                files.delete();
                try {
                    FileWriter fWriter = new FileWriter("flightss.txt",true);
                        
                    fWriter.write(flight_id);
                    fWriter.write(' ');
                    fWriter.write(source);
                    fWriter.write(' ');
                    fWriter.write(destination);
                    fWriter.write(' ');
                    fWriter.write(String.valueOf(total_set));
                    fWriter.write(' ');
                    fWriter.write(String.valueOf(booked));
                    fWriter.write(' ');
                    fWriter.write(date);    
                    fWriter.write(' '); 
                    fWriter.write(time); 
                    fWriter.write(' '); 
                    fWriter.write(cost);
                    fWriter.write('\n');
                    fWriter.close();
                    File file5=new File("flightss.txt");
                    File file6=new File("flights.txt");  
                    file5.renameTo(file6); 
                    file5.delete();
                    //file3.close();
                }
                catch (IOException e) {
                    System.out.print(e.getMessage());
                }
            }
        }
        catch (Exception e)  
        {
            e.printStackTrace();
        }        
    }

    //METHOD FOR DISPLAY DATA
    void display(){
        try{
            System.out.println();
            File file= new File("flights.txt");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.print("FlightID");
            String str="FlightID";
            int len=str.length();
            for(int i=0; i<22-len; i++){
                System.out.print(" "); 
            }
            System.out.print("Source");
            str="Source";
            len=str.length();
            for(int i=0; i<22-len; i++){
                System.out.print(" "); 
            }
            System.out.print("Destination");
            str="Destination";
            len=str.length();
            for(int i=0; i<22-len; i++){
                System.out.print(" "); 
            }
            System.out.print("Total Seats");
            str="Total Seats";
            len=str.length();
            for(int i=0; i<22-len; i++){
                System.out.print(" "); 
            }
            System.out.print("Booked Seats");
            str="Booked Seats";
            len=str.length();
            for(int i=0; i<22-len; i++){
                System.out.print(" "); 
            }
            System.out.print("Date");
            str="Date";
            len=str.length();
            for(int i=0; i<22-len; i++){
                System.out.print(" "); 
            }
            System.out.print("Time");
            str="Time";
            len=str.length();
            for(int i=0; i<22-len; i++){
                System.out.print(" "); 
            }
            System.out.print("Cost");
            str="Cost";
            len=str.length();
            for(int i=0; i<22-len; i++){
                System.out.print(" "); 
            }
             System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            Scanner sc5 = new Scanner(file);
            int ct=0;
            while (sc5.hasNext()){
                if(ct%8==0){
                    System.out.println(" "); 
                    ct++;
                }
                else{
                    ct++;
                }
                String temp=sc5.next();
                int length=temp.length();
                System.out.print(temp);
                for(int i=0; i<22-length; i++){
                    System.out.print(" "); 
                }
            }
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
        }
        catch (Exception e)  
        {
        e.printStackTrace();
        }  
    }
    
    //METHOD FOR ADD_FLIGHT DETAILS
    void add_flight(){
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println("\tEnter the Following Details of the Flight : ");
        System.out.println("----------------------------------------------------");
        System.out.print("\tFlight ID : ");
        flight_id=sc.next();
        System.out.print("\tSource : ");
        source=sc.next();
        System.out.print("\tDestination : ");
        destination=sc.next();
        System.out.print("\tTotal Seats : ");
        total_set=sc.nextInt();
        booked=0;
        System.out.print("\tDate : ");
        date=sc.next();
        System.out.print("\tTime : ");
        time=sc.next();
        System.out.print("\tCost : ");
        cost=sc.next();
        System.out.println("----------------------------------------------------");
        System.out.println();
        try {
            //WRITE FLIGHT DATA IN FILE
            FileWriter fWriter = new FileWriter("flights.txt",true);
            fWriter.write(flight_id);
            fWriter.write(' ');
            fWriter.write(source);
            fWriter.write(' ');
            fWriter.write(destination);
            fWriter.write(' ');
            fWriter.write(String.valueOf(total_set));
            fWriter.write(' ');
            fWriter.write(String.valueOf(booked));
            fWriter.write(' ');
            fWriter.write(date);
            fWriter.write(' ');
            fWriter.write(time);
            fWriter.write(' ');
            fWriter.write(cost);
            fWriter.write('\n');
            fWriter.close(); 
        }
        catch (IOException e) {
                System.out.print(e.getMessage());
        }
    }

    //METHOD FOR DELETE FLIGHT
    void delete_flight(){
        System.out.println();
        System.out.print("\tEnter the ID of the Flight in Whih You Want to Cancel : ");
        flight_id=sc.next();
        try{
            
            File filee = new File("flights.txt");
            Scanner sc3 = new Scanner(filee);

            boolean done=false;
            StringTokenizer st;
          
            while (sc3.hasNextLine()){
                   complete=sc3.nextLine();
                    st = new StringTokenizer(complete," ");  
                    if(st.nextToken().equals(flight_id)){
                        done=true;
                        break;
                    }
                }
                
            sc3.close();
            if(done){
                File inputFile2 = new File("flights.txt");
                File tempFile2 = new File("flightss.txt");                 
                BufferedReader reader = new BufferedReader(new FileReader(inputFile2));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile2));
                
                String lineToRemove = complete;
                String currentLine;
                
                while((currentLine = reader.readLine()) != null) {
                    if(currentLine.equals(lineToRemove)) continue;
                    writer.write(currentLine);
                    writer.write("\n");
                }

                writer.close();
                reader.close(); 
                inputFile2.delete();
                File file7=new File("flightss.txt");
                File file8=new File("flights.txt");  
                file7.renameTo(file8); 
                file7.delete();
                System.out.println("\tThis ID's Flight is Deleted");
                System.out.println("-------------------------------------------------------------------");
                System.out.println();
            }
            else{
                System.out.println("\tNo Such Flight Exist!!");
                System.out.println("----------------------------------------------------");
                System.out.println();
            }
        }
        catch (Exception e)  
        {
            e.printStackTrace();
        }   
    } 
}
