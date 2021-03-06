package com.kildeen.ref;

import com.kildeen.ref.module.authorization.GroupDTO;
import com.kildeen.ref.system.*;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.primefaces.model.menu.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

import static com.kildeen.ref.system.Pages.Content.FactOverview;

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
    GroupDTO groupDTO;

    private MenuModel model = new DefaultMenuModel();

    @Inject
    private BundleBean bundleBean;

    @PostConstruct
    private void setupNavigation() {

        for (SystemNode systemNode : systemNodeResolver.root()) {
            for (SystemNode node : systemNode.children()) {
                addNode(model, node);
            }

        }
        DefaultMenuItem item = new DefaultMenuItem("Logout");
        item.setOutcome(Index.class.toString());
        model.addElement(item);
    }

    private void addNode(final MenuModel model, final SystemNode node) {
        if (systemNodeResolver.getNavigationalNodes().contains(node.getDefinition()) && groupDTO.getPermissionSet().contains(node.getPermission())) {
            if (node.isStem()) {
                DefaultSubMenu subMenu = new DefaultSubMenu(bundleBean.getText(node));
                model.addElement(subMenu);
                addSubMenu(subMenu, node);

            } else if (node.isBranch()) {
                DefaultMenuItem item = new DefaultMenuItem(bundleBean.getText(node));
                item.setOutcome(node.getDefinition().toString());
                model.addElement(item);
            }

        }
    }

    private void addSubMenu(final DefaultSubMenu subMenu, final SystemNode node) {
        for (SystemNode child : node.children()) {
            if (!groupDTO.getPermissionSet().contains(node.getPermission())) {
                continue;
            }
            if (child.isStem()) {
                DefaultSubMenu sm = new DefaultSubMenu(bundleBean.getText(child));
                subMenu.addElement(sm);
                addSubMenu(sm, child);
            } else if (child.isBranch()) {
                DefaultMenuItem item = new DefaultMenuItem(bundleBean.getText(child));
                item.setOutcome(child.getDefinition().toString());
//                item.setCommand("#{navigationBean.navigate('"+child.getDefinition().toString()+"')}");
                subMenu.addElement(item);
            }
        }
    }

    public MenuModel getModel() {
        return model;
    }

    public String getViewHeader() {
        return "";
    }
    
    public Class<? extends ViewConfig> getNavigateDefault() {
    	return FactOverview.class;
    }
    
    public String navigate(String outcome) {
    	return outcome;
    }

}
