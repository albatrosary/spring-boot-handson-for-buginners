/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megascus.spring.boot.handson.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author megascus
 */
@Component //Springで管理されるコンポーネント
@Transactional //本来はここでトランザクションを管理する。今回はBookRespositoryにアクセスするだけなのであまり意味は無い
public class BookService {

    @Autowired //Springで管理されているコンポーネントからBookRepositoryであるクラスを取ってくる
    BookRepository repository;

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book findOne(Long id) {
        return repository.findOne(id);
    }

    public Book save(Book book) {
        return repository.save(book);
    }

    public Book update(Book book) {
        //すでに登録されている場合のみ更新する
        if (repository.findOne(book.getId()) != null) {
            return repository.save(book);
        }
        return book;
    }

    public void delete(Long id) {
        repository.delete(id);
    }

}
