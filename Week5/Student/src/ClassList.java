public class ClassList {
	private int year;
	private int semester;
	private Subject sub;
	private Student s1;
	private Student s3;

	public ClassList() {
		super();
	}

	public ClassList(int year, int semester, Subject sub, Student s1, Student s3) {
		super();
		this.year = year;
		this.semester = semester;
		this.sub = sub;
		this.s1 = s1;
		this.s3 = s3;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public Subject getSub() {
		return sub;
	}

	public void setSub(Subject sub) {
		this.sub = sub;
	}

	public Student getS1() {
		return s1;
	}

	public void setS1(Student s1) {
		this.s1 = s1;
	}

	public Student getS3() {
		return s3;
	}

	public void setS3(Student s3) {
		this.s3 = s3;
	}

	public String toString() {
		String info = "";
		info = this.year + "学年" + this.semester + "学期\n";
		info += this.sub.toString() + "\n";
		info += "学号\t姓名\n";
		info += "========================\n";
		info += this.s1.toString() + "\n";
		info += this.s3.toString();
		return info;
	}

}
