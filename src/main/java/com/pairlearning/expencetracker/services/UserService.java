package com.pairlearning.expencetracker.services;

import com.pairlearning.expencetracker.entity.User;
import com.pairlearning.expencetracker.exceptions.EtAuthException;

public interface UserService {

    User validateUser(String email, String password) throws EtAuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;


}
