package core.ref;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import next.model.Question;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {
	private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);
	
	@Test
	public void showClass() {
		Class<Question> clazz = Question.class;
		logger.debug(clazz.getName());
		logger.debug("######## Fields ##########");
		for (Field field : clazz.getDeclaredFields()) {	logger.debug(field.getName()); }
		logger.debug("######## Methods #########");
		for (Method method : clazz.getDeclaredMethods()) {	logger.debug(method.getName()); }
		logger.debug("##### Constructors #######");
		for (Constructor constructor : clazz.getDeclaredConstructors()) {	logger.debug(constructor.getName()); }
	}
}
