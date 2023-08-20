package com.pairlearning.expencetracker.services;

import com.pairlearning.expencetracker.entity.User;
import com.pairlearning.expencetracker.exceptions.EtAuthException;
import com.pairlearning.expencetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        if (email != null) email = email.toLowerCase();

        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException {

        Pattern pattern = Pattern.compile("^(.+)@(.+)$");

        if(email != null) email = email.toLowerCase();

        if (!pattern.matcher(Objects.requireNonNull(email)).matches()) {
            throw new EtAuthException("Invalid email format");
        }

        Integer count = userRepository.getCountByEmail(email);
        if (count > 0) {
            throw new EtAuthException("Email already in use");
        }

        Integer userId = userRepository.create(firstName, lastName, email, password);
        return userRepository.findById(userId);

    }
}
