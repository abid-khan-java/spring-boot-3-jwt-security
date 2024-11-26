package com.alibou.security.auth.model;


import org.jetbrains.annotations.NotNull;

public record AuthenticationRequest(@NotNull String email, @NotNull String password) {
}
