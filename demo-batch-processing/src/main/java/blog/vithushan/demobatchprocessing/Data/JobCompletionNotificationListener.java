/*
 * File: JobCompletionNotificationListener.java
 * Project: Data
 * File Created: Saturday, 22nd May 2021 5:48:14 pm
 * Author: Vithushan Sylvester (msvithushan@gmail.com)
 * -----
 * Last Modified: Saturday, 22nd May 2021 6:36:26 pm
 * Modified By: Vithushan Sylvester (msvithushan@gmail.com>)
 * -----
 * Copyright <<projectCreationYear>> - 2021 Vithushan Sylvester, CtrlX
 */

package blog.vithushan.demobatchprocessing.Data;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution){
        if(jobExecution.getStatus() == BatchStatus.COMPLETED){
            System.out.println("Batch processing completed!!");

            jdbcTemplate.query("SELECT bookID, title, authors FROM book",
            (rs, row) -> "Book ID: " + rs.getString("bookID") + " Title: " + rs.getString("title") + " Authors: " + rs.getString("authors")
            ).forEach(book -> System.out.println(book));
        }
    }
    
}
