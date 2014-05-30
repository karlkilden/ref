package com.kildeen.ref.permission;

import com.kildeen.ref.system.Current;
import com.kildeen.ref.system.Index;
import com.kildeen.ref.system.Pages;
import org.apache.deltaspike.core.api.config.view.ViewConfig;

import javax.enterprise.inject.Produces;
import java.util.Arrays;
import java.util.List;

public class MockPagesProducer {

    @Produces
    @Current
    public List<Class<? extends ViewConfig>> rootNodes() {

        return Arrays.asList(Index.class, Pages.class);
    }
}