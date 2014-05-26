package com.kildeen.ref.application;

import com.kildeen.ref.application.module.authorization.GroupDTO;
import com.kildeen.ref.application.module.fact.FactDTO;
import com.kildeen.ref.domain.Permission;
import com.kildeen.ref.domain.User;
import com.kildeen.ref.system.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
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
    private SystemNodeResolver systemNodeResolver;

    private void boot(@Observes WebStartupEvent event) {
        System.out.println("Booted db");
    }

    @PostConstruct
    public void setupDatabase() {
        createPermissions();
        createUsers();
        createGroups();
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
        u2.setId(id++);
        u2.setName("Ann");
        allUsers.add(u2);


        User u3 = new User();
        u3.setId(id++);
        u3.setName("Thomas");
        allUsers.add(u3);


        User u4 = new User();
        u4.setId(id++);
        u4.setName("Louise");
        allUsers.add(u4);

    }

    private void createGroups() {

        g_admin_group_user.setPermissions(p_admin_group_user);
        g_admin_group_user.setName("Access Admin");
        g_admin_group_user.setLatestAddedUser(allUsers.get(0));
        g_admin_group_user.setUsers(allUsers);
        allGroups.add(g_admin_group_user);
    }

    private void createPermissions() {
        for (SystemNode node : systemNodeResolver.nodes()) {
            Permission p = new Permission(node.getDefinition());
            p.setId(id++);
            ((SystemNodeImpl) node).setPermission(p);

            // Admin group for system Access
                p_admin_group_user.add(p);

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
