package com.kildeen.ref.application;

import com.kildeen.ref.application.module.fact.BaseAuditDTO;
import com.kildeen.ref.application.module.fact.BaseDTO;
import com.kildeen.ref.domain.BaseAuditEntity;
import com.kildeen.ref.domain.BaseEntity;

/**
 * <p>File created: 2014-05-03 11:28</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class MapperUtil {


    public static void toEntity(BaseEntity entity, BaseDTO dto) {
        if (dto.getId() == 0) {
            return;
        }
        entity.setId(dto.getId());
        if (dto.getVersion() != entity.getVersion()) {
            entity.setVersion(dto.getVersion());

        }
    }

    public static void toAuditEntity(BaseAuditEntity entity, BaseAuditDTO dto) {
        toEntity(entity, dto);
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setRevision(dto.getRevision());
        entity.setCreatedBy(dto.getCreatedBy());
    }

    public static void toDTO(BaseDTO dto, BaseEntity entity) {
        dto.setId(entity.getId());
        dto.setVersion(entity.getVersion());
    }

    public static void toAuditDTO(BaseAuditDTO dto, BaseAuditEntity entity) {
        toDTO(dto, entity);
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setRevision(entity.getRevision());
        dto.setCreatedBy(entity.getCreatedBy());
    }


}