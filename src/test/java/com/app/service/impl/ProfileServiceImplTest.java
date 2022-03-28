package com.app.service.impl;

import com.app.model.BusinessException;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProfileServiceImplTest {

    @InjectMocks
    private ProfileServiceImpl profileService;

    @Mock
    private HttpServletRequest request;

    @Test
    void test_Get_Profile() throws BusinessException {
        profileService.getProfiles();
        //
    }

    /**
     * Concept for UT with driven data
     * the test function and driven data function has the same name
     * the test function must have arg
     * the driven data function provides arg correspoding with test function
     * @param arg1
     * @param arg2
     */
    @ParameterizedTest
    @MethodSource
    public void parameterTest(String arg1, String arg2) {

    }

    private static Stream<Arguments> parameterTest() {
        return Stream.of(
                Arguments.of("arg1", "arg2")
        );
    }
}