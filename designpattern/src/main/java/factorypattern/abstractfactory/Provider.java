package factorypattern.abstractfactory;

import factorypattern.normalpattern.Sender;

public interface Provider {
	public Sender produce();  
}
