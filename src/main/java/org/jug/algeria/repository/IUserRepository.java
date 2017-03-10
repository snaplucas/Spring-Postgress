package org.jug.algeria.repository;

import org.jug.algeria.domain.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<AppUser, Long> {
}
