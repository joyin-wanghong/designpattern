package TestApp;

import java.util.Vector;

import behavetype.commandpattern.AudioPlayer;
import behavetype.commandpattern.Command;
import behavetype.commandpattern.Keypad;
import behavetype.commandpattern.PlayCommand;
import behavetype.commandpattern.RewindCommand;
import behavetype.commandpattern.StopCommand;
import behavetype.dutychainpattern.DeptManager;
import behavetype.dutychainpattern.GeneralManager;
import behavetype.dutychainpattern.Handler;
import behavetype.dutychainpattern.ProjectManager;
import behavetype.interpreterpattern.And;
import behavetype.interpreterpattern.Constant;
import behavetype.interpreterpattern.Context;
import behavetype.interpreterpattern.Expression;
import behavetype.interpreterpattern.Not;
import behavetype.interpreterpattern.Or;
import behavetype.interpreterpattern.Variable;
import behavetype.iteratorpattern.Client;
import behavetype.mediatorpattern.AbstractColleague;
import behavetype.mediatorpattern.AbstractMediator;
import behavetype.mediatorpattern.ColleagueA;
import behavetype.mediatorpattern.ColleagueB;
import behavetype.mediatorpattern.Mediator;
import behavetype.mementopattern.Caretaker;
import behavetype.mementopattern.Originator;
import behavetype.observerpattern.ConcreteObserver;
import behavetype.observerpattern.ConcreteSubject;
import behavetype.observerpattern.Observer;
import behavetype.statepattern.ConcreteStateB;
import behavetype.statepattern.State;
import behavetype.strategy.AdvancedMemberStrategy;
import behavetype.strategy.MemberStrategy;
import behavetype.strategy.Price;
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
import factorypattern.singlepattern.Resource;
import factorypattern.singlepattern.SingletonPattern;
import factorypattern.singlepattern.SomeThing;
import structuraltype.adapterpattern.classadaperpattern.Adapter;
import structuraltype.bridgepattern.AbstractRoad;
import structuraltype.bridgepattern.Bus;
import structuraltype.bridgepattern.Car;
import structuraltype.bridgepattern.SpeedWay;
import structuraltype.bridgepattern.Street;
import structuraltype.componentpattern.Component;
import structuraltype.componentpattern.Composite;
import structuraltype.componentpattern.Leaf;
import structuraltype.componentpattern.MarketBranch;
import structuraltype.componentpattern.MarketJoin;
import structuraltype.facade.ModuleA;
import structuraltype.facade.ModuleB;
import structuraltype.facade.ModuleC;
import structuraltype.facade.ModuleFacade;
import structuraltype.proxypattern.AbstractObject;
import structuraltype.proxypattern.ProxyObject;
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

	/**
	 * 测试责任链模式
	 */
	public void TestDutychainPattern() {
		// 先要组装责任链
		Handler h1 = new GeneralManager();
		Handler h2 = new DeptManager();
		Handler h3 = new ProjectManager();
		h3.setSuccessor(h2);
		h2.setSuccessor(h1);

		// 开始测试
		String test1 = h3.handleFeeRequest("张三", 300);
		System.out.println("test1 = " + test1);
		System.out.println("---------------------------------------");

		String test3 = h3.handleFeeRequest("张三", 700);
		System.out.println("test3 = " + test3);
		System.out.println("---------------------------------------");

		String test5 = h3.handleFeeRequest("张三", 1500);
		System.out.println("test5 = " + test5);
	}

	/**
	 * 测试命令模式
	 */
	public void TestCommandPattern() {
		// 创建接收者对象
		AudioPlayer audioPlayer = new AudioPlayer();
		// 创建命令对象
		Command playCommand = new PlayCommand(audioPlayer);
		Command rewindCommand = new RewindCommand(audioPlayer);
		Command stopCommand = new StopCommand(audioPlayer);
		// 创建请求者对象
		Keypad keypad = new Keypad();
		keypad.setPlayCommand(playCommand);
		keypad.setRewindCommand(rewindCommand);
		keypad.setStopCommand(stopCommand);
		// 测试
		keypad.play();
		keypad.rewind();
		keypad.stop();
		keypad.play();
		keypad.stop();
	}

	/**
	 * 测试解析器模式
	 */
	public void TestIntepreterPattern() {
		Context ctx = new Context();
		Variable x = new Variable("x");
		Variable y = new Variable("y");
		Constant c = new Constant(true);
		ctx.assign(x, false);
		ctx.assign(y, true);
		Expression exp = new Or(new And(c, x), new And(y, new Not(x)));
		System.out.println("x=" + x.interpret(ctx));
		System.out.println("y=" + y.interpret(ctx));
		System.out.println(exp.toString() + "=" + exp.interpret(ctx));
	}

	/**
	 * 测式迭代子模式
	 */
	public void TestInterpretePattern() {
		Client client = new Client();
		client.operation();
	}

	/**
	 * 测试中介者模式
	 */
	public void TestMediatorPattern() {

		AbstractColleague collA = new ColleagueA();
		AbstractColleague collB = new ColleagueB();

		AbstractMediator am = new Mediator(collA, collB);

		System.out.println("==========通过设置A影响B==========");
		collA.setNumber(1000, am);
		System.out.println("collA的number值为：" + collA.getNumber());
		System.out.println("collB的number值为A的10倍：" + collB.getNumber());

		System.out.println("==========通过设置B影响A==========");
		collB.setNumber(1000, am);
		System.out.println("collB的number值为：" + collB.getNumber());
		System.out.println("collA的number值为B的0.1倍：" + collA.getNumber());
	}

	/**
	 * 测试备忘录模式
	 */
	public void testMementopattern() {
		Originator o = new Originator();
		Caretaker c = new Caretaker();
		// 改变负责人对象的状态
		o.setState("On");
		// 创建备忘录对象，并将发起人对象的状态储存起来
		c.saveMemento(o.createMemento());
		// 修改发起人的状态
		o.setState("Off");
		// 恢复发起人对象的状态
		o.restoreMemento(c.retrieveMemento());
		System.out.println(o.getState());
	}

	/**
	 * 测试状态模式
	 * 
	 * @author 汪宏
	 * @date 2017年8月11日 下午4:31:24
	 * @comment
	 */
	public void testStatePattern() {
		// 创建状态
		State state = new ConcreteStateB();
		// 创建环境
		behavetype.statepattern.Context context = new behavetype.statepattern.Context();
		// 将状态设置到环境中
		context.setState(state);
		// 请求
		context.request("test");
	}

	/**
	 * 测试策略模式
	 * 
	 * @author 汪宏
	 * @date 2017年8月11日 下午5:03:21
	 * @comment
	 */
	public void testStrategyPattern() {
		// 选择并创建需要使用的策略对象
		MemberStrategy strategy = new AdvancedMemberStrategy();
		// 创建环境
		Price price = new Price(strategy);
		// 计算价格
		double quote = price.quote(300);
		System.out.println("图书的最终价格为：" + quote);
	}

	/**
	 * 测试类适配器模式
	 * 
	 * @author 汪宏
	 * @date 2017年8月14日 上午10:13:38
	 * @comment
	 */
	public void testClassAdaperPattern() {
		Adapter adapter = new Adapter();
		// 本来Adaptee 是没有 sampleOperation2 功能的，通过继承的实现使 adapter 具有sampleOperation2的接口功能。
		adapter.sampleOperation1();
		adapter.sampleOperation2();
	}

	/**
	 * 测试对像的适配器模式
	 * 
	 * @author 汪宏
	 * @date 2017年8月14日 上午10:20:24
	 * @comment
	 */
	public void testObjectAdaperPattern() {
		Adapter adapter = new Adapter();
		// 通过委派的形式使adapter 具有 sampleOperation2 功能
		adapter.sampleOperation1();
		adapter.sampleOperation2();
	}

	/**
	 * 测试桥接模式
	 * 
	 * @author 汪宏
	 * @date 2017年8月14日 上午10:54:02
	 * @comment
	 */
	public void testBridgePattern() {
		AbstractRoad speedWay = new SpeedWay();
		speedWay.aCar = new Car();
		speedWay.run();

		AbstractRoad street = new Street();
		street.aCar = new Bus();
		street.run();
	}

	/**
	 * 测试组合模式
	 * 
	 * @author 汪宏
	 * @date 2017年8月14日 下午2:36:29
	 * @comment
	 */
	public void testComponentPattern() {
		// 构造根节点
		Composite rootComposite = new Composite();
		rootComposite.name = "根节点";

		// 左节点
		Composite compositeLeft = new Composite();
		compositeLeft.name = "左节点";

		// 构建右节点，添加两个叶子几点，也就是子部件
		Composite compositeRight = new Composite();
		compositeRight.name = "右节点";
		Leaf leaf1 = new Leaf();
		leaf1.name = "右-子节点1";
		Leaf leaf2 = new Leaf();
		leaf2.name = "右-子节点2";
		compositeRight.add(leaf1);
		compositeRight.add(leaf2);

		// 左右节点加入 根节点
		rootComposite.add(compositeRight);
		rootComposite.add(compositeLeft);
		// 遍历组合部件
		rootComposite.eachChild();
	}

	/**
	 * 测试组合模式2
	 * 
	 * @author 汪宏
	 * @date 2017年8月14日 下午2:48:29
	 * @comment
	 */
	public void testComponentPattern2() {
		MarketBranch rootBranch = new MarketBranch("总店");
		MarketBranch qhdBranch = new MarketBranch("秦皇岛分店");
		MarketJoin hgqJoin = new MarketJoin("秦皇岛分店一海港区加盟店");
		MarketJoin btlJoin = new MarketJoin("秦皇岛分店二白塔岭加盟店");
		qhdBranch.add(hgqJoin);
		qhdBranch.add(btlJoin);
		rootBranch.add(qhdBranch);
		rootBranch.PayByCard();
	}

	/**
	 * 测试门面模式（外观模式）
	 * 
	 * @author 汪宏
	 * @date 2017年8月14日 下午3:09:46
	 * @comment
	 */
	public void testFacadePattern() {
		ModuleFacade mf = new ModuleFacade();
		mf.a1();
		mf.b1();
		mf.c1();
	}

	/**
	 * 测试enum实现的单例模式
	 * 
	 * @author 汪宏
	 * @date 2017年8月14日 下午6:32:12
	 * @comment
	 */
	public void testEnumSinglePattern() {
		SomeThing e = SomeThing.INSTANCE;
		Resource resource = e.getInstance();

		System.out.println(resource.hashCode());

		Resource resource2 = e.getInstance();

		System.out.println(resource2.hashCode());
	}

	/**
	 * 测试结构型-代理模式
	 * 
	 *@author 汪宏
	 *@date 2017年8月15日 上午10:02:44 
	 *@comment
	 */
	public void testProxyPattern() {
		AbstractObject obj = new ProxyObject();
		obj.operation();
	}

}
