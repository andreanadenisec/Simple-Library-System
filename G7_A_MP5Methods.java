/*Cadelina, Andreana Denise - 1,3,9
  Paguirigan, John Nicholas - 7, 8
  Payuyo, Ericka Fiona - 2, 4
  2IT-A */
import java.io.*;
import java.text.*;
import java.util.*;

public class G7_A_MP5Methods 
{   
    int studentId, age, BookId;
    char sex;
    String studentSurname, studentFirstname, idstring, title, surname, firstname, author, date, status;
    Date pdate;
    char bookstatus;
    
    SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
    
    File book = new File("G7_A_Book.txt");
    File student = new File("G7_A_Student.txt");
    File borrow = new File("G7_A_Borrow.txt");

    LinkedList<Integer> idList = new LinkedList<>();
    LinkedList<String> surnameList = new LinkedList<>();
    LinkedList<String> firstnameList = new LinkedList<>();
    LinkedList<Integer> ageList = new LinkedList<>();
    LinkedList<Character> sexList = new LinkedList<>();
    LinkedList<Integer> booklist = new LinkedList<>();
    LinkedList<String> bookTitle = new LinkedList<>();
    LinkedList<String> bookAuthor = new LinkedList<>();
    LinkedList<String> bookDate = new LinkedList<>();
    LinkedList<String> bookStatus = new LinkedList<>();
    
    Scanner in = new Scanner(System.in);
    Scanner input = new Scanner(System.in);

    //[1] Add a Student
    //Ask the user to enter the student's information then validate
    public void studentId() throws IOException
    {
    	//Ask the user to enter the student's ID number then validate
        System.out.print("5-digit ID number: ");
        Scanner inputID = new Scanner(System.in);
        boolean idValidate = false;                 
        do
        {
            try
            {                           
                studentId = inputID.nextInt();
                String idLength = String.valueOf(studentId);
                
                //Validate if ID number is 5-digit
                if(idLength.length()==5)
                {
                    idValidate = true;
                    idList.add(studentId);
                }
                else
                {
                    System.out.println("ID number should be 5 digits. Please enter again.");
                    idValidate = false;
                    System.out.print("5-digit ID number: ");
                }
            }
            
            //If user inputs wrong data type
            catch(InputMismatchException ex)
            {
                System.out.println("Invalid input! Please enter again.");
                idValidate = false;
                System.out.print("Student ID number: ");
                input.nextLine();
            }
        }
        while(idValidate == false);
    }
    
    public void studentSurname() throws IOException
    {       
        try
        {
        	//Ask the user to enter the student's Surname then validate
            System.out.print("Surname: ");
            Scanner inputSurname = new Scanner(System.in);
            studentSurname = inputSurname.nextLine();
            surnameList.add(studentSurname);
        }
        catch(Exception e)
        {
            System.out.println("Invalid input! Please enter again.");
            studentSurname();
        }
        
    }
    
    public void studentFirstname() throws IOException
    {
        try
        {
        	//Ask the user to enter the student's First name then validate
            System.out.print("First name: ");
            Scanner inputFirstname = new Scanner(System.in);
            studentFirstname = inputFirstname.nextLine();
            firstnameList.add(studentFirstname);
        }
        catch(Exception e)
        {
            System.out.println("Invalid input! Please enter again.");
            studentFirstname();
        }
    }
    
    public void studentAge() throws IOException
    {
    	//Ask the user to enter the student's age then validate
        System.out.print("Age: ");
        Scanner inputAge = new Scanner(System.in);
        boolean ageValidate = false;                    
        do
        {
            try
            {                           
                age = inputAge.nextInt();
                
                // Validate age
                if(age>0 && age<130)
                {
                    ageValidate = true;
                    ageList.add(age);
                }
                else
                {
                    System.out.println("Invalid age. Please enter again.");
                    ageValidate = false;
                    System.out.print("Age: ");
                }
                
            }
            
            //If user inputs wrong data type
            catch(InputMismatchException ex)
            {
                System.out.println("Invalid input! Please enter again.");
                ageValidate = false;
                System.out.print("Age: ");
                input.nextLine();
            }
        }
        while(ageValidate == false);
    }
    
    public void studentSex() throws IOException
    {
    	//Ask the user to enter the student's sex name then validate
        System.out.print("Sex[M/F]: ");
        Scanner inputSex = new Scanner(System.in);
        boolean sexValidate = false;                    
        do
        {
            sex = inputSex.next().charAt(0);
            // Validate if input is M or F
            if(sex=='F' || sex=='M')
            {
                sexValidate = true;
                sexList.add(sex);
            }
            else
            {
                System.out.println("Invalid input! Please enter again.");
                sexValidate = false;
                System.out.print("Sex[M/F]: ");
            }
        }
        while(sexValidate == false);
    }
    
