package com.rstyle.core.info.storage.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rstyle.core.info.storage.rest.intf.TransactionBo;
import com.rstyle.core.info.storage.rest.data.RestDocument;
import com.rstyle.core.storage.api.db.dao.TestDao;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wordnik.swagger.annotations.Api;
import org.junit.Assert;

import java.util.HashMap;

@Component
@Path("documents")
@Api("/documents")
@Produces({MediaType.APPLICATION_JSON})
public class RESTStorageService {

    @Autowired
    TransactionBo transactionBo;

    @Autowired
    private TestDao testDao;

    @GET
    @Path("/mkyong")
    @ApiOperation(value = "Swagger Example",
            responseClass = "com.rstyle.core.info.storage.rest.data.RestDocument")
    public Response savePayment() {

        Assert.assertNotNull(testDao);

        // begin DB module calling

        HashMap<String, Object> map = new HashMap<>();
        map.put("i_str", "bla-bla-bla");
        map.put("o_result", null);
        testDao.test(map);

        String outcome = (String) map.get("o_result");

        Assert.assertNotNull(outcome);

        // end DB module calling

        RestDocument result = transactionBo.save(outcome);

        return Response.status(200).entity(result).build();

    }

}
