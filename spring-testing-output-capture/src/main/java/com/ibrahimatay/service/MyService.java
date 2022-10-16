package com.ibrahimatay.service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MyService {
    Logger logger = LoggerFactory.getLogger(MyService.class);

    public void logMessage(String message) {
        logger.info(message);
    }
}
