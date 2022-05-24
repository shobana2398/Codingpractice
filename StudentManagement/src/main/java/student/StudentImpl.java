package student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
//StudentDAOImpl
public class StudentImpl implements StudentDAO {

	List<Student> studentlist = new ArrayList<Student>();

	public void insert(Student student) {
		// TODO Auto-generated method stub

		if (studentlist.isEmpty()) {
			
			student.setId(100);
		} else {
			int lastid = studentlist.get(studentlist.size() - 1).getId();
			student.setId(lastid + 1);
		}
		studentlist.add(student);

		System.out.println("New Student inserted successfully "
				+ student.getStudentName());
		System.out.println(studentlist + " " + studentlist.size());

		//System.out.println(Student.toString(studentlist));
	}

	public void update(int id) {
		// studentlist.get(((Student)
		// studentlist).getId()).setStudentName("Altered");
		// System.out.println(studentlist.toString());
		// System.out.println("Student updated Successfully");

		if (studentlist != null && id == studentlist.get(0).getId()) {
			studentlist.get(0).setStudentName("Updated NAme");
			System.out.println(studentlist.toString());
			System.out.println("Student updated Successfully");
		} else {
			System.out.println("student not available");
		}

	}

	public void delete(int Id) {

		studentlist.remove(Id);
		System.out.println(studentlist.toString());
	}

	public List<Student> display(String name) {

		if (name.equals(studentlist.get(0).getStudentName())) {
			return studentlist;

		}
		return null;
	}

	public void display() {
		Iterator<Student> itr = studentlist.iterator();

		while (itr.hasNext()) {
			Student student = itr.next();

			if ((student.getEnglishMark()) >= 35
					&& (student.getMathsMark()) >= 35
					&& (student.getScienceMark()) >= 35
					&& (student.getTamilMark()) >= 35
					&& (student.getSocialMark()) >= 35)
			// System.out.println(studentlist.get(0));
			{
				System.out.println(student);
			}

		}

	}

	public void display(int maths_mark) {
		Iterator<Student> itr = studentlist.iterator();

		while (itr.hasNext()) {
			Student student = itr.next();

			if (student.getMathsMark() >= maths_mark) {
				System.out.println(student);

			}
		}

	}
}
