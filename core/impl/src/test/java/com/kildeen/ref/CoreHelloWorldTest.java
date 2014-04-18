package com.kildeen.ref;

import com.kildeen.ref.domain.Book;
import com.kildeen.ref.application.BookService;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.*;
import org.junit.runner.RunWith;

import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * <p>File created: 2014-04-18 14:42</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@RunWith(CdiTestRunner.class)
public class CoreHelloWorldTest {
    private static EJBContainer ejbContainer;
    @BeforeClass
    public  static void  setup() {
        ejbContainer = EJBContainer.createEJBContainer();
    }


    @Inject
    private BookService bookService;


    @Inject
    private CoreHelloWorld coreHelloWorld;

    @Test
    public void testGetHelloWorld() throws Exception {
        assertEquals(coreHelloWorld.getHelloWorld(), "hello");
        bookService.addBook(new Book());
        assertNotNull(bookService.getAllBooks().get(0));
    }

}
