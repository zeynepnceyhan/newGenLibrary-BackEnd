package com.swe.newGenLibrary;

import com.swe.newGenLibrary.API.controllers.BooksController;
import com.swe.newGenLibrary.business.abstracts.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BooksControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @InjectMocks
    private BooksController booksController;

    @Test
    public void testGetAll() throws Exception {
        when(bookService.getAll()).thenReturn("Your mocked result");

        mockMvc.perform(get("/api/books/getall")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string("Your mocked result"));
    }

    @Test
    public void testGetByPageNumber() throws Exception {
        int pageNumber = 2;
        when(bookService.getByPageNumber(pageNumber)).thenReturn("Your mocked result");

        mockMvc.perform(get("/api/books/getByPageNumber")
                .param("pageNumber", String.valueOf(pageNumber))
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string("Your mocked result"));
    }
}
