package com.example.demo;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BookService bookService) {
        return args -> {
            Book book = new Book();
            book.setTitle("The Great Gatsby");
            book.setAuthor("F. Scott Fitzgerald");
            book.setPrice(BigDecimal.valueOf(250));
            book.setIsbn("9780743273565");

            bookService.save(book);
            System.out.println("All books in DB: " + bookService.findAll());
        };
    }
}
