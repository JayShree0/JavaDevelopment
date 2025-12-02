package com.cfs.BookAPI.controller;


import com.cfs.BookAPI.entity.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/books") // base url for every url..
public class BookController {

    private Map<Long, Book> bookDB = new HashMap<>();
}
