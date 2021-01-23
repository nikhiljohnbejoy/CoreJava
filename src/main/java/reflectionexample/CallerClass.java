package reflectionexample;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CallerClass {

	public static void main(String[] args) {
			CallerClass caller=new CallerClass();
			caller.invokingMethod();
			System.out.println("--------------");
			new CalledClass().invoke();
	}

	private void invokingMethod() {
		try {
			Method method=CalledClass.class.getMethod("repeatNTimes", new Class[] {Object.class,int.class});
			method.invoke(new CalledClass(), new String("Caller Class"),5);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
