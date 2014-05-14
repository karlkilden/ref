package com.kildeen.ref.system;

import org.apache.deltaspike.core.api.config.view.ViewConfig;

/**
 * <p>File created: 2014-05-03 00:20</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public interface InvalidLeaf {
    public interface Admin extends ViewConfig {

        public class CreateUser implements ViewConfig {
            public class Leaf {
                public class ActualInvalidLeaf {

                }
            }
        }
    }
}
