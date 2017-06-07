package org.shiftone.jrat.util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.shiftone.jrat.util.jmx.dynamic.ConfigurableMBeanTestCase;

@RunWith(Suite.class)

@Suite.SuiteClasses({ 
	PropertyUtilTestCase.class,
	ConfigurableMBeanTestCase.class,
	NestedRuntimeExceptionTestCase.class
})

public class UtilTestSuite {

}
