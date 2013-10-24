package com.rstyle.core.storage.functional;

import com.rstyle.storage.api.StorageException;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring/application-context-db-proxy.xml"})
@TransactionConfiguration(defaultRollback = false)

public class Test {
    @Autowired
    private TestService testService;

    @org.junit.Test
    public void findDocument() throws IOException, StorageException {
        Assert.assertNotNull(testService);
        testService.findDocument();
    }

}
