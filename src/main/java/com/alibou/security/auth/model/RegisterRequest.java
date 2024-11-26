package com.alibou.security.auth.model;

import com.alibou.security.user.model.Role;
import org.jetbrains.annotations.NotNull;


public record RegisterRequest(@NotNull String firstname,
                              @NotNull String lastname,
                              @NotNull String email,
                              @NotNull String password,
                              @NotNull Role role) {

}
