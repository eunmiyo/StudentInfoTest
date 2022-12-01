package school;

import java.util.ArrayList;

public class Student {
	private int studentId; //학번
	private String studentName; //학생이름
	private Subject majorSubject; //필수과목
	
	//학생이 수강한 과목의 점수 리스트
	//addSubjectScore()메소드가 호출 되면 scoreList 리스트에 추가됨
	private ArrayList<Score> scoreList = new ArrayList<>();
	
	public Student(int studentId, String studentName, Subject majorSubject) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.majorSubject = majorSubject;
	}
	
	//addSubjectScore(Score score)메소드가 호출되면 
	//-> ArrayList<Score> scoreList에 추가됨
	public void addSubjectScore(Score score) {
		scoreList.add(score);
	}
	
	//private접근 제한자로 선언했기 때문에 외부에서 쓸 때 
	//get으로 호출하고, set으로 재정의
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Subject getMajorSubject() {
		return majorSubject;
	}

	public void setMajorSubject(Subject majorSubject) {
		this.majorSubject = majorSubject;
	}

	public ArrayList<Score> getScoreList() {
		return scoreList;
	}

	public void setScoreList(ArrayList<Score> scoreList) {
		this.scoreList = scoreList;
	}

}
