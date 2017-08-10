package factorypattern.abstractfactory;

import factorypattern.normalpattern.Sender;
import factorypattern.normalpattern.SmsSender;

public class SendSmsFactory implements Provider {

	public Sender produce() {
		 return new SmsSender();
	}

}
