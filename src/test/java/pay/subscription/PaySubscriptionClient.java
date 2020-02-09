package pay.subscription;

import io.micronaut.function.client.FunctionClient;
import io.micronaut.http.annotation.Body;
import io.reactivex.Single;
import javax.inject.Named;

@FunctionClient
public interface PaySubscriptionClient {

    @Named("pay-subscription")
    Single<PaySubscription> apply(@Body PaySubscription body);

}
