package com.kildeen.ref.system;

import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.jsf.api.config.view.View;

import javax.inject.Named;

/**
 * <p>File created: 2014-04-30 22:01</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public interface Pages extends ViewConfig, SecuredPages {

    public interface Content extends ViewConfig {

        public class FactSetup implements ViewConfig {

        }

        public class FactOverview implements ViewConfig {

        }

        public class LatestFact implements ViewConfig {}
    }

    public interface Admin extends ViewConfig {

        public interface User {

            public class UserSetup implements ViewConfig {

            }

            public class UserOverview implements ViewConfig {

            }
        }

        public interface Group {

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
