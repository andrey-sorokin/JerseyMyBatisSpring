package com.rstyle.core.info.storage.rest.bean;

import com.rstyle.core.info.storage.rest.intf.TransactionBo;
import com.rstyle.core.info.storage.rest.data.RestDocument;

public class TransactionBoImpl implements TransactionBo {

    public RestDocument save(String par) {

        return  new RestDocument("Parameter received: " + par);

    }

}