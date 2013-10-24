package com.rstyle.core.storage.functional;

import java.io.IOException;

import com.rstyle.storage.api.StorageException;


public interface TestService {
    void findDocument() throws IOException, StorageException;
}
