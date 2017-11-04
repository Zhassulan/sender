package kz.ugs.webpush.sender;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.google.common.io.Resources;


public class ScriptExecute {
	
	public ScriptExecute (String notification, String token)	{
	// script engine
			final String ENGINE_NAME = "nashorn";

			// defining Script Engine Manager object
			ScriptEngineManager manager = new ScriptEngineManager();
			
			// defining the Script Engine
			ScriptEngine engine = manager.getEngineByName(ENGINE_NAME);
			
			try {
				final String fileName = "/static/app.js";
				engine.eval(java.lang.Class.class.getResourceAsStream(fileName).toString());
				Invocable invocable = (Invocable)engine;
				String message = (String)invocable.invokeFunction("sendNotificationByToken",  new Object[] { notification, 
						token});
				System.out.println(message);
				
			} catch (ScriptException e) {
				
				System.out.println(e.getMessage());
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
}

}