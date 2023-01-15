package org.arcelino.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.arcelino.entity.User;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

}

