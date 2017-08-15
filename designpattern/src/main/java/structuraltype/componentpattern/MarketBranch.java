package structuraltype.componentpattern;

import java.util.ArrayList;
import java.util.List;

public class MarketBranch extends Market {
	// 加盟店列表
	List<Market> list = new ArrayList<Market>();

	public MarketBranch(String s) {
		this.name = s;
	}

	@Override
	public void add(Market m) {
		list.add(m);
	}

	@Override
	public void remove(Market m) {
		list.remove(m);
	}

	// 消费之后，该分店下的加盟店自动累加积分
	@Override
	public void PayByCard() {
		System.out.println(name + "消费,积分已累加入该会员卡");
		for (Market m : list) {
			m.PayByCard();
		}
	}
}
