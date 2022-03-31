package com.app.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.app.model.BusinessException;
import com.app.model.response.ProfileResponseModel;
import com.app.repository.ProfileRepository;
import com.app.service.BaseServiceTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class ProfileServiceImplTest extends BaseServiceTest {

    @InjectMocks
    private ProfileServiceImpl profileService;

    @Mock
    private ProfileRepository profileRepository;

    @Test
    void test_Get_Profile() throws BusinessException {
        ProfileResponseModel profile = new ProfileResponseModel();
        ResponseEntity<ProfileResponseModel> response= new ResponseEntity<>(profile, HttpStatus.OK);
        when(template.exchange(any(), any(), any(), Mockito.<Class<ProfileResponseModel>> any(), Mockito.anyMap())).thenReturn(response);
        ProfileResponseModel result = profileService.getProfileById(1L);
        //assert profile and result, they must be equal
    }

    /**
     * Concept for UT with driven data
     * the test function and driven data function has the same name
     * the test function must have arg
     * the driven data function provides arg correspoding with test function
     *
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