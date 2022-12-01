package school;

//학생의 과목 점수를 산출하는 클래스
public class Score {
	//필드
	private int studentId; //학번
	private Subject subject; //과목
	private int point; //점수
	
	//생성자
	public Score(int studentId, Subject subject, int point) {
		this.studentId = studentId;
		this.subject = subject;
		this.point = point;
	}

	//Score객체가 가지고 있는 학번, 과목, 점수를 리턴
	@Override
	public String toString() {
		return "학번: " + this.studentId + ", " + subject.getSubjectName() + ": " + this.point;
	}
	
	//getter, setter 메소드
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
}
