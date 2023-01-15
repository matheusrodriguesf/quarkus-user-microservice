package org.arcelino.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.arcelino.entity.User;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    public List<User> findByName(String name) {
        return find("name", name).list();
    }
}

