
package com.kildeen.ref.permission;

import com.kildeen.ref.application.module.authorization.GroupDTO;
import com.kildeen.ref.application.module.authorization.GroupService;
import com.kildeen.ref.domain.Permission;
import com.kildeen.ref.system.Current;
import com.kildeen.ref.system.SystemNode;
import com.kildeen.ref.system.SystemNodeResolver;
import org.apache.deltaspike.core.api.config.view.controller.PreRenderView;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.apache.deltaspike.jsf.api.message.JsfMessage;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.faces.bean.ViewScoped;
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
public class SetupGroupBean implements Serializable {

    @Inject
    private SystemNodeResolver systemNodeResolver;

    @Inject
    private GroupService groupService;

    @Inject
    private JsfMessage<Messages> msg;

    @Inject
    @Current
    private Locale locale;


    private DefaultTreeNode root;
    private List<TreeNode> selectedPermissionsList = new ArrayList<>();
    private TreeNode[] selectedPermissions;
    private GroupDTO groupDTO = new GroupDTO();
    private List<GroupDTO> groups;
    private GroupDTO selectedGroup;
    private GroupDataModel groupDataModel;
    private boolean editSelected;


    @PostConstruct
    private void init() {
        fetchGroups();
        groupDataModel = new GroupDataModel(groups);
    }

    public void receiveGroupToEdit(@Observes GroupDTO dto) {
        groupDTO = dto;
    }

    @PreRenderView()
    protected void createPermissionTree() {
        root = new DefaultTreeNode("Root", null);

        for (SystemNode node : systemNodeResolver.root()) {
            addChildren(node, root, editSelected);
        }
        if (editSelected) {
            selectedPermissions = selectedPermissionsList.toArray(new TreeNode[0]);
        }

    }

    private void fetchGroups() {
        groups = groupService.fetchGroups();
    }

    private void addChildren(final SystemNode node, TreeNode parent, boolean customize) {
        TreeNode treeNode = new DefaultTreeNode(node.getPermission(), parent);
        if (customize) {
            for (Permission p : selectedGroup.getPermissions()) {
                if (p.getName().equals(node.getPermissionName())) {
                    selectedPermissionsList.add(treeNode);
                    break;
                }
            }
        }
        for (SystemNode child : node.children()) {
            addChildren(child, treeNode, customize);
        }
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

    public void createGroup() {

        List<Permission> permissions = new ArrayList<>(selectedPermissionsList.size());
        for (TreeNode node : selectedPermissions) {
            permissions.add((Permission) node.getData());
        }
        groupDTO.setPermissions(permissions);
        groupService.createGroup(groupDTO);

        msg.addInfo().groupCreated(groupDTO.getName());

    }

    public GroupDTO getGroupDTO() {
        return groupDTO;
    }

    public void setGroupDTO(final GroupDTO groupDTO) {
        this.groupDTO = groupDTO;
    }

    public List<GroupDTO> getGroups() {
        return groups;
    }

    public void update() {
        fetchGroups();
    }

    public void setSelectedGroup(GroupDTO selectedGroup) {
        this.selectedGroup = selectedGroup;
    }

    public GroupDTO getSelectedGroup() {
        return selectedGroup;
    }

    public GroupDataModel getGroupDataModel() {
        return groupDataModel;
    }

    public void setGroupDataModel(GroupDataModel groupDataModel) {
        this.groupDataModel = groupDataModel;
    }

    public String getText(Permission permission) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        return bundle.getString(permission.getName());
    }

    public void editSelected(ActionEvent event) {
        editSelected = true;
        selectedPermissionsList.clear();
        init();
        groupDTO = selectedGroup;
    }

    public TreeNode[] getSelectedPermissions() {
        return selectedPermissions;
    }

    public void setSelectedPermissions(TreeNode[] selectedPermissions) {
        this.selectedPermissions = selectedPermissions;
    }
}
