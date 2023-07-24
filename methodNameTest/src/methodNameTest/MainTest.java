package methodNameTest;

import java.lang.reflect.Method;

public class MainTest {
	public static void main(String[] args) {
		MyUtil u = new MyUtil();
//		String result = u.sayHello("ahyeon");
		String methodName = "sayHello";
		// 문자열 변수 methodName에 저장된 sayHello를 호출하고싶다 ~ 
		
		try {
			Class<?> cls = Class.forName(u.getClass().getName());
			
			// 그 클래스에 정의된 동작시키고자 하는 Method 객체 생성
			// getDeclareMethod(MethodName, String.class)
			// 1번째 매개변수는 동작시키고자하는 메소드가 속해있는 객체 
			// 2번째 매개변수는 그 메소드의 매개변수의 자료형 와앙~ 와아앙~ 
			// 와르르 ~ 
			Method m = cls.getDeclaredMethod(methodName, String.class);
			
			// method 객체를 통해서 문자열로 된 메소드 실행 
			String result = (String)m.invoke(u, "혀니");
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
	}

}
