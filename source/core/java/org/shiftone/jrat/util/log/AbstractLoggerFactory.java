package org.shiftone.jrat.util.log;

import org.shiftone.jrat.util.log.target.NullLogTarget;
import org.shiftone.jrat.util.log.target.ProxyLogTarget;
import org.shiftone.jrat.util.log.target.ThreadLocalLogTarget;
import org.shiftone.jrat.util.log.target.WriterLogTarget;

public abstract class AbstractLoggerFactory implements Constants {

    protected static final NullLogTarget NULL_LOG_TARGET = NullLogTarget.INSTANCE;
    protected static final WriterLogTarget SYSTEM_OUT_TARGET = new WriterLogTarget(System.out);
    protected static final ProxyLogTarget PROXY_LOG_TARGET = new ProxyLogTarget(SYSTEM_OUT_TARGET);
    protected static final ThreadLocalLogTarget THREAD_TARGET = new ThreadLocalLogTarget(SYSTEM_OUT_TARGET);
    
}
