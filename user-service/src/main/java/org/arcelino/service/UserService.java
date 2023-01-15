package org.arcelino.service;

import lombok.AllArgsConstructor;
import org.arcelino.dto.UserForm;
import org.arcelino.dto.UserResponse;
import org.arcelino.repository.UserRepository;
import org.arcelino.util.UserMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@ApplicationScoped
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public void save(UserForm userForm) {
        var user = userMapper.toUser(userForm);
        userRepository.persist(user);
    }

    @Transactional
    public void update(Long id, UserForm userForm) {
        var user = userRepository.findById(id);
        if (user != null) {
            user.setName(userForm.getName());
            user.setEmail(userForm.getEmail());
            user.setAge(userForm.getAge());
            userRepository.persist(user);
        }
    }

    @Transactional
    public boolean delete(Long id) {
        return userRepository.deleteById(id);
    }

    public List<UserResponse> all() {
        return userRepository.listAll().stream()
                .map(userMapper::toUserResponse)
                .toList();
    }

    public List<UserResponse> findByName(String name) {
        return userRepository.findByName(name).stream()
                .map(userMapper::toUserResponse)
                .toList();
    }

    public UserResponse get(Long id) {
        var user = userRepository.findById(id);
        return userMapper.toUserResponse(user);
    }
}
