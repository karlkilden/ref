package com.kildeen.ref.system;

import java.util.Calendar;
import java.util.List;

/**
 * <p>File created: 2014-05-18 15:14</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public interface StartupContext {

    public String bootKey();
    public Calendar bootTime();
    public List<NodeStartupResult> nodeStartupResults();
}
