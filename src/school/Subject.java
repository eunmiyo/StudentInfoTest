package school;

import java.util.ArrayList;

import utils.Define;

public class Subject {
	private String subjectName; //과목명
	private int subjecId; //과목코드
	private int gradeType; //학점산출방식, 학점평가정책
	
	//과목을 수강신청한 학생 리스트
	private ArrayList<Student> studentList = new ArrayList<>();
	
	public Subject(String subjectName, int subjecId) {
		this.subjectName = subjectName;
		this.subjecId = subjecId;
		/*
		 * 학점평가정책은: 기본으로 A,B 방식을 사용한다.
		 * Define에서 stastic으로 선언해줬기 때문에 
		 * 객체를 생성하지 않고 가져올수 있다.
		 */
		this.gradeType = Define.AB_TYPE;
	}
	
	//수강신청한 학생이 등록된다.
	public void register(Student student) {
		studentList.add(student);
	}

	//getter, setter 메소드
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubjecId() {
		return subjecId;
	}

	public void setSubjecId(int subjecId) {
		this.subjecId = subjecId;
	}

	public int getGradeType() {
		return gradeType;
	}

	public void setGradeType(int gradeType) {
		this.gradeType = gradeType;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
}
