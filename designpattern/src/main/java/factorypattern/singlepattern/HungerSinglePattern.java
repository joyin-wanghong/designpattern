package factorypattern.singlepattern;
/**
 * 饿汉单例模式
 */
public class HungerSinglePattern {
	private static HungerSinglePattern instance = new HungerSinglePattern();

	/**
	 * 私有默认构造子
	 */
	private HungerSinglePattern() {
	}

	/**
	 * 静态工厂方法
	 */
	public static HungerSinglePattern getInstance() {
		return instance;
	}
}
