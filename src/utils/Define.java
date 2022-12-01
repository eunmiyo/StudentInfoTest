package utils;

/*
 * 프로그램 전반에서 사용하는 상수들
 * -> 사용, 수정, 관리에 용이
 */
public class Define {
	/*
	 * final을 붙이면 상수 
	 * 대문자로 변수명을 적어 줘야 한다
	 */
	//과목코드
	public static final int KOREA = 1001; //국어
	public static final int MATH = 2001; //수학
	
	//학점 산출 방식
	public static final int AB_TYPE = 0; //A, B, ...일반과목 산출방식
	public static final int SAB_TYPE = 1; //S, A, B, ...필수과목 산출방식
}
