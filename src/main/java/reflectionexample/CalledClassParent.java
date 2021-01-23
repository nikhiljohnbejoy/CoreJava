package reflectionexample;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CalledClassParent {
	
	public void invoke() {
		try {
			Method method=getClass().getMethod("repeatNTimes", new Class[] {Object.class,int.class});
			method.invoke(new CalledClass(), new String("Parent Class"),5);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
