package com.kildeen.ref.application;

import com.kildeen.ref.domain.BaseEntity;

import javax.ejb.ApplicationException;

/**
 * <p>File created: 2014-05-14 20:06</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@ApplicationException(rollback = true)
public class RollBackException extends RuntimeException {

    public enum Cause {
        OptimisticLock
    }


    private BaseEntity entity;
    private Cause cause;

    public RollBackException() {
    }

    public RollBackException(final BaseEntity entity, final Cause cause) {
        this.entity = entity;
        this.cause = cause;
    }
}
