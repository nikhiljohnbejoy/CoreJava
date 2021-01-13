package njb.core.concurrency;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentHashMapExample {
public static void main(String args[]) {
	//Normal HashMap is producing ConcurrentModificationException [not always]
	HashMap<Integer, String> map=new HashMap<Integer, String>();
	//Using concurrent hashmap we avoid the ConcurrentModificationException
	//But it does not mean that all 100000 will be read
	//ConcurrentHashMap<Integer, String> map=new ConcurrentHashMap<Integer, String>();
	
	//Sychronized does not help with ConcurrentModificationException
	//Map<Integer, String> map=Collections.synchronizedMap(new HashMap<Integer, String>());
	
	AtomicInteger putCount=new AtomicInteger(0);
	AtomicInteger readCount=new AtomicInteger(0);
	Thread putThread=new Thread(()-> {
		
			for(int i=0;i<1000000;i++) {
				
				map.put(i,"Thread 1");
				putCount.getAndAdd(1);
			}
	});
Thread getThread=new Thread(()->{
	for(Map.Entry<Integer, String> itr : map.entrySet()) {
		readCount.getAndAdd(1);
	}
	
	});
System.out.println(map.size());
putThread.start();
getThread.start();
try {
	putThread.join();
	getThread.join();
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println("put: "+putCount+"|| read: "+readCount);
System.out.println(map.size());

}
}
