package student;

import java.util.Collection;
import java.util.Iterator;

public class Student {
	private int id;
	private String studentName;
	private int tamilMark;
	private int englishMark;
	private int mathsMark;
	private int scienceMark;
	private int socialMark;
	private String result;

	public Student(String studentName, int tamilMark, int englishMark,
			int mathsMark, int scienceMark, int socialMark, String result) {
		super();
		// this.id = id;
		this.studentName = studentName;
		this.tamilMark = tamilMark;
		this.englishMark = englishMark;
		this.mathsMark = mathsMark;
		this.scienceMark = scienceMark;
		this.socialMark = socialMark;
		this.result = result;
	}

	public Student() {
	}

	@Override
	public int hashCode() {

		return studentName.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Student another = (Student) obj;
		return this.studentName.equals(another.studentName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getTamilMark() {
		return tamilMark;
	}

	public void setTamilMark(int tamilMark) {
		this.tamilMark = tamilMark;
	}

	public int getEnglishMark() {
		return englishMark;
	}

	public void setEnglishMark(int englishMark) {
		this.englishMark = englishMark;
	}

	public int getMathsMark() {
		return mathsMark;
	}

	public void setMathsMark(int mathsMark) {
		this.mathsMark = mathsMark;
	}

	public int getScienceMark() {
		return scienceMark;
	}

	public void setScienceMark(int scienceMark) {
		this.scienceMark = scienceMark;
	}

	public int getSocialMark() {
		return socialMark;
	}

	public void setSocialMark(int socialMark) {
		this.socialMark = socialMark;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName
				+ ", tamilMark=" + tamilMark + ", englishMark=" + englishMark
				+ ", mathsMark=" + mathsMark + ", scienceMark=" + scienceMark
				+ ", socialMark=" + socialMark + ", result=" + result + "]";
	}

}