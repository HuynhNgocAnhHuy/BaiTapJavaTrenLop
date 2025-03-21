import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        String url = "https://alonhadat.com.vn/";
        String filePath = "alonhadat.csv";
        AtomicInteger count = new AtomicInteger(0);

        ExecutorService executor = Executors.newSingleThreadExecutor(); // Chỉ cần 1 thread cho 1 URL

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Tiêu đề,Giá,Diện tích,Địa chỉ\n");

            executor.submit(() -> {
                try {
                    Document doc = Jsoup.connect(url).get();
                    Elements listings = doc.select(".vip-property-box .vip-properties .item"); // Selector từ ảnh

                    for (Element listing : listings) {
                        String title = listing.select(".vip-text .vip-title a").text();
                        String price = listing.select(".vip-price").text();
                        String area = listing.select(".vip-kt label").text();
                        String address = listing.select(".vip-di").text();

                        synchronized (writer) {
                            writer.write(String.format("\"%s\",\"%s\",\"%s\",\"%s\"\n", title, price, area, address));
                        }
                        count.incrementAndGet();
                    }
                } catch (IOException e) {
                    System.err.println("Lỗi khi crawl dữ liệu từ " + url + ": " + e.getMessage());
                }
            });

            executor.shutdown();
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

            System.out.println("Đã crawl được " + count.get() + " bất động sản.");
        } catch (IOException | InterruptedException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}