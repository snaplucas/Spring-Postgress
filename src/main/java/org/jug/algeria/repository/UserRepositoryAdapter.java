package org.jug.algeria.repository;

import org.jug.algeria.domain.AppUser;
import org.jug.algeria.domain.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryAdapter implements IUserRepository {

    private final UserRepository userRepository;

    @Autowired
    public UserRepositoryAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public AppUser save(AppUser user) {
        return userRepository.save(user);
    }

    @Override
    public Iterable<AppUser> findAll() {
        return userRepository.findAll();
    }
}
