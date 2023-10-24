package com.bci.gestionusuarios.service;

import com.bci.gestionusuarios.entity.UserEntity;
import com.bci.gestionusuarios.service.impl.TokenServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class TokenServiceImplTest {

    @Autowired
    private TokenServiceImpl tokenServiceImpl;

    @Test
    public void testToToken() {
        UserEntity user = new UserEntity();
        user.setId("1");

        String token = tokenServiceImpl.toToken(user);

        Map<String, Object> claims = tokenServiceImpl.getClaims(token);

        assertEquals(user.getId(), claims.get("UserId"));
    }

    @Test
    public void testGetClaims() {
        UserEntity user = new UserEntity();
        user.setId("1");
        String token = tokenServiceImpl.toToken(user);

        Map<String, Object> claims = tokenServiceImpl.getClaims(token);

        assertEquals(user.getId(), claims.get("UserId"));
    }


}