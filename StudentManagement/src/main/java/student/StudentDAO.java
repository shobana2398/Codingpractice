package student;

import java.util.List;

public interface StudentDAO {
	public void insert(Student student);

	public void update(int id);

	public void delete(int Id);

	public List<Student> display(String name);

	public void display();

	public void display(int mathsMark);
}
