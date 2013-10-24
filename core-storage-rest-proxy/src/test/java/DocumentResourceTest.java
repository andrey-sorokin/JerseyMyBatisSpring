import com.rstyle.core.info.storage.rest.data.RestDocument;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import com.sun.jersey.test.framework.spi.container.TestContainer;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@FixMethodOrder(MethodSorters.JVM)
public class DocumentResourceTest extends JerseyTest {

    private static final Logger LOG = LoggerFactory.getLogger(DocumentResourceTest.class);


    public DocumentResourceTest() {
        super(new WebAppDescriptor.Builder("com.rstyle.core.info.storage.rest")
                .contextListenerClass(ContextLoaderListener.class)
                .contextParam("contextConfigLocation", "classpath*:app-context.xml")
                .servletClass(SpringServlet.class).initParam("com.sun.jersey.api.json.POJOMappingFeature", "true")
                .build());
    }

    @Override
    protected Client getClient(TestContainer tc, AppDescriptor ad) {
        ad.getClientConfig().getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        return super.getClient(tc, ad);
    }

    @Test
    public void testDocument() {
        RestDocument response = resource().path("documents/" + "mkyong").accept("application/json")
                .get(RestDocument.class);
        LOG.info(response.toString());
    }

}
