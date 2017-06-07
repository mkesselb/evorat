package org.shiftone.jrat.core;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.shiftone.jrat.core.boot.BootTest;
import org.shiftone.jrat.core.command.TinyWebServerTestCase;

@RunWith(Suite.class)

@Suite.SuiteClasses({ 
	BootTest.class,
	TinyWebServerTestCase.class
})

public class CoreTestSuite {

}
