package reflectionexample;

public class CalledClass extends CalledClassParent{

	public void repeatNTimes(Object obj,int numOfTimes) {
		for(int i=0;i<numOfTimes;i++) {
			System.out.println(obj.toString());
		}
	}
	
}
