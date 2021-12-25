package com.suru.usersapi.domain.responses;

import com.suru.usersapi.domain.models.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Transactional
public interface UserRepository extends CrudRepository<User, BigInteger> {
    User findFirstByEmail(String email);

    List<User> findUserByDeletedFalse();
}
