package com.ibrahimatay.web;

import com.ibrahimatay.metrics.store.FileStorageMetric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MetricController {
    @Autowired
    private FileStorageMetric fileStorageMetric;

    @GetMapping("file/storage/{id}")
    public ResponseEntity<String> fetchFromFile(@PathVariable int id) {
        return fileStorageMetric.fetch(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("file/storage")
    public int storeInFile(@RequestBody String content) {
        return fileStorageMetric.store(content);
    }
}
