
package com.kildeen.ref.permission;


import com.kildeen.ref.application.module.authorization.GroupDTO;
import com.kildeen.ref.application.module.authorization.GroupService;
import com.kildeen.ref.application.module.user.UserService;
import com.kildeen.ref.domain.Permission;
import com.kildeen.ref.domain.User;
import com.kildeen.ref.system.Current;
import com.kildeen.ref.system.SystemNode;
import com.kildeen.ref.system.SystemNodeResolver;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.apache.deltaspike.jsf.api.message.JsfMessage;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * <p>File created: 2014-04-26 20:32</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@ViewAccessScoped
@Named
public class UserSetupBean implements Serializable {

    @Inject
    private SystemNodeResolver systemNodeResolver;

    @Inject
    private UserService userService;

    @Inject
    private JsfMessage<Messages> msg;

    @Inject
    @Current
    private Locale locale;

    private DefaultTreeNode root;
    private List<TreeNode> selectedPermissionsList = new ArrayList<>();
    private TreeNode[] selectedPermissions;
    private User user = new User();
    private boolean editSelected;
    private long userId;
    private List<GroupDTO> groups;

    @Inject
    private GroupService groupService;

    public void init() {
        user = userService.fetchUser(userId);
        if (user == null) {
            user = new User();
        }
        groups = groupService.fetchGroups();

    }


    public DefaultTreeNode getRoot() {
        return root;
    }

    public List<TreeNode> getSelectedPermissionsList() {
        return selectedPermissionsList;
    }

    public void setSelectedPermissionsList(List<TreeNode> selectedPermissionsList) {
        this.selectedPermissionsList = selectedPermissionsList;
    }

    public void saveUser() {

        List<Permission> permissions = new ArrayList<>(selectedPermissionsList.size());
        for (TreeNode node : selectedPermissions) {
            permissions.add((Permission) node.getData());
        }

        msg.addInfo().entityCreated(User.class.getSimpleName(), user.getName());

    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }


    public String getText(Permission permission) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        return bundle.getString(permission.getName());
    }

    public TreeNode[] getSelectedPermissions() {
        return selectedPermissions;
    }

    public void setSelectedPermissions(TreeNode[] selectedPermissions) {
        this.selectedPermissions = selectedPermissions;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(final long userId) {
        this.userId = userId;
    }

    public List<GroupDTO> getGroups() {
        return groups;
    }

    public void setGroups(final List<GroupDTO> groups) {
        this.groups = groups;
    }
}
