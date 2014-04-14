package application;

import org.apache.deltaspike.core.api.config.view.ViewConfig;

import java.util.Deque;

/**
 * <p>File created: 2014-04-13 13:33</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public interface FlowResolver {

    public Deque<Class<? extends ViewConfig>> getPausedFlows();

    public Deque<Class<? extends ViewConfig>> getFlowHistory();

    public Class<? extends ViewConfig> getPrevious();

    public Deque<Class<? extends ViewConfig>> getFailedFlows();

    public Deque<Class<? extends ViewConfig>> getFlowsByPriority();


}
