package com.kildeen.ref.module.authorization;

import com.kildeen.ref.domain.Permission;
import com.kildeen.ref.system.*;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.jsf.api.message.JsfMessage;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
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

    private List<GroupDTO> groups;
    private GroupDTO selectedGroup;
    private GroupDataModel groupDataModel;

    @PostConstruct
    private void init() {
        fetchGroups();
        groupDataModel = new GroupDataModel(groups);
    }

    private void fetchGroups() {
        groups = groupService.fetchAll();
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


    public String getOutcome() {
        return Pages.Admin.Group.GroupSetup.class.toString();
    }
}
