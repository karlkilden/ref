package com.kildeen.ref.system;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.deltaspike.core.api.config.view.ViewConfig;

/**
 * <p>File created: 2014-05-09 17:27</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public interface SystemNodeResolver extends Serializable {
    List<SystemNode> root();

    Class<? extends ViewConfig> getDefinitionByName(String permission);

    Collection<SystemNode> nodes();

    Set<Class<?>> getNavigationalNodes();

    SystemNode getByPath(String path);

	SystemNode getByDefinition(Class<? extends ViewConfig> toView);

    SystemNode getByNodeName(String nodeName);


}
