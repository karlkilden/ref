package com.kildeen.ref.application.module.authorization;

import com.kildeen.ref.domain.Permission;
import com.kildeen.ref.system.SystemNodeResolver;

import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheResult;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.Singleton;
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

    @Inject
    private SystemNodeResolver systemNodeResolver;

    @Override
    public List<GroupDTO> fetchGroups() {
        return groupRepository.findAll();
    }

    @Override
    public GroupDTO fetchGroup(final long id) {
        return groupRepository.findBy(id);
    }

    @Override
    public GroupDTO createGroup(GroupDTO groupDTO) {
        return groupRepository.saveAndFlush(groupDTO);
    }
}