package com.kildeen.ref.permission;

//import com.kildeen.ref.application.Database;
import com.kildeen.ref.module.authorization.UserSetupBean;
import com.kildeen.ref.testutil.CDIRunner;
import org.junit.Ignore;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * <p>File created: 2014-05-28 22:16</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@RunWith(CDIRunner.class)
@Ignore // Something wrong with owb and webapps regarding beans.xml
public class UserSetupBeanTest {

    @Inject
    private UserSetupBean userSetupBean;

//    @Inject
//    Database database;
//
//    @Test
//    public void testSave() throws Exception {
//
//        UserDTO dto = new UserDTO();
//        dto.setGroup(database.getG_admin_group_user());
//        dto.setName("Hans");
//        userSetupBean.save();
//    }
}
