package com.kildeen.ref.navigation;

import com.kildeen.ref.domain.Permission;
import com.kildeen.ref.module.authorization.GroupDTO;
import com.kildeen.ref.module.authorization.GroupService;
import com.kildeen.ref.module.authorization.GroupSetupBean;
import com.kildeen.ref.system.SystemNode;
import com.kildeen.ref.system.SystemNodeImpl;
import com.kildeen.ref.system.SystemNodeResolver;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * <p>File created: 2014-06-07 11:00</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class GroupSetupBeanTest {
    @InjectMocks
    GroupSetupBean groupSetupBean;
    @Mock
    SystemNodeResolver systemNodeResolver;

    @Mock
    GroupService groupService;

    @Test
    public void test_that_leafs_are_mapped() {

     SystemNode node = mock(SystemNode.class);
        SystemNode child = mock(SystemNode.class);
        SystemNode grandChild = mock(SystemNode.class);

        when(node.getNodeName()).thenReturn("parent");
        when(child.getNodeName()).thenReturn("child");
        when(grandChild.getNodeName()).thenReturn("grandChild");

        Permission p = new Permission();
        p.setId(1);
        when(grandChild.getPermission()).thenReturn(p);

        when(node.children()).thenReturn(Arrays.asList(child));

        when(child.children()).thenReturn(Arrays.asList(grandChild));

        when(systemNodeResolver.root()).thenReturn(Arrays.asList(node));

        when(groupService.fetchGroup(0)).thenReturn(new GroupDTO());

        groupSetupBean.init();


        Assert.assertTrue(groupSetupBean.getRoot().getChildren().size() == 1);
        Assert.assertTrue(groupSetupBean.getRoot().getChildren().get(0).getChildren().size() == 1);
        Assert.assertTrue(groupSetupBean.getRoot().getChildren().get(0).getChildren().get(0).getChildren().get(0).getData().equals(p));

    }
}
