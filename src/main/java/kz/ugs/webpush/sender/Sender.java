package kz.ugs.webpush.sender;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Sender {
	
	public Sender(String key, String token)	{
		final String SERVER_KEY = key;
		Pushraven.setKey(SERVER_KEY);
		Notification raven = new Notification();
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("Hello", "World!");
		data.put("Marco", "Polo");
		data.put("Foo", "Bar");
		
		AtomicInteger msgId = new AtomicInteger();
		// build raven message using the builder pattern
		raven.to(token)
			.collapse_key("a_collapse_key")
			.priority(1)
			.delay_while_idle(true)
			.time_to_live(100)
			//.restricted_package_name("false")
			.dry_run(false)
			.data(data)
			.title("Testing")
			.body("Hello World!")
			.color("#ff0000");
		//raven.addRequestAttribute("message_id", String.valueOf(msgId));

		// push the raven message
		FcmResponse response = Pushraven.push(raven);

		// alternatively set static notification first.
		Pushraven.setNotification(raven);
		response = Pushraven.push();

		// prints response code and message
		System.out.println(response);
}
}