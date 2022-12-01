package school.report;

import java.util.ArrayList;

import grade.BasicEvaluation;
import grade.GradeEvaluation;
import grade.MajorEvaluation;
import school.School;
import school.Score;
import school.Student;
import school.Subject;
import utils.Define;

public class GenerateGradeReport {
	//필드
	School school = School.getInstance(); //school싱글톤 객체 생성
	
	public static final String TTILE = "수강생 학점 \t\t\n";
	public static final String HEADER = "     이름 | 학번 | 필수과목 | 점수     \n";
	public static final String LINE = " -------------------------------\n";
	//String buffer = "";
	//StringBuffer: 문자열 추가 또는 변경할 때 사용
	private StringBuffer buffer = new StringBuffer();
	
	//성적산출결과, 헤더, 몸통, 푸터를 합쳐준다.
	public String getReport() {
		//과목리스트(국어, 수학) 불러오기
		ArrayList<Subject> subjectList = school.getSubjectList();
		for(Subject subject: subjectList) {
			makeHeader(subject);
			makeBody(subject);
			makeFooter();
		}
		//buffer의 데이터를 String타입으로 바꾼다.
		return buffer.toString();
	}
	
	//헤더를 만들어준다.
	public void makeHeader(Subject subject) {
		buffer.append(GenerateGradeReport.LINE);
		buffer.append("\t   " + subject.getSubjectName()); //과목이름
		buffer.append(GenerateGradeReport.TTILE);
		buffer.append(GenerateGradeReport.HEADER);
		buffer.append(GenerateGradeReport.LINE);
	}
	
	//바디를 만들어준다.
	public void makeBody(Subject subject) {
		//해당과목을 수강한 Student리스트 가져온다.
		ArrayList<Student> studentList = subject.getStudentList();
		//ArrayList<>길이를 알고싶을 때는 .size()
		for(int i=0; i<studentList.size(); i++) {
			//get(인덱스 번호)
			//이 목록의 지정된 위치에 있는 요소를 반환합니다.
			Student student = studentList.get(i);
			buffer.append(" " + student.getStudentName()); //학생이름
			buffer.append("  | ");
			buffer.append(student.getStudentId()); //학번
			buffer.append("  | ");
			buffer.append(student.getMajorSubject().getSubjectName()); //필수과목
			buffer.append("  | ");
			
			//학생별 수강과목의 점수 학점 계산
			getScoreGrade(student, subject.getSubjecId());
			buffer.append("\n");
			buffer.append(LINE);
		}
	}
	
	//학생의 수강과목 점수와 학점을 얻는 메소드
	public void getScoreGrade(Student student, int subjectId) {
		//해당 학생이 수강한 과목의 점수 리스트(국어, 수학)
		ArrayList<Score> scoreList = student.getScoreList();
		
		//해당 학생 필수과목의 과목코드
		int majorId = student.getMajorSubject().getSubjecId();
		
		/*
		 * GradeEvaluation[] gradeEvaluation = new MajorEvaluation();
		 * GradeEvaluation[] gradeEvaluation = new BasicEvaluation();
		 *  인터페이스[] 변수명 = {new 구현클래스(), new구현클래스()};
		 *  
		 */
		GradeEvaluation[] gradeEvaluation = {new BasicEvaluation(), new MajorEvaluation()};
		
		for(int i=0; i<scoreList.size(); i++) {
			Score score = scoreList.get(i); //해당과목의 점수를 받아온다.
			
			//과목코드가 같은지 확인
			if(score.getSubject().getSubjecId() == subjectId) {
				String grade; //학점
				
				//필수과목일때 학점 산출
				if(score.getSubject().getSubjecId() == majorId) {
					grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getPoint());
				} else { //일반과목일때 학점 산출
					grade = gradeEvaluation[Define.AB_TYPE].getGrade(score.getPoint());
				}
				
				buffer.append(score.getPoint());
				buffer.append(":");
				buffer.append(grade);
				buffer.append(" | ");
			}
		}
	}
	
	//푸터를 만들어준다.
	public void makeFooter() {
		buffer.append("\n"); //\n줄바꿈, buffer += "\n"
	}
}
