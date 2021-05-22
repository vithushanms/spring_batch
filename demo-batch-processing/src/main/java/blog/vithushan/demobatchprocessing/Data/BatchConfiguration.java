/*
 * File: BatchConfiguration.java
 * Project: Data
 * File Created: Saturday, 22nd May 2021 3:12:50 pm
 * Author: Vithushan Sylvester (msvithushan@gmail.com)
 * -----
 * Last Modified: Saturday, 22nd May 2021 6:37:43 pm
 * Modified By: Vithushan Sylvester (msvithushan@gmail.com>)
 * -----
 * Copyright <<projectCreationYear>> - 2021 Vithushan Sylvester, CtrlX
 */

package blog.vithushan.demobatchprocessing.Data;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import blog.vithushan.demobatchprocessing.Model.Book;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public BookProcessor getProcessor() {
        return new BookProcessor();
    }

    @Bean
    public FlatFileItemReader<BookInput> reader() {
        String[] fieldNames = { "bookID", "title", "authors", "average_rating", "isbn", "isbn13", "language_code",
                "num_pages", "ratings_count", "text_reviews_count", "publication_date", "publisher" };

        return new FlatFileItemReaderBuilder<BookInput>().name("bookItemreader")
                .resource(new ClassPathResource("./books.csv")).delimited().names(fieldNames)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<BookInput>() {
                    {
                        setTargetType(BookInput.class);
                    }
                }).build();
    }

    @Bean
    public JdbcBatchItemWriter<Book> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Book>()
        .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
        .sql("INSERT INTO book (bookID,title,authors,isbn) VALUES (:bookID,:title,:authors,:isbn)")
        .dataSource(dataSource)
        .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Book> writer){
        return stepBuilderFactory.get("step1")
        .<BookInput,Book> chunk(20)
        .reader(reader())
        .processor(getProcessor())
        .writer(writer)
        .build();
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
    return jobBuilderFactory.get("importUserJob")
        .incrementer(new RunIdIncrementer())
        .listener(listener)
        .flow(step1)
        .end()
        .build();
    }
}
