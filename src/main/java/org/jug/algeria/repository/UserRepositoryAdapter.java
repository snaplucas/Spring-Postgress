package org.jug.algeria.repository;

import org.jug.algeria.domain.AppUser;
import org.jug.algeria.domain.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository {

    private final UserCrudRepository userCrudRepository;

    @Autowired
    public UserRepository(UserCrudRepository userCrudRepository) {
        this.userCrudRepository = userCrudRepository;
    }

    @Override
    public AppUser save(AppUser user) {
        return userCrudRepository.save(user);
    }

    @Override
    public Iterable<AppUser> findAll() {
        return userCrudRepository.findAll();
    }
}
