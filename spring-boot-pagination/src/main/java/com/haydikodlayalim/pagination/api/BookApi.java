package com.haydikodlayalim.pagination.api;

import com.haydikodlayalim.pagination.model.Book;
import com.haydikodlayalim.pagination.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookApi {

    private final BookRepository bookRepository;

    // Console'da yazan H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:testdb'
    // h2-console -> http://localhost:8445/h2-console
    // http://localhost:8445/books?pageSize=5&currentPage=1
    // http://localhost:8445/books?pageSize=3&currentPage=1
    @GetMapping
    public Page<Book> pagination(@RequestParam Integer pageSize,
                                 @RequestParam Integer currentPage) {
        Pageable pageable = PageRequest.of(currentPage,pageSize);

        return (Page<Book>) bookRepository.findAll(pageable);
    }
    // http://localhost:8445/books/p?size=3&page=1
    // http://localhost:8445/books/p?pageSize=3&currentPage=1&sort=id
    // http://localhost:8445/books/p?pageSize=3&currentPage=1 -> Default değerleri alır
    @GetMapping("/p")
    public Page<Book> pagination(Pageable pageable) {
        //totalElements count query çalıştırır.
        return (Page<Book>) bookRepository.findAll(pageable);
    }

    // http://localhost:8445/books/s?size=3&page=1&sort=id
    @GetMapping("/s")
    public Slice<Book> slice(Pageable pageable) {
        return (Slice<Book>) bookRepository.findAll(pageable);
    }
}
