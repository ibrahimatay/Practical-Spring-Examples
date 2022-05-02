package com.ibrahimatay.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "server")
@Getter
@Setter
@ToString
public class ServerConfiguration {
    private String name;
    private String type;
    private String url;
}
