package org.jug.algeria.domain;

public interface IUserRepository {

    AppUser save(AppUser user);

    Iterable<AppUser> findAll();
}
