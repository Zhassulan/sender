package kz.ugs.webpush.sender;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Sender {
	
	public Sender(String key, String token, String ticketNumber)	{
		final String SERVER_KEY = key;
		Pushraven.setKey(SERVER_KEY);
		Notification raven = new Notification();
		AtomicInteger msgId = new AtomicInteger();
		// build raven message using the builder pattern
		raven.to(token)
			.collapse_key("a_collapse_key")
			.priority(1)
			.delay_while_idle(true)
			.time_to_live(1000)
			//.restricted_package_name("false")
			.dry_run(false)
			//.data(data)
			.title("SmartTime")
			.body("Ваша очередь по билету №" + ticketNumber + " подошла.")
			.color("#00e600");
		//raven.addRequestAttribute("message_id", String.valueOf(msgId));

		// push the raven message
		//FcmResponse response = Pushraven.push(raven);

		// alternatively set static notification first.
		Pushraven.setNotification(raven);
		FcmResponse response = Pushraven.push();

		// prints response code and message
		System.out.println(response);
}
}