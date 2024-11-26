package com.alibou.security.user.service;

import com.alibou.security.user.model.ChangePasswordRequest;
import org.jetbrains.annotations.NotNull;

import java.security.Principal;

public interface UserService {
    void changePassword(@NotNull ChangePasswordRequest request, @NotNull Principal connectedUser);
}
