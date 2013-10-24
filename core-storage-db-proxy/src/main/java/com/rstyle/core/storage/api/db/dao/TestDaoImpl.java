package com.rstyle.core.storage.api.db.dao;

import com.rstyle.core.storage.api.db.mapper.TestMapper;

import java.util.Map;

public class TestDaoImpl implements TestDao {

    private final TestMapper mapper;

    public TestDaoImpl(TestMapper mapper) {
        this. mapper = mapper;
    }

    @Override
    public void test(Map<String,Object> map) {
          mapper.test(map);
    }
}
