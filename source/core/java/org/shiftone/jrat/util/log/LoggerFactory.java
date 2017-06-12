package org.shiftone.jrat.util.log;

/**
 * There are currently 3 ways that logging can be configured...
 * <li>turned off - using NullLogTarget
 * <li>logging to a PrintWriter - System.out or file
 * <li>using thread based logging - each thread can have it's own LogTarget
 * (this is for the Desktop)
 *
 * @author jeff@shiftone.org (Jeff Drost)
 */
public class LoggerFactory extends AbstractLoggerFactory {
    
    private LoggerFactory(){
    	//prevent instance
    }

    public static Logger getLogger(Class<?> klass) {
        String className = klass.getName();
        String shortName = className.substring(className.lastIndexOf('.') + 1);

        return getLogger(shortName);
    }

    public static Logger getLogger(String topic) {
        return new Logger(topic, PROXY_LOG_TARGET);
    }
}
