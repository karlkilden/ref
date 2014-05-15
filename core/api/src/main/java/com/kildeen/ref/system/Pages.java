package com.kildeen.ref.system;

import org.apache.deltaspike.core.api.config.view.ViewConfig;

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

            public class GroupSetup implements ViewConfig {
                public class Delete {

                }
            }


            public class Groups implements ViewConfig {
                public class Delete {

                }
            }
        }


    }


}
