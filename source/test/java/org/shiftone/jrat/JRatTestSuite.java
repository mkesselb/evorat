package org.shiftone.jrat;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.shiftone.jrat.event.EventTestSuite;
import org.shiftone.jrat.inject.InjectTestSuite;
import org.shiftone.jrat.provider.tree.TreeTestSuite;
import org.shiftone.jrat.core.CoreTestSuite;
import org.shiftone.jrat.desktop.DesktopTestSuite;
import org.shiftone.jrat.test.MiscTestSuite;
import org.shiftone.jrat.util.UtilTestSuite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	UtilTestSuite.class,
	MiscTestSuite.class,
	CoreTestSuite.class,
	TreeTestSuite.class,
	EventTestSuite.class,
	InjectTestSuite.class,
	DesktopTestSuite.class,
})

public class JRatTestSuite {

}
