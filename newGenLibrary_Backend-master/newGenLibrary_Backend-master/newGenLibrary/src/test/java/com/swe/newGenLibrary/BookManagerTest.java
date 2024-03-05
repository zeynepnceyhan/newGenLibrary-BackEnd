package com.swe.newGenLibrary;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.swe.newGenLibrary.business.concretes.BookManager;

@SpringBootTest
@AutoConfigureMockMvc
class BookManagerTest {
    
    @Test
    void testGetAll() {
        // Given
        BookManager bookManager = new BookManager();

        // When
        Object result = bookManager.getAll();

        // Then
        assertTrue(result instanceof String); // Assuming the result should be a String or you can modify accordingly

        // Log the result for inspection
        System.out.println(result);
    }

    @Test
    void testGetByPageNumber() {
        // Given
        BookManager bookManager = new BookManager();
        int pageNumber = 2; // Provide a valid page number for testing

        // When
        Object result = bookManager.getByPageNumber(pageNumber);

        // Then
        assertTrue(result instanceof String); // Assuming the result should be a String or you can modify accordingly

        // Log the result for inspection
        System.out.println(result);
    }
}
