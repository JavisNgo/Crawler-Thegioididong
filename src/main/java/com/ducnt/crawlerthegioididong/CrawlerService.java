package com.ducnt.crawlerthegioididong;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CrawlerService {
    public Set<Product> crawlerData() throws IOException {
        Document document = Jsoup.connect("https://www.thegioididong.com/").get();
        Elements listElements = document.select("div.item a");
        Set<Product> result = listElements.stream()
                .map(element -> {
                    return Product.builder()
                            .id(element.attr("data-id"))
                            .name(element.attr("data-name"))
                            .brand(element.attr("data-brand"))
                            .price(Float.parseFloat(element.attr("data-price")))
                            .type(element.attr("data-cate"))
                            .build();
                })
                .filter(element -> !element.getId().isEmpty())
                .collect(Collectors.toSet());
        return result;
    }
}
