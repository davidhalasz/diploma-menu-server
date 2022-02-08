package com.menu.menuserver.service;

import com.menu.menuserver.model.User;

public interface AuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
