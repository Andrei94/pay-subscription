package pay.subscription;

import io.micronaut.core.annotation.*;

@Introspected
public class PaySubscription {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

