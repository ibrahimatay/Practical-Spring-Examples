package com.ibrahimatay.metrics.store;

import java.util.Optional;

public interface StorageMetric {
    int store(String content);
    Optional<String> fetch(int id);
}
