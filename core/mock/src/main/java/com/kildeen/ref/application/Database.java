package com.kildeen.ref.application;

import com.kildeen.ref.module.authorization.GroupDTO;
import com.kildeen.ref.module.authorization.UserDTO;
import com.kildeen.ref.module.fact.FactDTO;
import com.kildeen.ref.domain.Permission;
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

    private List<Permission> allPermissions = new ArrayList<>();
    private GroupDTO superGroup = new GroupDTO();
    private List<GroupDTO> allGroups = new ArrayList<>();
    int id = 0;
    private ArrayList<UserDTO> allUsers = new ArrayList<>();
    private UserDTO superUser;

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
        UserDTO u1 = new UserDTO();
        u1.setId(id++);
        u1.setName("Gustaf");
        u1.setEmail("test@test.se");
        u1.setGroup(superGroup);
        superUser= u1;
        allUsers.add(u1);


        UserDTO u2 = new UserDTO();
        u2.setId(id++);
        u2.setName("Ann");
        allUsers.add(u2);


        UserDTO u3 = new UserDTO();
        u3.setId(id++);
        u3.setName("Thomas");
        allUsers.add(u3);


        UserDTO u4 = new UserDTO();
        u4.setId(id++);
        u4.setName("Louise");
        allUsers.add(u4);

    }

    private void createGroups() {

        superGroup.setPermissions(allPermissions);
        superGroup.setName("Access Admin");
        superGroup.setLatestAddedUser(allUsers.get(0));
        superGroup.setUsers(allUsers);
        superGroup.setId(444L);
        allGroups.add(superGroup);
    }

    private void createPermissions() {
        for (SystemNode node : systemNodeResolver.nodes()) {
            Permission p = new Permission(node.getDefinition());
            p.setId(id++);
            ((SystemNodeImpl) node).setPermission(p);

            // Admin group for system Access
                allPermissions.add(p);

        }

    }

    public List<Permission> getAllPermissions() {
        return allPermissions;
    }

    public GroupDTO getSuperGroup() {
        return superGroup;
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

    public ArrayList<UserDTO> getAllUsers() {
        return allUsers;
    }

    public List<FactDTO> getAllFacts() {
        return allFacts;
    }

    public UserDTO getSuperUser() {
        return superUser;
    }
}
