package com.ibrahimatay.beans;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
@Component
@Data
public class ApplicationScopeBean {
    private Integer value;
}
