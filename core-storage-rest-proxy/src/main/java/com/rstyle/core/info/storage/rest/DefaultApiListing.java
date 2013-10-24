package com.rstyle.core.info.storage.rest;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.jersey.listing.ApiListing;

@Path("/api-docs")
@Api("/api-docs")
@Produces({"application/json"})
public class DefaultApiListing extends ApiListing {
}
