
package com.kildeen.ref.module.authorization;

import com.kildeen.ref.domain.Group;
import com.kildeen.ref.domain.Permission;
import com.kildeen.ref.system.Current;
import com.kildeen.ref.system.SystemNode;
import com.kildeen.ref.system.SystemNodeResolver;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.apache.deltaspike.jsf.api.message.JsfMessage;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * <p>File created: 2014-04-26 20:32</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@ViewAccessScoped
@Named
public class GroupSetupBean implements Serializable {

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
    private long groupId;


    public void init() {
        groupDTO = groupService.fetchGroup(groupId);
        if (groupDTO == null) {
            groupDTO = new GroupDTO();
        }
        createPermissionTree();
    }

    private void createPermissionTree() {
        root = new DefaultTreeNode("Root", null);

        for (SystemNode node : systemNodeResolver.root()) {
            addChildren(node, root);
        }

    }

    private void addChildren(final SystemNode node, TreeNode parent) {
        TreeNode treeNode = new DefaultTreeNode(node.getPermission(), parent);
        if (groupDTO.getId() != 0 && groupDTO.getPermissions() != null) {
            for (Permission p : groupDTO.getPermissions()) {
                if (p.getName().equals(node.getPermissionName())) {
                    treeNode.setSelected(true);
                    break;
                }
            }

        }

        for (SystemNode child : node.children()) {
            addChildren(child, treeNode);
        }
    }

    public DefaultTreeNode getRoot() {
        return root;
    }

    public void saveGroup() {

        List<Permission> permissions = new ArrayList<>(selectedPermissionsList.size());
        for (TreeNode node : selectedPermissions) {
            permissions.add((Permission) node.getData());
        }
        groupDTO.setPermissions(permissions);
        groupService.save(groupDTO);

        msg.addInfo().entityCreated(Group.class.getSimpleName(), groupDTO.getName());

    }

    public GroupDTO getGroupDTO() {
        return groupDTO;
    }

    public void setGroupDTO(final GroupDTO groupDTO) {
        this.groupDTO = groupDTO;
    }

    public TreeNode[] getSelectedPermissions() {
        return selectedPermissions;
    }

    public void setSelectedPermissions(TreeNode[] selectedPermissions) {
        this.selectedPermissions = selectedPermissions;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(final long groupId) {
        this.groupId = groupId;
    }
}
