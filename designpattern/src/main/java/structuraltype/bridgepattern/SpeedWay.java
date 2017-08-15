package structuraltype.bridgepattern;

public class SpeedWay extends AbstractRoad {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		aCar.run();
		System.out.println("在高速公路行驶");
	}
}
