package com.kildeen.ref.system;

import org.apache.deltaspike.jpa.api.transaction.Transactional;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Stereotype;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <p>File created: 2014-05-18 15:03</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */

@Stereotype
@ApplicationScoped
@Transactional
@Target({java.lang.annotation.ElementType.TYPE})
@Retention(RUNTIME)
public @interface ServiceFacade {

}
