package com.expencetracker.services;

import com.expencetracker.entity.User;
import com.expencetracker.exceptions.EtAuthException;

public interface UserService {

    User validateUser(String email, String password) throws EtAuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;


}
