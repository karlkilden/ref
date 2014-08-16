package com.kildeen.ref.module.fact;

import com.kildeen.ref.testutil.EJBRunner;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import java.util.Properties;

/**
 * <p>File created: 2014-05-31 01:15</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@RunWith(CdiTestRunner.class)
public class FactBatchTest {

    @Test

    public void test() {

        final JobOperator jobOperator = BatchRuntime.getJobOperator();
        jobOperator.start("customerimport", new Properties());
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
