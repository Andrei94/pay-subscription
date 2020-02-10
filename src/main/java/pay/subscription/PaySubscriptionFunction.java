package pay.subscription;

import com.braintreegateway.*;
import io.micronaut.function.executor.FunctionInitializer;
import io.micronaut.function.FunctionBean;

import java.io.File;
import java.io.IOException;
import java.util.function.Function;

@FunctionBean("pay-subscription")
public class PaySubscriptionFunction extends FunctionInitializer implements Function<PaySubscription, Boolean> {
    private static BraintreeGateway gateway = Application.gateway;

    @Override
    public Boolean apply(PaySubscription msg) {
        PaymentMethodRequest paymentMethodRequest = new PaymentMethodRequest().customerId(msg.getCustomerId()).paymentMethodNonce(msg.getPaymentNonce());
        Result<? extends PaymentMethod> paymentMethod = gateway.paymentMethod().create(paymentMethodRequest);
        Result<Subscription> subscriptionResult = gateway.subscription().create(new SubscriptionRequest()
                .planId(msg.getPlanId())
                .paymentMethodToken(paymentMethod.getTarget().getToken()));
        return subscriptionResult.isSuccess();
    }

    /**
     * This main method allows running the function as a CLI application using: echo '{}' | java -jar function.jar 
     * where the argument to echo is the JSON to be parsed.
     */
    public static void main(String...args) throws IOException {
        File file = new File("gateway.properties");
        if(file.exists())
            gateway = BraintreeGatewayFactory.fromConfigFile(file);
        else
            gateway = BraintreeGatewayFactory.fromConfigMapping(System.getenv());
        PaySubscriptionFunction function = new PaySubscriptionFunction();
        function.run(args, (context)-> function.apply(context.get(PaySubscription.class)));
    }    
}

