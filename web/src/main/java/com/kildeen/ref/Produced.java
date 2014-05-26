package com.kildeen.ref;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <p>File created: 2014-01-05 13:39</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Qualifier
@Target({TYPE})
@Retention(RUNTIME)
public @interface Produced {
}
