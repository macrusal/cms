package br.com.hibejix.cms.domains.service;

import br.com.hibejix.cms.domains.models.User;
import br.com.hibejix.cms.domains.repository.UserRepository;
import br.com.hibejix.cms.domains.vo.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User update(String id, UserRequest userRequest) {
        final User user = this.userRepository.findOne(id);
        user.setIdentity(userRequest.getIdentity());
        user.setName(userRequest.getName());
        user.setRole(userRequest.getRole());
        return this.userRepository.save(user);
    }

    public User create(UserRequest userRequest) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setIdentity(userRequest.getIdentity());
        user.setName(userRequest.getName());
        user.setRole(userRequest.getRole());
        return this.userRepository.save(user);

    }

    public void delete(final String id) {
        final User user = this.userRepository.findOne(id);
        this.userRepository.delete(user);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findOne(final String id) {
        return this.userRepository.findOne(id);
    }
}
