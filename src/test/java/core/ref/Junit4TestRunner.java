package core.ref;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class Junit4TestRunner {

	private static final Logger logger = LoggerFactory.getLogger(Junit4TestRunner.class);

	@Test
	public void run() throws Exception {
		Class<Junit4Test> clazz = Junit4Test.class;
		for(Method method : clazz.getDeclaredMethods()) {
			logger.debug("method name : " + method.getName());
			if(method.isAnnotationPresent(MyTest.class))
				method.invoke(clazz.newInstance());
		}
	}
}