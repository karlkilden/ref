package com.kildeen.ref.context;


import com.kildeen.ref.system.Current;
import com.kildeen.ref.system.Index;
import com.kildeen.ref.system.Pages;

import javax.enterprise.inject.Produces;

import org.apache.deltaspike.core.api.config.view.ViewConfig;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>File created: 2014-05-24 12:35</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */

public class PagesProducer {

    @Produces
    @Current
    public List<Class<? extends ViewConfig>> rootNodes() {

        return Arrays.asList(Index.class, Pages.class);
    }
}
