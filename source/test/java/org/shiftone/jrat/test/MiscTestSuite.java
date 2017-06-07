package org.shiftone.jrat.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	IOTestCase.class,
	JmxTestCase.class,
	GlobTestCase.class,
	InjectorTestCase.class,
	BenchmarkTestCase.class,
	StringUtilTestCase.class,
	AccumulatorTestCase.class,
})

public class MiscTestSuite {

}
