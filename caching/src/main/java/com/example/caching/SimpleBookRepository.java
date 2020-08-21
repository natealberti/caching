package com.example.caching;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepository implements BookRepository {

  @Override
  @Cacheable("books")
  public Book getByIsbn(final String isbn) {
      simulateSlowService();
      return new Book(isbn, "Some book");
  }

  // Don't do this at home
  private void simulateSlowService() {
      try {
          final long time = 3000L;
          Thread.sleep(time);
      } catch (final InterruptedException e) {
      throw new IllegalStateException(e);
    }
  }

}