    public void addtoStudentsRecord() throws FileNotFoundException
    {
        try 
        {                       
            String path = System.getProperty("user.dir") + "\\G7_A_Student.txt";
            FileWriter addStudents = new FileWriter(path, true);
            
            // Writes string to the file
            addStudents.write("\n" + idList.get(idList.size()-1) + "\t\t\t" + surnameList.get(surnameList.size()-1) + "\t\t" + firstnameList.get(firstnameList.size()-1) + "\t\t" + ageList.get(ageList.size()-1) + "\t\t" + sexList.get(sexList.size()-1));
            addStudents.close();
        }
        catch(IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
	//[2] Add a Book
	//Ask the user to enter the books's information then validate
	public void bookId() throws IOException
	{
		try
		{
			//Ask the user to enter the books number name then validate
            System.out.print("5-Digit Book Number: ");
			BookId = Integer.parseInt(in.nextLine());
			idstring = String.valueOf(BookId);
			if(idstring.length()==5)
				booklist.add(BookId);
			else
			{
				System.out.println("Invalid! Please enter 5 digits for book number.");
				bookId();
			}
		}
		catch(NumberFormatException e)
		{
			System.out.println("Invalid input!Please Enter Again.");
			bookId();
		}
	}
	
	public void bookTitle() throws IOException
	{
		try
		{
			//Ask the user to enter the title of the book then validate
            System.out.print("Book Title: ");
			title = in.nextLine();
			bookTitle.add(title);
		}
		catch(Exception e)
		{
			System.out.println("Invalid input! Please enter again.");
			bookTitle();
		}
	}
	
	public void authorName() throws IOException
	{
		try
		{
			//Ask the user to enter the author's Surname and First name then validate
            System.out.print("Author's Surname: ");
			surname = in.nextLine();
			System.out.print("Author's Firstname: ");
			firstname = in.nextLine();
			author = surname+", "+firstname;
			bookAuthor.add(author);
		}
		catch(Exception e)
		{
			System.out.println("Invalid input! Please enter again.");
			bookTitle();
		}
	}
	
	public void dateofPurchase() throws IOException
	{
		try
		 {
			//Ask the user to enter the date of purchase then validate
            System.out.print("Date of Purchase(mm-dd-yy): ");
			date = in.nextLine();
			pdate = formatter.parse(date);
			date = formatter.format(pdate);
			bookDate.add(date);
		 }
		 catch(ParseException e)
		 {
			 System.out.println("Invalid input!");
			 dateofPurchase();
		 }
	}
	
	public void bookStatus() throws IOException
	{
		try
		{
			//Ask the user to enter the book status then validate
            System.out.println("[a] Available");
			System.out.println("[b] Not Available");
			System.out.print("Book Status: ");
			bookstatus = in.next().charAt(0);
			if(bookstatus=='a' || bookstatus=='A')
			{
				status = "Available";
			}
			else if(bookstatus=='b' || bookstatus=='B')
			{
				status = "Not Available";
			}
			else
			{
				System.out.println("Invalid Input! Enter again.");
				bookStatus();
			}
			bookStatus.add(status);
		}
		catch(Exception e)
		{
			System.out.println("Invalid input! Please enter again.");
			bookStatus();
		}
	}
	
    
    public void addtoBookRecord() throws FileNotFoundException
    {
        try 
        {                       
            String path = System.getProperty("user.dir") + "\\G7_A_Book.txt";
            FileWriter addBooks = new FileWriter(path, true);
            
            // Writes string to the file
            addBooks.write("\n" + booklist.get(booklist.size()-1) + "\t\t" + bookTitle.get(bookTitle.size()-1) + "\t\t" + bookAuthor.get(bookAuthor.size()-1) + "\t" + bookDate.get(bookDate.size()-1) + "\t\t" + bookStatus.get(bookStatus.size()-1));
            addBooks.close();
        }
        catch(IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    //[3] Display All Students
    public void displayStudentRecord() throws FileNotFoundException
    {
        try
        {
            Scanner studentRecord = new Scanner(student);
            
            System.out.println("\nStudent Record");
            while(studentRecord.hasNext())
            {
                System.out.println(studentRecord.nextLine());
            }
            System.out.println();
            studentRecord.close();
        }
        catch(IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    //[4] Display All Books
    public void displayBookRecord() throws FileNotFoundException
    {
        try
        {
            
            Scanner bookRecord = new Scanner(book);
            
            System.out.println("\nBook Record");
            while(bookRecord.hasNext())
            {
                System.out.println(bookRecord.nextLine());
            }
            System.out.println();
            bookRecord.close();
        }
        catch(IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
	//[7] Borrow a Book
	public void listofBooks() throws FileNotFoundException
	{
		int x = 0;
		String borrower,bookborrow,date;
		System.out.println();
		Scanner bookreader = new Scanner(book);
		
		while(bookreader.hasNextLine())
		{
			String display = bookreader.nextLine();
			
			if(!(display.contains("Unavailable")))
			{
				
				System.out.println(display);
			}
		}
		System.out.println();
		bookreader.close();
		
		System.out.print("5-digit ID number: ");
		borrower = input.nextLine();
		while(borrower.length() > 5 || borrower.length() < 5)
		{
			System.out.print("Invalid input! Please enter again.\n");
			System.out.print("5-digit ID number: ");
			borrower = input.nextLine();
			x++;
		}
		System.out.print("Book Title: ");
		bookborrow = input.nextLine();
		System.out.print("Date: ");
		date = input.nextLine();
		
		try
		{
			Scanner studentreader = new Scanner(student);
			Scanner bookreader_2 = new Scanner(book);
			String idbook = "", titlebook = "", borrowernamefirst = "", borrowernamelast = "";
			while(studentreader.hasNextLine())
			{
				String studentrec = studentreader.nextLine();
				
				if(studentrec.contains(borrower))
				{
					String[] studentarray = studentrec.split("		");
					borrowernamefirst = studentarray[2]; 	
					borrowernamelast = studentarray[1];
				}
			}
			StringBuffer sb = new StringBuffer();
			String bookavail = "", bookunavail = "";
			
			while(bookreader_2.hasNext())
			{
				String bookrec = bookreader_2.nextLine();
				
				if(bookrec.contains(bookborrow))
				{
					String[] bookarray = bookrec.split("\t\t\t");
					idbook = bookarray[0];
					titlebook = bookarray[1];
					bookavail = bookrec;
					bookunavail = bookarray[0]+"\t\t\t"+bookarray[1]+"\t\t\t"+bookarray[2]+"\t\t\t"+bookarray[3]+"\t\t\tUnavailable";
				}
				sb.append(bookrec+"\n");
			}
			String record = sb.toString();
			record = record.replaceAll(bookavail, bookunavail);
			PrintWriter pw = new PrintWriter(book);
			pw.append(record);
			pw.flush();
			pw.close();
			
			String borrowinfo = (idbook + "\t\t" + titlebook + "\t\t" + borrowernamelast + ", " + borrowernamefirst + "\t\t" + date + "\n");
			
			FileWriter writer = new FileWriter(borrow, true);
			writer.write(borrowinfo);
			writer.close();
			
			studentreader.close();
			bookreader_2.close();
			System.out.print("You successfuly borrowed a book!\n");
		}
		catch(Exception e)
		{
			System.out.println("File not found!");
		}
	}
    //[8] Display Borrowed Books
    public void BorrowedBooks() 
    {
        try
        {
            Scanner borrowreader = new Scanner(borrow);
            System.out.println("\nBorrow Record");
            System.out.println("Book number\t\tTitle of the Book\t\tBorrower's Name\t\t\tDate borrowed ");
            while(borrowreader.hasNextLine())
            {
                String borrowRec = borrowreader.nextLine();
                System.out.println("\n" + borrowRec);
            }
            System.out.println();
            borrowreader.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found!");
        }
    }
    //[9] Return a Book
    public void ReturnBook() throws IOException
    {
        int x=0;
        Scanner borrowerID = new Scanner(System.in);
        System.out.print("Student ID: ");
        String borrower = borrowerID.nextLine();
        while(borrower.length() > 5 || borrower.length() < 5)
        {
            System.out.print("Enter valid ID: ");
            borrower = borrowerID.nextLine();
            x++;
        }
        
        Scanner borrowerBookID = new Scanner(System.in);
        System.out.print("Book number: ");
        String bookIDborrowed = borrowerBookID.nextLine();
        while(borrower.length() > 5 || borrower.length() < 5)
        {
            System.out.print("Invalid input! Please enter again: ");
            borrower = borrowerBookID.nextLine();
            x++;
        }
        
        Scanner borrowReader = new Scanner(borrow);
        while(borrowReader.hasNext())
        {
            String borrowDetails = borrowReader.nextLine();
            
            if(borrowDetails.contains(bookIDborrowed))
            {
                String[] bookarray = borrowDetails.split("\t\t\t");    
                String input = null;
                StringBuffer sb = new StringBuffer();
                while (borrowReader.hasNextLine()) 
                {
                    input = borrowReader.nextLine();
                    sb.append(input);
                }
                String result = sb.toString();  
                result = result.replaceAll(bookarray[0], "  ");
                
                //Rewriting the contents of the file
                PrintWriter writer = new PrintWriter(borrow);
                
                writer.append(result);
                writer.flush();         
            }
        }
        
        FileWriter writer = new FileWriter(borrow, true);
        writer.close();
        borrowReader.close();
        
        System.out.println("Book has been returned, thank you!");
    }
}