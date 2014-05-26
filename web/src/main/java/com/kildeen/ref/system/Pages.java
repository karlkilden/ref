package com.kildeen.ref.system;

import com.kildeen.ref.permission.GroupSetupBean;
import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.core.api.config.view.controller.ViewControllerRef;
import org.apache.deltaspike.jsf.api.config.view.View;

/**
 * <p>File created: 2014-04-30 22:01</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public interface Pages extends ViewConfig {


    public interface Admin extends ViewConfig {

        public interface User {

            public class CreateUser implements ViewConfig {
                public class Delete {

                }
            }
        }

        public interface Group {

            @ViewControllerRef(GroupSetupBean.class)
            @View(navigation = View.NavigationMode.REDIRECT)
            public class GroupSetup implements ViewConfig {
                public class Delete {

                }
            }

            public class GroupOverview implements ViewConfig {
            }
        }

    }


}
