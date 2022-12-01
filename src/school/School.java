package school;

import java.util.ArrayList;

//학교는 유일한 객체이므로 싱글톤 패턴으로 구현
public class School {
	//내부에 School객체를 생성해 준다.
	private static School instance = new School();
	/*
	 * private static School instance = null; //변수선언만 한 것과 같음
	 * 이것은 나는 이 변수형과 변수명을 쓸거라는 선언만 한거라
	 * -> 메모리에 저장이 되지 않음
	 * 
	 * 객체를 생성하면 메모리에 저장장소가 할당되게 되므로 
	 * -> 객체를 생성
	 */
	
	private static final String SCHOOL_NAME = "Good School"; //학교이름
	
	private ArrayList<Student> studentList = new ArrayList<>(); //학교에 등록한 학생
	private ArrayList<Subject> subjectList = new ArrayList<>(); //학교에서 개설한 과목
	
	/*
	 * 싱글톤은 생성자가 private
	 * -> 외부에서 객체를 여러개 생성하면 안되므로
	*/
	private School() {}
	
	//싱글톤 메소드 구현: School객체를 리턴
	//최초에 getInstance()메소드 호출 시 객체를 생성하면서 메모리에 할당
	public static School getInstance() {
		if(instance == null) {
			instance = new School();
		}
		
		return instance;
	}
	
	//학생 입학
	public void addStudent(Student student) {
		studentList.add(student);
	}
	
	//학생 리스트 출력
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	
	//과목개설
	public void addSubject(Subject subject) {
		subjectList.add(subject);
	}

	//과목 리스트 출력
	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}
	
	
	
}
