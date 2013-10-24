package com.rstyle.core.storage.functional;

import com.rstyle.core.annotation.DatabaseSessionRequired;
import com.rstyle.core.storage.api.db.dao.TestDao;
import com.rstyle.storage.api.StorageException;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashMap;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    @Transactional
    @DatabaseSessionRequired
    public void findDocument() throws IOException, StorageException {

        Assert.assertNotNull(testDao);

        HashMap <String, Object> map = new HashMap<>();
        map.put("i_str", "bla-bla-bla");
        map.put("o_result", null);
        testDao.test(map);

        String result = (String) map.get("o_result");

        Assert.assertNotNull(result);
    }

 }
