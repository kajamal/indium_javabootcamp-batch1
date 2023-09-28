package com.labs.java.stream;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductStats {
    public static void main(String[] args) {
        Product product1 = new Product(1,"oppof9","moblie","india",70000.0);
        Product product2 = new Product(2,"Apple","moblie","india",85000.0);
        Product product3 = new Product(3,"samsung","moblie","india",65000.0);
        Product product4 = new Product(4,"LG","LED-TV","india",700000.0);



        List<Product> products = List.of(product1,product2,product3,product4);


      long count=products.stream()
                .filter(p ->p.getPrice()> 70000.0)
                .count();
      System.out.println("No of Product Whose Price more than 70k"+count);
        Map<String,Long> countByCategory = products.stream()
                .collect(Collectors.groupingBy(Product :: getCategory , Collectors.counting()));
        System.out.println(countByCategory);

        List<Integer> productsIds = products.stream()
                .filter(p -> p.getCategory()=="LED-TV")
                .map(p -> p.getId())
                .collect(Collectors.toList());

        System.out.println("ids of products categore as LED-TV "+productsIds);

        // 4. Product Stats - Min, Max, Total and Average price
        DoubleSummaryStatistics stats = products.stream()
                .map(p -> p.getPrice())
                .mapToDouble(x -> x)
                .summaryStatistics();

        System.out.println("Minimum Product Price - " + stats.getMin());
        System.out.println("Maximum Product Price - " + stats.getMax());
        System.out.println("Total Product Price - " + stats.getSum());
        System.out.println("Avg Product Price - " + stats.getAverage());
    }


}

