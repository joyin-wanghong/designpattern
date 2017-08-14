package factorypattern.singlepattern;

public class InnerClassSinglePattern {
	
	private InnerClassSinglePattern() {}

	/**
	 * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例 没有绑定关系，而且只有被调用到时才会装载，从而实现了延迟加载。
	 */
	private static class SingletonHolder {
		/**
		 * 静态初始化器，由JVM来保证线程安全
		 */
		private static InnerClassSinglePattern instance = new InnerClassSinglePattern();
	}

	public static InnerClassSinglePattern getInstance() {
		return SingletonHolder.instance;
	}
}
