package annotation;

import org.springframework.context.annotation.Profile;

@Profile("prod")
public @interface ProdProfile {
}
