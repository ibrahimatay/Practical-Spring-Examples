package com.ibrahimatay.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class SystemHaltedHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        return Health.status("system-halted").build();
    }
}
