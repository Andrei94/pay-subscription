package pay.subscription;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class PaySubscriptionFunctionTest {

    @Inject
    PaySubscriptionClient client;

    @Test
    public void testFunction() throws Exception {
    	PaySubscription body = new PaySubscription();
    	body.setName("pay-subscription");
        assertEquals("pay-subscription", client.apply(body).blockingGet().getName());
    }
}
