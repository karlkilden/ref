package com.kildeen.ref;

import com.kildeen.ref.system.Current;
import com.kildeen.ref.system.Pages;
import com.kildeen.ref.system.SystemNode;
import com.kildeen.ref.system.SystemNodeResolver;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.core.api.config.view.metadata.ViewConfigDescriptor;
import org.apache.deltaspike.core.api.config.view.metadata.ViewConfigResolver;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import static com.kildeen.ref.system.Pages.Admin.Group.GroupSetup;
import static com.kildeen.ref.system.Pages.Admin.Group.Groups;

/**
 * <p>File created: 2014-05-11 20:25</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@SessionScoped
@Named
public class NavigationBean implements Serializable {


    @Inject
    private SystemNodeResolver systemNodeResolver;


    @Inject
    @Current
    private Locale locale;

    @Inject
    FacesContext facesContext;

    private MenuModel model = new DefaultMenuModel();
    @Inject
    private ViewConfigResolver viewConfigResolver;

    @PostConstruct
    private void setupNavigation() {

        for (SystemNode systemNode : systemNodeResolver.root()) {
            for (SystemNode node : systemNode.children()) {
                addNode(model, node);
            }

        }

    }

    private void addNode(final MenuModel model, final SystemNode node) {
        if (systemNodeResolver.getNavigationalNodes().contains(node.getDefinition())) {
            if (node.isStem()) {
                DefaultSubMenu subMenu = new DefaultSubMenu(getText(node));
                model.addElement(subMenu);
                addSubMenu(subMenu, node);

            } else if (node.isBranch()) {
                DefaultMenuItem item = new DefaultMenuItem(getText(node));
                item.setOutcome(node.getDefinition().toString());
                model.addElement(item);
            }

        }
    }

    private void addSubMenu(final DefaultSubMenu subMenu, final SystemNode node) {
        for (SystemNode child : node.children()) {
            if (child.isStem()) {
                DefaultSubMenu sm = new DefaultSubMenu(getText(child));
                subMenu.addElement(sm);
                addSubMenu(sm, child);
            } else if (child.isBranch()) {
                DefaultMenuItem item = new DefaultMenuItem(getText(child));
                item.setOutcome(child.getDefinition().toString());
                subMenu.addElement(item);
            }
        }
    }

    public MenuModel getModel() {
        return model;
    }

    public String getText(SystemNode systemNode) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        return bundle.getString(systemNode.getDefinition().getCanonicalName());
    }

    public String getViewHeader() {
        return getText(systemNodeResolver.byId(viewConfigResolver.getConfigDescriptor(facesContext.getViewRoot().getViewId()).getConfigClass().getCanonicalName()));
    }

    public Class<? extends ViewConfig> getNavigateDefault() {
        return Groups.class;
    }
}
