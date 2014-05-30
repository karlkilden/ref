package com.kildeen.ref.application;

import com.kildeen.ref.domain.BaseEntity;

import javax.ejb.ApplicationException;
import javax.persistence.OptimisticLockException;

/**
 * <p>File created: 2014-05-14 20:06</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@ApplicationException(rollback = true)
public class RollBackException extends RuntimeException {


    private BaseEntity entity;

    public RollBackException(final BaseEntity entity, final OptimisticLockException e) {
        super(e);
    }


    public BaseEntity getEntity() {
        return entity;
    }

}
