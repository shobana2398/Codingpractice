package student;

public class Dummy {
	int b;

	public Dummy() {
		System.out.println("Inside Default Constryctor");
	}

	public Dummy(int b) {

		b = b;
		System.out.println("Inside Parameterised Constructor" + this.b);
		// this();
	}

	public static void main(String[] args) {
		StudentImpl studentImpl = new StudentImpl();

		// System.out.println(studentImpl.add());
		int a;
		Dummy d = new Dummy(10);
		System.out.println(d.b);
		// Equals and hashcode method//100,100
		// name = sor and sor
		Student s1 = new Student("sory", 26, 55, 8, 66, 66, "P");
		Student s2 = new Student("sor", 25, 55, 88, 66, 66, "P");
		System.out.println(s1.hashCode() + ":" + s2.hashCode());
		System.out.println(s1.equals(s2));
		System.out.println(s1 == s2);
		String test = "hello\nWorld";
		System.out.println(test);
		System.out.println("Sum:"+(5+5)+"not ten");
		int c=10;
		String s3="abc"+c+"xyz";
		System.out.println(s3);
		System.out.println('a'+32+"A");
	}
}
