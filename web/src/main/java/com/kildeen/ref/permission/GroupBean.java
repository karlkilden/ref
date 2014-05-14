package com.kildeen.ref.permission;

import com.kildeen.ref.application.module.authorization.GroupDTO;
import com.kildeen.ref.application.module.authorization.GroupService;
import com.kildeen.ref.domain.Permission;
import com.kildeen.ref.system.SystemNode;
import com.kildeen.ref.system.SystemNodeResolver;
import org.apache.deltaspike.jsf.api.message.JsfMessage;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>File created: 2014-04-26 20:32</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@RequestScoped
@Named
public class GroupBean implements Serializable {

    @Inject
    private SystemNodeResolver systemNodeResolver;

    @Inject
    private GroupService groupService;

    @Inject
    private JsfMessage<Messages> msg;

    private DefaultTreeNode root;
    private TreeNode[] selectedPermissions;
    private GroupDTO groupDTO = new GroupDTO();
    private List<GroupDTO> groups;


    @PostConstruct
    private void createList() {

        root = new DefaultTreeNode("Root", null);

        for (SystemNode node : systemNodeResolver.root()) {
            addChildren(node, root);
        }
        groups = groupService.fetchGroups();
    }

    private void addChildren(final SystemNode node, TreeNode parent) {
        TreeNode treeNode = new DefaultTreeNode(node.getPermission(), parent);
        for (SystemNode child : node.children()) {
            addChildren(child, treeNode);
        }
    }

    public DefaultTreeNode getRoot() {
        return root;
    }

    public TreeNode[] getSelectedPermissions() {
        return selectedPermissions;
    }

    public void setSelectedPermissions(TreeNode[] selectedPermissions) {
        this.selectedPermissions = selectedPermissions;
    }

    public void createGroup() {

        List<Permission> permissions = new ArrayList<>(selectedPermissions.length);
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
}
