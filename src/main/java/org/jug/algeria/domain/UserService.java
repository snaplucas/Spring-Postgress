package org.jug.algeria.domain;

import org.springframework.stereotype.Component;

@Component
public class UserService implements IUserService {

    public String doWork() {
        return "doing work";
    }
}
