/*
 * File: Book.java
 * Project: Model
 * File Created: Thursday, 20th May 2021 2:05:36 am
 * Author: Vithushan Sylvester (msvithushan@gmail.com)
 * -----
 * Last Modified: Saturday, 22nd May 2021 2:56:32 pm
 * Modified By: Vithushan Sylvester (msvithushan@gmail.com>)
 * -----
 * Copyright <<projectCreationYear>> - 2021 Vithushan Sylvester, CtrlX
 */

package blog.vithushan.demobatchprocessing.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    private long bookID;
    private String title;
    private String authors;
    private String isbn;

    public long getBookID() {
        return bookID;
    }
    public void setBookID(long bookID) {
        this.bookID = bookID;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthors() {
        return authors;
    }
    public void setAuthors(String authors) {
        this.authors = authors;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    
}
