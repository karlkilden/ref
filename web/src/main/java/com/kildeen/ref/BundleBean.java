package com.kildeen.ref;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.kildeen.ref.system.Current;
import com.kildeen.ref.system.SystemNode;

@RequestScoped
public class BundleBean {
	
    @Inject
    @Current
    private Locale locale;

    public String getText(SystemNode systemNode) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        return bundle.getString(systemNode.getDefinition().getCanonicalName());
    }
	
}
