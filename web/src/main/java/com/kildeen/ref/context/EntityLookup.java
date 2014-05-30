package com.kildeen.ref.context;

import com.kildeen.ref.domain.BaseEntity;
import org.apache.deltaspike.core.api.provider.BeanProvider;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>File created: 2014-05-29 15:13</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@ApplicationScoped
public class EntityLookup {
    private Set<Class<? extends BaseEntity>>  entityClasses = new HashSet<>();
    private List<BaseEntity> entities;
    @PostConstruct
    private void lookupEntities() {

        entities = BeanProvider.getContextualReferences(BaseEntity.class, false);
        for (BaseEntity o : entities) {
            entityClasses.add(o.getClass());
        }
    }

    public Set<Class<? extends BaseEntity>> getEntityClasses() {
        return entityClasses;
    }

    public void setEntityClasses(final Set<Class<? extends BaseEntity>> entityClasses) {
        this.entityClasses = entityClasses;
    }

    public List<BaseEntity> getEntities() {
        return entities;
    }

    public void setEntities(final List<BaseEntity> entities) {
        this.entities = entities;
    }
}
