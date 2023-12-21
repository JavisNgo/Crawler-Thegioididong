package com.ducnt.crawlerthegioididong;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/thegioididong")
public class Controller {
    private final CrawlerService crawlerService;

    @GetMapping("")
    public ResponseEntity<?> crawl() {
        try {
            return ResponseEntity.ok(crawlerService.crawlerData());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }
}
