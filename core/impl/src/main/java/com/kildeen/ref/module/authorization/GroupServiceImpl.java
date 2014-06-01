package com.kildeen.ref.module.authorization;

import com.kildeen.ref.system.SystemNodeResolver;

import javax.cache.annotation.CacheDefaults;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.List;

import static javax.ejb.ConcurrencyManagementType.BEAN;

/**
 * <p>File created: 2014-04-30 22:38</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@CacheDefaults(cacheName = "groupCache")
@Singleton
@ConcurrencyManagement(BEAN)
public class GroupServiceImpl implements GroupService {

    @Inject
    private GroupRepository groupRepository;

    @Override
    public List<GroupDTO> fetchAll() {
        return groupRepository.findAll();
    }

    @Override
    public GroupDTO fetchGroup(final long id) {
        return groupRepository.findBy(id);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public GroupDTO save(GroupDTO groupDTO) {
        return groupRepository.saveAndFlush(groupDTO);
    }

    @Override
    public GroupDTO fetchByName(final String name) {
        return groupRepository.findOptionalByNameEqual(name);
    }
}