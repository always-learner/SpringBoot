package com.sscodes.repositories;

import com.sscodes.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for book which will provide suport for basic crud operation
 *
 * Created by sam on 8/6/18.
 */

public interface BookRepository extends CrudRepository<Book, Long>{
}
