package com.kildeen.ref.system;


import com.kildeen.ref.system.Current;
import com.kildeen.ref.system.TestIndex;

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

public class TestPagesProducer {

    @Produces
    @Current
    public List<Class<? extends ViewConfig>> rootNodes() {

        return Arrays.asList(TestIndex.class, TestPages.class);
    }
}
