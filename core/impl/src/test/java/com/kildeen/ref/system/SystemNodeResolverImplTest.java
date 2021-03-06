package com.kildeen.ref.system;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(CdiTestRunner.class)
public class SystemNodeResolverImplTest {

	@Inject
	private SystemNodeResolver systemNodeResolverImpl;
	
	@Test
	public void test() {
		assertNotNull(systemNodeResolverImpl);


        System.out.println(systemNodeResolverImpl.root());
        System.out.println(systemNodeResolverImpl.nodes());
    }
	
}
