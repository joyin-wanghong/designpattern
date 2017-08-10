package factorypattern.abstractfactory;

import factorypattern.normalpattern.MailSender;
import factorypattern.normalpattern.Sender;

public class SendMailFactory implements Provider {

	public Sender produce() {
		return new MailSender();
	}

}
