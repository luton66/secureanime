package com.leigh.secureanime.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.leigh.secureanime.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    ADMIN(Sets.newHashSet(ADMIN_READ, ADMIN_WRITE, USER_READ, USER_WRITE)),
    USER(Sets.newHashSet());

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    private final Set<ApplicationUserPermission> permissions;
}
