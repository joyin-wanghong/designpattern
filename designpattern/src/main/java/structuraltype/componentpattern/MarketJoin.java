package structuraltype.componentpattern;

public class MarketJoin extends Market {
	public MarketJoin(String s) {
		this.name = s;
	}

	@Override
	public void add(Market m) {
	}

	@Override
	public void remove(Market m) {
	}

	@Override
	public void PayByCard() {
		System.out.println(name + "消费,积分已累加入该会员卡");
	}
}
