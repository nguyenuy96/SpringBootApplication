package com.app.service.impl;

import com.app.model.BusinessException;
import com.app.service.ProfileService;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
class ProfileServiceImplTest {

    @Autowired
    private ProfileService profileService;

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