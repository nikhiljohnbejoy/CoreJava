package njb.core.daemonthread;

public class MainClass {

	public static void main(String[] args) {
		//Daemon Thread works without blocking JVM exit upon completion of user threads
		Thread daemonThread=new Thread(()->{
			while(true) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("-----Dont mind me---");
			}});
		daemonThread.setDaemon(true);
		//This is a user thread, upon completion, JVM no longer needs to be running 
		Thread workerThread=new Thread(()->System.out.println("Im done doing imp work"));
		
		daemonThread.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		workerThread.start();
	}

}
