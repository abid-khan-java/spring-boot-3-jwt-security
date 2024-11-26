package com.alibou.security.user.model;


import org.jetbrains.annotations.NotNull;

public record ChangePasswordRequest(@NotNull String currentPassword,
                                    @NotNull String newPassword,
                                    @NotNull String confirmationPassword) {
}
