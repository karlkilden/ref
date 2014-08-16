package com.kildeen.ref.system;

import com.kildeen.ref.module.authorization.GroupDTO;
import com.kildeen.ref.module.authorization.GroupService;
import com.kildeen.ref.module.authorization.PermissionService;
import com.kildeen.ref.module.authorization.UserDTO;
import com.kildeen.ref.module.user.UserService;

import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.Singleton;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.transaction.UserTransaction;

/**
 * <p>File created: 2014-05-30 14:58</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@TransactionManagement(TransactionManagementType.BEAN)
@Singleton
public class BasicSetupHandlerImpl implements BasicSetupHandler {

    public static final String ROOT = "root2";
    @Inject
    private UserService userService;

    @Inject
    private GroupService groupService;

    @Inject
    private PermissionService permissionService;

    @Resource
    private UserTransaction userTransaction;

    @Override
    public void boot() {
        try {
            GroupDTO superGroup = groupService.fetchByName(ROOT);

            if (superGroup == null) {
                userTransaction.begin();
                superGroup = new GroupDTO();
                superGroup.setPermissions(permissionService.fetchPermissions());
                superGroup.setName(ROOT);
                groupService.save(superGroup);
                userTransaction.commit();
            }


            UserDTO rootUser = userService.fetchByName(ROOT);
            if (rootUser == null) {
                return;

//                userTransaction.begin();
//                rootUser = new UserDTO();
//                rootUser.setName(ROOT);
//                rootUser.setGroup(groupService.fetchByName(ROOT));
//                userService.save(rootUser);
//                userTransaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
