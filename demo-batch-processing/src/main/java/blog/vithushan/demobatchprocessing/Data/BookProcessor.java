/*
 * File: BookProcessor.java
 * Project: Data
 * File Created: Saturday, 22nd May 2021 2:11:00 pm
 * Author: Vithushan Sylvester (msvithushan@gmail.com)
 * -----
 * Last Modified: Saturday, 22nd May 2021 2:59:47 pm
 * Modified By: Vithushan Sylvester (msvithushan@gmail.com>)
 * -----
 * Copyright <<projectCreationYear>> - 2021 Vithushan Sylvester, CtrlX
 */

package blog.vithushan.demobatchprocessing.Data;

import org.springframework.batch.item.ItemProcessor;

import blog.vithushan.demobatchprocessing.Model.Book;

public class BookProcessor implements ItemProcessor <BookInput,Book> {

    @Override
    public Book process(BookInput bookInput) throws Exception {
        Book book = new Book();
        book.setBookID(Long.parseLong(bookInput.getBookID()));
        book.setTitle(bookInput.getTitle());
        book.setAuthors(bookInput.getAuthors());
        book.setIsbn(bookInput.getIsbn());
        return book;
    }
    
}
