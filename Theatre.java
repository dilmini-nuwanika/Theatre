import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

public class Theatre{
    private static ArrayList<Ticket> tickets = new ArrayList<Ticket>();
    private static int[] row1 = new int[12];
    private static int[] row2 = new int[16];
    private static int[] row3 = new int[20];
    private static Scanner scanner = new Scanner(System.in);
    static int[][] seats = new int[3][];
    static final int[] rowSeats = {12, 16, 20};
    public static void main(String[]args){
        for (int i = 0; i < seats.length; i++) {
            seats[i] = new int[rowSeats[i]];
        }

        System.out.println("Welcome to the New Theatre!");// to show 0011 at the begin of the progrm no issues here
        for (int ii = 0; ii < row1.length; ii++) {
            System.out.print(row1[ii] + " ");
        }
        System.out.println();
        for (int ii = 0; ii < row2.length; ii++) {
            System.out.print(row2[ii] + " ");
        }
        System.out.println();
        for (int ii = 0; ii < row3.length; ii++) {
            System.out.print(row3[ii] + " ");
        }//end of for
        //print menu and get user input option
        int option=-1;
        while (option!=0){
            System.out.println(" ");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("\nPlease select an option: ");
            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort tickets by price");
            System.out.println("0) Quit");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("Enter option: ");
            Scanner input = new Scanner(System.in);
            option= input.nextInt();
            switch (option) {
                case 1:
                    buy_ticket();
                    break;
                case 2:
                    print_seating_area();
                    break;
                case 3:
                    cancelTicket();
                    break;
                case 4:
                    show_available();
                    break;
                case 5:
                    save();
                    break;
                case 6:
                    load();
                    break;
                case 7:
                    printTicketInfo();
                    break;
                case 8:
                    sortTickets();
                    break;
                case 0:
                    System.out.println("Thank you for using our Theatre booking system!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }//end of while

    }//end of main
    //creating buy method
    public static void buy_ticket() {
        System.out.print("Enter person name: ");
        String name = scanner.nextLine();
        System.out.print("Enter person surname: ");
        String surname = scanner.nextLine();
        System.out.print("Enter person email: ");
        String email = scanner.nextLine();
        Person person = new Person(name, surname, email);
        System.out.println("Enter row number (1-3):");
        Scanner input = new Scanner(System.in);
        int row = input.nextInt();
        if (row < 1 || row > 3 ) {
            System.out.println("Invalid row. Please try again.");
            return;
        }
        System.out.println("Enter seat number (1-" + rowSeats[row - 1] + "): ");
        int seat = input.nextInt();
        if (seat < 1 || seat > rowSeats[row - 1]  ) {
            System.out.println("Invalid seat. Please try again.");
            return;
            }
        ArrayList<Ticket> tickets = new ArrayList<>();
       // public Scanner scanner = new Scanner(System.in);
        Ticket ticket = new Ticket(row, seat, person);
        tickets.add(ticket);
        //my to print seat x o
        if (row == 1) {
            if (row1[seat - 1] != 1) {
                row1[seat - 1] = 1;
                System.out.println("Seat Reserved!");
            } else {
                System.out.println("Seat Unavailable!");

            }
            //break;
            //end of if for r1
        } else if (row == 2) {
            if (row2[seat - 1] != 1) {
                row2[seat - 1] = 1;
                System.out.println("Seat Reserved!");
            } else {
                System.out.println("Seat Unavailable!");

            }
        } else if (row == 3) {
            if (row3[seat - 1] != 1) {
                row3[seat - 1] = 1;
                System.out.println("Seat Reserved!");
            } else {
                System.out.println("Seat Unavailable!");

            }//end of else r3
        }//end of elif r3

    }//end of buy method
    // creating print seat method
    public static void print_seating_area(){// print seat
        System.out.println("                ***********                ");
        System.out.println("                *  STAGE  *                ");
        System.out.println("                ***********                ");
        for (int i = 0; i < row1.length; i++) {
            if (i == 6) {
                System.out.print("  ");
            }
            String result = (row1[i] == 1) ? "X" : "O";
            System.out.print(result);
        }
        System.out.println();
        for (int i = 0; i < row2.length; i++) {
            if (i == 8) {
                System.out.print("  ");
            }
            String result = (row2[i] == 1) ? "X" : "O";
            System.out.print(result);
        }
        System.out.println();
        for (int i = 0; i < row3.length; i++) {
            if (i == 10) {
                System.out.print("  ");
            }
            String result = (row3[i] == 1) ? "X" : "O";
            System.out.print(result);
        }

    }//end of seat method
    //create cancel method
    public static void cancelTicket() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter person name: ");
        String name=scanner.next();

        System.out.println("Enter person surname: ");
        String surname=scanner.next();

        System.out.println("Enter person email: ");
        String email=scanner.next();

        System.out.print("Enter row number to cancel: ");
        int row = input.nextInt();
        if (row < 1 || row > 3 ) {
            System.out.println("Invalid row. Please try again.");
            return;
        }

        System.out.print("Enter seat number to cancel: ");
        int seat = input.nextInt();
        if (seat < 1 || seat > rowSeats[row - 1] ) {

            System.out.println("Invalid seat. Please try again.");
            return;
        }
        if (row==1) {
            if (row1[seat - 1] == 0) {

                System.out.println("Seat already available!");
                return;
            } else {
                row1[seat - 1] = 0;
                System.out.println("Ticket canceled successfully");
            }
        }
        else if (row == 2) {
                if (row2[seat - 1] == 0) {
                    System.out.println("Seat already available!");
                    return;
                } else {
                    row2[seat - 1] = 0;
                    System.out.println("Ticket canceled successfully");
                }
        }
        else if (row == 3) {
                if (row3[seat - 1] == 0) {
                    System.out.println("Seat already available!");
                    return;
                } else {
                    row3[seat - 1] = 0;
                    System.out.println("Ticket canceled successfully");
                }
            }//end of elseif r3

    }//end of cancel ticket method
    //create show available method
    public static void show_available(){

        System.out.print("Seats available in row 1: ");
        for(int i=1;i<=row1.length;i++) {
            if(row1[i-1]==0){
            System.out.print(i);
            }
            if (i != row1.length) {
                System.out.print(",");
            } else {
                System.out.print(".");
            }
        }
        System.out.println(" ");

        System.out.print("Seats available in row 2: ");
        for(int i=1;i<=row2.length;i++) {
            if(row2[i-1]==0){
            System.out.print(i);

            }
            if (i != row2.length) {
                System.out.print(",");
            } else {
                System.out.print(".");
            }
        }
        System.out.println(" ");

        System.out.print("Seats available in row 3: ");
        for(int i=1;i<=row3.length;i++) {
            if(row3[i-1]==0){
            System.out.print(i);
            }
            if (i != row3.length) {
                System.out.print(",");
            } else {
                System.out.print(".");
            }
        }
    } //end of method show available
    //creating save method
    public static void save(){
        try {
            FileWriter writer = new FileWriter("data.txt");
            writer.write("This is what I want to write into the file !");
            //writer.close();//close the connection between the code and the external file
            for (int i = 0; i < row1.length; i++) {
                if (row1[i] != -1) {
                    // Combine row data into a string separated by commas
                    String row = row1[i] + "," + row2[i] + "," + row3[i];
                    writer.write(row + "\n"); // Write the row to the file
                }

            }
           writer.close(); // Close the file writer
            System.out.println("Data saved to " + "data.txt");
        } catch (IOException ex) {
            System.out.println("An error occurred while saving data to file: " + ex);
        }   // end of catch

    }  //end of save method
    //create load method
    public static void load(){
        //String fileName = "data.txt";
            try {
                File file = new File("data.txt");
                boolean file_created = file.createNewFile();
                Scanner scanner = new Scanner(file);
                if (file_created){
                    System.out.println("File created:"+ file.getName());

                }
                else if (file.exists()){
                    System.out.println("File already exists.");
                }

            } catch (IOException e) {
                System.out.println("An error occurred while loading the data: " + e.getMessage());
            }//end of catch

    }  //end of load method
    //create show ticket info method
    public static void printTicketInfo(){

        System.out.println("Ticket information:");


        // Print out the ticket information
        /*System.out.println("Person name: " + person.getName());
        System.out.println("Person surname: " + person.getSurname());
        System.out.println("Person email: " + person.getEmail());
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: " + price);*/
    }//end print ticket info
    //create sort ticket method
    public static void sortTickets(){

        System.out.println("Sorting!");

    }//end of sort

} //end of class theatre


