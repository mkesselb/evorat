package org.shiftone.jrat.inject;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.shiftone.jrat.util.jmx.dynamic.ConfigurableMBeanTestCase;

@RunWith(Suite.class)

@Suite.SuiteClasses({ 
	InjectorCliTestCase.class
})

public class InjectTestSuite {

}
