package com.ibrahimatay.metrics.store;

import com.ibrahimatay.metrics.utils.StatisticsUtils;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class FileStorageMetric implements StorageMetric {
    private Counter counter;
    private AtomicLong averageObjectSize;
    private Map<Integer, String> fileStorage = new HashMap<>();

    public FileStorageMetric(MeterRegistry meterRegistry){
        counter =meterRegistry.counter("com.ibrahimatay.fileStore", "type", "file");
        averageObjectSize = meterRegistry.gauge("fileStore.avg.size", new AtomicLong());
    }

    @Override
    public int store(String content) {
        int newId = StatisticsUtils.maxId(fileStorage) + 1;
        fileStorage.put(newId, content);
        counter.increment();
        averageObjectSize.set(StatisticsUtils.averageContentSize(fileStorage));

        return newId;
    }

    @Override
    public Optional<String> fetch(int id) {
        return Optional.ofNullable(fileStorage.get(id));
    }
}
