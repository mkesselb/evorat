package org.shiftone.jrat.util.log;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({ 
	LoggerFactoryTest.class,
	LoggingManagerTest.class,
	ThreadLoggerFactoryTest.class,
	LoggerFactoryManagerTest.class
})

public class LogTestSuite {

}
