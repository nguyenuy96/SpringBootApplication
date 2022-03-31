package com.app.service;

import javax.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BaseServiceTest {
    @Mock
    protected HttpServletRequest httpServletRequest;
    @Mock
    protected RestTemplate template;

    private static final String ACCESS_TOKEN = "token";

    @BeforeEach
    void setup() {
        when(httpServletRequest.getHeader(ACCESS_TOKEN)).thenReturn("AccessToken");
    }
}
