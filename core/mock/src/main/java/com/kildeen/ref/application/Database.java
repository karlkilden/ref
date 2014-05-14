package com.kildeen.ref.application;

import com.kildeen.ref.application.module.authorization.GroupDTO;
import com.kildeen.ref.application.module.fact.FactDTO;
import com.kildeen.ref.domain.Permission;
import com.kildeen.ref.domain.User;
import com.kildeen.ref.system.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.faces.event.PostConstructApplicationEvent;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>File created: 2014-05-10 15:00</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@ApplicationScoped
public class Database {

    private List<Permission> p_admin_group_user = new ArrayList<>();
    private GroupDTO g_admin_group_user = new GroupDTO();
    private List<GroupDTO> allGroups = new ArrayList<>();
    int id = 0;
    private ArrayList<User> allUsers = new ArrayList<>();
    private List<FactDTO> allFacts = new ArrayList<>();

    @Inject
    private SystemNodeResolverMock systemNodeResolver;

    private void boot(@Observes PostConstructApplicationEvent event) {
        System.out.println("Booted db");
    }

    @PostConstruct
    public void setupDatabase() {
        createPermissions();
        createGroups();
        createUsers();
        createFacts();
    }

    private void createFacts() {
        FactDTO f1 = new FactDTO();
        f1.setName("One plus one");
        f1.setContent("Equals 2");
        f1.setId(id++);

        allFacts.add(f1);

        FactDTO f2 = new FactDTO();
        f1.setName("two plus two");
        f1.setContent("Equals 4");
        f1.setId(id++);
        allFacts.add(f2);

        FactDTO f3 = new FactDTO();
        f1.setName("One plus two");
        f1.setContent("Equals 3");
        f1.setId(id++);
        allFacts.add(f3);


    }

    private void createUsers() {
        User u1 = new User();
        u1.setId(id++);
        u1.setName("Gustaf");
        u1.setGroupId(g_admin_group_user.getId());

        allUsers.add(u1);


        User u2 = new User();
        u1.setId(id++);
        u1.setName("Ann");


        User u3 = new User();
        u1.setId(id++);
        u1.setName("Thomas");


        User u4 = new User();
        u1.setId(id++);
        u1.setName("Louise");
    }

    private void createGroups() {

        g_admin_group_user.setPermissions(p_admin_group_user);
        g_admin_group_user.setName("Access Admin");
        allGroups.add(g_admin_group_user);
    }

    private void createPermissions() {
        for (SystemNode node : systemNodeResolver.nodes()) {
            Permission p = new Permission(systemNodeResolver.getText(node));
            p.setId(id++);
            ((SystemNodeImpl) node).setPermission(p);

            // Admin group for system Access
            if (node.getDefinition() == Pages.Admin.class ||
                    node.getDefinition() == Pages.Admin.User.CreateUser.class ||
                    node.getDefinition() == Pages.Admin.Group.CreateGroup.class) {
                p_admin_group_user.add(p);

            }
        }

    }

    public List<Permission> getP_admin_group_user() {
        return p_admin_group_user;
    }

    public GroupDTO getG_admin_group_user() {
        return g_admin_group_user;
    }

    public List<GroupDTO> getAllGroups() {
        return allGroups;
    }

    public void createGroup(final GroupDTO groupDTO) {
        groupDTO.setId(id++);
        allGroups.add(groupDTO);
    }

    public int getId() {
        return id;
    }

    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public List<FactDTO> getAllFacts() {
        return allFacts;
    }

}
