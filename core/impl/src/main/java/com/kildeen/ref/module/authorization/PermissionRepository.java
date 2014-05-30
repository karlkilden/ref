package com.kildeen.ref.module.authorization;

import com.kildeen.ref.domain.Permission;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

/**
 * <p>File created: 2014-04-22 22:22</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Repository
public interface PermissionRepository extends EntityRepository<Permission, Long> {

    public Permission findOptionalByNameEqual(String name);

}
