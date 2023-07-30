package com.gamingroom.gameauth.auth;

import javax.ws.rs.container.ContainerRequestContext;

import org.checkerframework.checker.nullness.qual.Nullable;

import io.dropwizard.auth.Authorizer;

public class GameAuthorizer implements Authorizer<GameUser> 
{
    @Override
    public boolean authorize(GameUser user, String role /*, @Nullable ContainerRequestContext containerRequestContext*/) {
    	
        // FIXME: 6Done - Finish the authorize method based on BasicAuth Security Example
    	
        return user.getRoles() != null && user.getRoles().contains(role);

    }

}