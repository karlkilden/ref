package com.kildeen.ref.module.authorization;

import com.kildeen.ref.domain.BaseEntity;
import com.kildeen.ref.module.fact.BaseDTO;
import com.kildeen.ref.module.fact.FactDTO;
import org.apache.deltaspike.data.api.mapping.QueryInOutMapper;
import org.apache.deltaspike.data.api.mapping.SimpleQueryInOutMapperBase;
import org.apache.deltaspike.data.spi.QueryInvocationContext;

import javax.inject.Inject;

/**
 * <p>File created: 2014-06-26 21:44</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public abstract class BaseMapper<Entity extends BaseEntity, Dto extends BaseDTO> extends SimpleQueryInOutMapperBase<Entity, Dto> {

        public Entity fetch(Entity entity, Dto dto) {
            Entity foundEntity;
            if (dto.getId() != 0) {

                if (entity == null || dto.getId() == entity.getId()) {
                    foundEntity = entity;
                } else {
                    foundEntity = this.findEntity(dto.getId());
                }
            } else {
                foundEntity = this.newEntity();
            }
            return this.toEntity(foundEntity, dto);
        }

}
