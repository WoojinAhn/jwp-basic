package core.ref;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Junit5TestRunner {

	private static final Logger logger = LoggerFactory.getLogger(Junit5TestRunner.class);

	@Test
	public void run() throws Exception {
		Class<Student> clazz = Student.class;

		Student student = new Student();
		Field field = clazz.getDeclaredField("name");
		field.setAccessible(true);
		field.set(student, "우진");
		logger.debug(student.getName());
	}
}
