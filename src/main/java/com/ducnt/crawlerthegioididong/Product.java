package com.ducnt.crawlerthegioididong;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Product {
    private String id;
    private String name;
    private float price;
    private String brand;
    private String type;
}
