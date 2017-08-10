package TestApp;

import java.util.Vector;

import behavetype.dutychainpattern.DeptManager;
import behavetype.dutychainpattern.GeneralManager;
import behavetype.dutychainpattern.Handler;
import behavetype.dutychainpattern.ProjectManager;
import behavetype.observerpattern.ConcreteObserver;
import behavetype.observerpattern.ConcreteSubject;
import behavetype.observerpattern.Observer;
import behavetype.visitorpattern.NodeA;
import behavetype.visitorpattern.NodeB;
import behavetype.visitorpattern.ObjectStructure;
import behavetype.visitorpattern.Visitor;
import behavetype.visitorpattern.VisitorA;
import factorypattern.abstractfactory.Provider;
import factorypattern.abstractfactory.SendMailFactory;
import factorypattern.buiderpattern.Builder;
import factorypattern.buiderpattern.Director;
import factorypattern.buiderpattern.WelcomeBuilder;
import factorypattern.factorymethod.ExportFactory;
import factorypattern.factorymethod.ExportFile;
import factorypattern.factorymethod.ExportHtmlFactory;
import factorypattern.normalpattern.SendFactory;
import factorypattern.normalpattern.Sender;
import junit.framework.TestCase;
import singlepattern.SingletonPattern;
import structuraltype.wrapperpattern.Bird;
import structuraltype.wrapperpattern.Fish;
import structuraltype.wrapperpattern.Monkey;
import structuraltype.wrapperpattern.TheGreatestSage;

public class TestApp extends TestCase {
	//////////////////////////////////////////////////// 【工厂模式】//////////////////////////////////////////////////////////////////
	/**
	 * 测试普通工厂类
	 */
	public void TestNormalPattern() {
		SendFactory factory = new SendFactory();
		Sender sender = factory.produce("sms");
		sender.Send();
	}

	/**
	 * 多个工厂方法模式（静态），是对普通工厂模式的改近
	 */
	public void TestMultiMethodPattern() {
		Sender sender = SendFactory.produceMail();
		sender.Send();
	}

	/**
	 * 测试抽像工厂模式
	 */
	public void TestAbstractFactory() {
		Provider provider = new SendMailFactory();
		Sender sender = provider.produce();
		sender.Send();
	}

	/**
	 * 测试单例模式
	 */
	public void TestSinglePattern() {
		SingletonPattern singletonpattern = SingletonPattern.getInstance();
		Vector vector = singletonpattern.getProperties();
	}

	/**
	 * 测试工厂方法模式
	 */
	public void TestFactoryMethodPattern() {
		String data = "";
		ExportFactory exportFactory = new ExportHtmlFactory();
		ExportFile ef = exportFactory.factory("financial");
		ef.export(data);
	}

	/**
	 * 测试建造者模式
	 */
	public void builderPattern() {
		Builder builder = new WelcomeBuilder();
		Director director = new Director(builder);
		director.construct("toAddress@126.com", "fromAddress@126.com");
	}

	/**
	 * 测试访问者模式
	 */
	public void TestVisitorPattern() {
		// 创建一个结构对象
		ObjectStructure os = new ObjectStructure();
		// 给结构增加一个节点
		os.add(new NodeA());
		// 给结构增加一个节点
		os.add(new NodeB());
		// 创建一个访问者
		Visitor visitor = new VisitorA();
		os.action(visitor);
	}

	/**
	 * 测试观察者模式
	 */
	public void TestObserverPattern() {
		// 创建主题对象
		ConcreteSubject subject = new ConcreteSubject();
		// 创建观察者对象
		Observer observer = new ConcreteObserver();
		// 将观察者对象登记到主题对象上
		subject.attach(observer);
		// 改变主题对象的状态
		subject.change("new state");
	}

	/**
	 * 测试装饰模式（或叫包装模式）
	 */
	public void TestWrapperPattern() {
		TheGreatestSage sage = new Monkey();
		// 第一种写法
		TheGreatestSage bird = new Bird(sage);
		TheGreatestSage fish = new Fish(bird);
		// 第二种写法
		// TheGreatestSage fish = new Fish(new Bird(sage));
		fish.move();
	}
	
	public void TestDutychainPattern() {
		//先要组装责任链
        Handler h1 = new GeneralManager();
        Handler h2 = new DeptManager();
        Handler h3 = new ProjectManager();
        h3.setSuccessor(h2);
        h2.setSuccessor(h1);
        
        //开始测试
        String test1 = h3.handleFeeRequest("张三", 300);
        System.out.println("test1 = " + test1);
        String test2 = h3.handleFeeRequest("李四", 300);
        System.out.println("test2 = " + test2);
        System.out.println("---------------------------------------");
        
        String test3 = h3.handleFeeRequest("张三", 700);
        System.out.println("test3 = " + test3);
        String test4 = h3.handleFeeRequest("李四", 700);
        System.out.println("test4 = " + test4);
        System.out.println("---------------------------------------");
        
        String test5 = h3.handleFeeRequest("张三", 1500);
        System.out.println("test5 = " + test5);
        String test6 = h3.handleFeeRequest("李四", 1500);
        System.out.println("test6 = " + test6);
	}

}
