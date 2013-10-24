package com.rstyle.core.info.storage.rest.data;

import java.util.List;

import com.google.common.base.Objects;
import com.wordnik.swagger.annotations.ApiClass;
import com.wordnik.swagger.annotations.ApiProperty;

@ApiClass("Document")
public class RestDocument {

    @ApiProperty(value = "document id", required = true)
    private String id;

    public RestDocument() {
    }

    public RestDocument(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        RestDocument that = (RestDocument) o;
        return Objects.equal(this.id, that.id);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("id", getId()).toString();
    }
}
