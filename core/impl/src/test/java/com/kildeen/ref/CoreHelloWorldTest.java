package com.kildeen.ref;

import com.kildeen.ref.domain.Book;
import com.kildeen.ref.application.BookService;
import com.kildeen.ref.persistence.BookRepository;
import com.kildeen.ref.testutil.CDIRunner;
import com.kildeen.ref.testutil.EJBRunner;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.apache.openejb.junit.jee.config.Properties;
import org.junit.*;
import org.junit.runner.RunWith;

import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * <p>File created: 2014-04-18 14:42</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@RunWith(CDIRunner.class)
@Properties
public class CoreHelloWorldTest {
    private static EJBContainer ejbContainer;

    @Inject
    private BookService bookService;

    @Inject
    private BookRepository bookRepository;

    @org.apache.openejb.junit.jee.resources.TestResource
    private java.util.Properties props;

    @Inject
    private CoreHelloWorld coreHelloWorld;


    public void testGetHelloWorld() throws Exception {
        assertEquals(coreHelloWorld.getHelloWorld(), "hello");
        bookRepository.save(new Book());

    }

}
