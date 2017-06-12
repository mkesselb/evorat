package org.shiftone.jrat.util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.shiftone.jrat.util.jmx.dynamic.ConfigurableMBeanTestCase;
import org.shiftone.jrat.util.log.LogTestSuite;

@RunWith(Suite.class)

@Suite.SuiteClasses({ 
	LogTestSuite.class,
	PropertyUtilTestCase.class,
	CharacterIteratorTest.class,
	ConfigurableMBeanTestCase.class,
	NestedRuntimeExceptionTestCase.class,
})

public class UtilTestSuite {

}
