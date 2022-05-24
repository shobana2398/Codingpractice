package student;

import java.util.Scanner;


//SchoolAppRunner
public class Main {
	public static void main(String args[])

	{

		System.out.println("1.Insert New Student Details\n"
				+ "2.Update student detail based on studentid\n"
				+ "3.Dispaly the student based on name\n"
				+ "4.Display All passed students\n"
				+ "5.Display Students passed in maths\n"
				+ "6.Delete a student from the database");
		
		Scanner sc = new Scanner(System.in);
		
		int option;
		StudentDAO studentImpl = new StudentImpl();
		
	do{
		System.out.println("Enter any option to proceed...For exit press 0");
	    option= sc.nextInt();
	    System.out.println();
	
		switch (option) {
		case 1:
			//int id=sc.nextInt();
			String name=sc.next();
			int tamilMark=sc.nextInt();
			int englishMark=sc.nextInt();
			int mathsMark=sc.nextInt();
			int scienceMark=sc.nextInt();
			int socialMark=sc.nextInt();
			String result=sc.next();
			Student student=new Student(name,tamilMark,englishMark,mathsMark,scienceMark,socialMark,result);
			studentImpl.insert(student);
			System.out.println();
			break;
		case 2:
			int id1=sc.nextInt();
			studentImpl.update(id1);
			System.out.println();
			break;
		case 3:
			String studname=sc.next();
			System.out.println(studentImpl.display(studname));
			break;
		case 4:
			int sid=sc.nextInt();
			studentImpl.delete(sid);
			break;
		case 5:
			studentImpl.display();
			break;
		case 6:
			 int mathmark=sc.nextInt();
			 studentImpl.display(mathmark);
			 break;
		case 0:
			System.out.println("program exited");
			break;
		}
	}while(option!=0);
	}
}
