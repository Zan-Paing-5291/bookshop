package com.example.bookshop;

import com.example.bookshop.dao.AuthorDao;
import com.example.bookshop.dao.BookDao;
import com.example.bookshop.dao.GenreDao;
import com.example.bookshop.dao.PublisherDao;
import com.example.bookshop.entity.Author;
import com.example.bookshop.entity.Book;
import com.example.bookshop.entity.Genre;
import com.example.bookshop.entity.Publisher;
import com.example.bookshop.util.IsbnGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
public class BookShopApplication {
    private final AuthorDao authorDao;
    private final BookDao bookDao;
    private final GenreDao genreDao;
    private final PublisherDao publisherDao;

    @Bean
    @Transactional
    @Profile("data")
    public ApplicationRunner runner(){
        return r->{
            Author author1 = new Author("Zan Paing","zp@gmail.com");
            Author author2 = new Author("Twelvestring","twelve@gmail.com");

            Publisher publisher1 = new Publisher("New Era","newera@gmail.com");
            Publisher publisher2 = new Publisher("New Age","newage@gmail.com");

            Genre genre1 = new Genre();
            genre1.setGenreName("Adventure");

            Genre genre2 = new Genre();
            genre2.setGenreName("Action");

            Book book1 = new Book(
                    1,
                    IsbnGenerator.generate(),
                    "Oliver Twist",
                    "Excellent",
                    59.99,
                    20,
                    "https://source.unsplash.com/400x300/?girls");
            Book book2 = new Book(
                    2,
                    IsbnGenerator.generate(),
                    "Great Expectations",
                    "Good Choice",
                    49.99,
                    20,
                    "https://source.unsplash.com/400x300/?ladies");
            Book book3 = new Book(
                    3,
                    IsbnGenerator.generate(),
                    "Philosopher Stone",
                    "Best Seller",
                    49.99,
                    20,
                    "https://source.unsplash.com/400x300/?harrypotter");
            Book book4 = new Book(
                    4,
                    IsbnGenerator.generate(),
                    "Chamber of Secrets",
                    "Best Seller",
                    49.99,
                    20,
                    "https://source.unsplash.com/400x300/?hogwarts");
            Book book5 = new Book(
                    5,
                    IsbnGenerator.generate(),
                    "One Piece",
                    "Best Movie",
                    49.99,
                    20,
                    "https://source.unsplash.com/400x300/?ship");
            Book book6 = new Book(
                    6,
                    IsbnGenerator.generate(),
                    "Yama",
                    "Best Movie",
                    49.99,
                    20,
                    "https://source.unsplash.com/400x300/?mens");

            //mapping
            author1.addBook(book1);
            author1.addBook(book2);
            author1.addBook(book3);

            author2.addBook(book4);
            author2.addBook(book5);
            author2.addBook(book6);

            Publisher pub1 = publisherDao.save(publisher1);

            pub1.addBook(book1);
            pub1.addBook(book2);
            pub1.addBook(book3);

            Publisher pub2 = publisherDao.save(publisher2);

            pub2.addBook(book4);
            pub2.addBook(book5);
            pub2.addBook(book6);

            Genre gen1 = genreDao.save(genre1);
            Genre gen2 = genreDao.save(genre2);

            book1.addGenres(gen1);
            book2.addGenres(gen1);
            book3.addGenres(gen1);

            book4.addGenres(gen2);
            book5.addGenres(gen2);
            book6.addGenres(gen2);

//            bookDao.save(book1);
//            bookDao.save(book2);
//            bookDao.save(book3);
//            bookDao.save(book4);
//            bookDao.save(book5);
//            bookDao.save(book6);

            authorDao.save(author1);
            authorDao.save(author2);

//            publisherDao.save(publisher1);
//            publisherDao.save(publisher2);


        };
    }
    public static void main(String[] args) {
        SpringApplication.run(BookShopApplication.class, args);
    }

}
