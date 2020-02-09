package pay.subscription;

import io.micronaut.function.executor.FunctionInitializer;
import io.micronaut.function.FunctionBean;
import javax.inject.*;
import java.io.IOException;
import java.util.function.Function;

@FunctionBean("pay-subscription")
public class PaySubscriptionFunction extends FunctionInitializer implements Function<PaySubscription, PaySubscription> {

    @Override
    public PaySubscription apply(PaySubscription msg) {
         return msg;
    }

    /**
     * This main method allows running the function as a CLI application using: echo '{}' | java -jar function.jar 
     * where the argument to echo is the JSON to be parsed.
     */
    public static void main(String...args) throws IOException {
        PaySubscriptionFunction function = new PaySubscriptionFunction();
        function.run(args, (context)-> function.apply(context.get(PaySubscription.class)));
    }    
}

