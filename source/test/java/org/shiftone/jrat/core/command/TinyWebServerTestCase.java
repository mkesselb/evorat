package org.shiftone.jrat.core.command;

import org.shiftone.jrat.core.HandlerFactory;

import junit.framework.TestCase;

/**
 * @author Jeff Drost
 */
public class TinyWebServerTestCase extends TestCase {
   
    public void testSimple() throws Exception {
    	HandlerFactory.initialize();
        Thread.sleep(1000 * 2 /* * 60 * 60 */);
    }
    
}
