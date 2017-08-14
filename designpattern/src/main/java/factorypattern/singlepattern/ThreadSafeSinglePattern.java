package factorypattern.singlepattern;

public class ThreadSafeSinglePattern {
	//被volatile修饰的变量的值，将不会被本地线程缓存，所有对该变量的读写都是直接操作共享内存，从而确保多个线程能正确的处理该变量。
	private volatile static ThreadSafeSinglePattern instance = null;		

	private ThreadSafeSinglePattern() {}

	public static ThreadSafeSinglePattern getInstance() {
		// 先检查实例是否存在，如果不存在才进入下面的同步块
		if (instance == null) {
			// 同步块，线程安全的创建实例
			synchronized (ThreadSafeSinglePattern.class) {
				// 再次检查实例是否存在，如果不存在才真正的创建实例
				if (instance == null) {
					instance = new ThreadSafeSinglePattern();
				}
			}
		}
		return instance;
	}
}
