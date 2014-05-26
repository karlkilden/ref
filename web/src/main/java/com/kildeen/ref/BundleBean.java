package com.kildeen.ref;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.kildeen.ref.system.Current;
import com.kildeen.ref.system.SystemNode;

@Model
public class BundleBean implements Serializable {

    @Inject
    @Current
    private Locale locale;

    public String getText(SystemNode systemNode) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        return bundle.getString(systemNode.getDefinition().getCanonicalName());
    }

    public String getText(String nodeName) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        return bundle.getString(nodeName);
    }
	
}
