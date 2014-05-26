package com.kildeen.ref.permission;

import com.kildeen.ref.application.module.authorization.GroupDTO;
import com.kildeen.ref.application.module.authorization.GroupService;
import com.kildeen.ref.domain.Permission;
import com.kildeen.ref.system.*;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.core.api.config.view.controller.PreRenderView;
import org.apache.deltaspike.jsf.api.message.JsfMessage;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import static com.kildeen.ref.system.Pages.Admin.Group.GroupSetup;

/**
 * <p>File created: 2014-04-26 20:32</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Model
public class GroupBean {

    @Inject
    private SystemNodeResolver systemNodeResolver;

    @Inject
    private GroupService groupService;

    @Inject
    private JsfMessage<Messages> msg;

    @Inject
    @Current
    private Locale locale;

    @Inject
    Event<GroupDTO> event;

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

    private void fetchGroups() {
        groups = groupService.fetchGroups();
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

    public Class<? extends ViewConfig> edit(GroupDTO groupDTO) {
        event.fire(groupDTO);
        return GroupSetup.class;
    }

    public String getOutcome() {
        return Pages.Admin.Group.GroupSetup.class.toString();
    }
}
