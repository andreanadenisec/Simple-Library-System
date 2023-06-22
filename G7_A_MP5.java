/*Cadelina, Andreana Denise - 1,3,9
  Paguirigan, John Nicholas - 7, 8
  Payuyo, Ericka Fiona - 2, 4
  2IT-A */
import java.io.*;
import java.util.*;

public class G7_A_MP5 
{
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        G7_A_MP5Methods file = new G7_A_MP5Methods();
        int choice;
        
        do
        {
            System.out.println("\nA Simple Library System");
            System.out.println("\n[1] Add a Student");
            System.out.println("[2] Add a Book");
            System.out.println("[3] Display All Students");
            System.out.println("[4] Display All Books");
            System.out.println("[7] Borrow a Book");
            System.out.println("[8] Display Borrowed Books");
            System.out.println("[9] Return a Book");
            System.out.println("[10] Exit");
            System.out.print("\nEnter your choice: ");
            choice = in.nextInt();
            
            switch(choice)
            {
                case 1:
                    file.studentId();
                    file.studentSurname();
                    file.studentFirstname();
                    file.studentAge();
                    file.studentSex();
                    file.addtoStudentsRecord();
                    break;
                    
                case 2: 
                    file.bookId();
                    file.bookTitle();
                    file.authorName();
                    file.dateofPurchase();
                    file.bookStatus();
                    file.addtoBookRecord();
                    break;
                
                case 3:
                    file.displayStudentRecord();
                    break;
                    
                case 4:
                    file.displayBookRecord();
                    break;
                    
                case 7:
                    file.listofBooks();
                    break;
                case 8:
                    file.BorrowedBooks();
                    break;
                    
                case 9:
                    file.ReturnBook();
                    break;
                    
                case 10:
                    System.out.println("Program terminated");
                    break;
                    
                default:
                    System.out.println("Invalid Input!");
            }
        }
        while(choice!=10);
    }
}