package com.epam.lab.task.agency.service.impl;

import com.epam.lab.task.agency.entity.User;
import com.epam.lab.task.agency.repository.UserRepository;
import com.epam.lab.task.agency.repository.specification.impl.ReviewSpecificationAllByIdIn;
import com.epam.lab.task.agency.repository.specification.impl.UserSpecificationById;
import com.epam.lab.task.agency.resources.user.UserDataProvider;
import com.epam.lab.task.agency.resources.user.UserTestResource;
import com.epam.lab.task.agency.service.ReviewService;
import com.epam.lab.task.agency.service.UserService;
import com.epam.lab.task.agency.service.exception.ServiceException;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collection;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(DataProviderRunner.class)
public class UserServiceImplTest extends UserDataProvider {
    private UserService underTest;
    private UserRepository userRepository;
    private ReviewService reviewService;

    @Before
    public void doSetup() {
        userRepository = mock(UserRepository.class);
        reviewService = mock(ReviewService.class);
        underTest = new UserServiceImpl(userRepository, reviewService);
    }

    @Test
    @UseDataProvider("validUserAndOptional")
    public void shouldReturnUserWhenSavedUserIsValid(User user, Optional<User> expectedResult) {
        when(userRepository.save(user)).thenReturn(expectedResult);

        User actualResult = underTest.save(user);

        verify(userRepository, times(1)).save(user);
        Assert.assertTrue(expectedResult.isPresent());
        Assert.assertEquals(actualResult, expectedResult.get());
    }

    @Test(expected = ServiceException.class)
    @UseDataProvider("validUser")
    public void shouldThrowServiceExceptionWhenSavedUserInvalid(User user) {
        when(userRepository.save(user)).thenReturn(UserTestResource.EMPTY_OPTIONAL_USER);

        underTest.save(user);
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptionalCollection")
    public void shouldDeleteUserWhenDeletedUserIsValid(UserSpecificationById specificationById, Optional<Collection<User>> expectedResult) {
        when(userRepository.findAll(specificationById)).thenReturn(expectedResult);

        underTest.delete(specificationById);

        verify(reviewService, times(1)).delete(any(ReviewSpecificationAllByIdIn.class));
        verify(userRepository, times(1)).delete(anyCollectionOf(User.class));
    }

    @Test(expected = ServiceException.class)
    @UseDataProvider("validSpecificationById")
    public void shouldThrowServiceExceptionWhenDeletedUserInvalid(UserSpecificationById specificationById) {
        doThrow(new ServiceException()).when(userRepository).findAll(specificationById);

        underTest.delete(specificationById);
    }

    @Test
    @UseDataProvider("validUserAndOptional")
    public void shouldReturnUserWhenUpdatedUserIsValid(User user, Optional<User> expectedResult) {
        when(userRepository.update(user)).thenReturn(expectedResult);

        User actualResult = underTest.update(user);

        verify(userRepository, times(1)).update(user);
        Assert.assertTrue(expectedResult.isPresent());
        Assert.assertEquals(actualResult, expectedResult.get());
    }

    @Test(expected = ServiceException.class)
    @UseDataProvider("validUser")
    public void shouldThrowServiceExceptionWhenUpdatedUserInvalid(User user) {
        when(userRepository.update(user)).thenReturn(UserTestResource.EMPTY_OPTIONAL_USER);

        underTest.update(user);
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptional")
    public void shouldReturnUserWhenFoundedUserIsValid(UserSpecificationById specificationById, Optional<User> expectedResult) {
        when(userRepository.findOne(specificationById)).thenReturn(expectedResult);

        User actualResult = underTest.findOne(specificationById);

        verify(userRepository, times(1)).findOne(specificationById);
        Assert.assertTrue(expectedResult.isPresent());
        Assert.assertEquals(actualResult, expectedResult.get());
    }

    @Test(expected = ServiceException.class)
    @UseDataProvider("validSpecificationById")
    public void shouldThrowServiceExceptionWhenFoundedUserInvalid(UserSpecificationById specificationById) {
        when(userRepository.findOne(any(UserSpecificationById.class))).thenReturn(UserTestResource.EMPTY_OPTIONAL_USER);

        underTest.findOne(specificationById);
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptionalCollection")
    public void shouldReturnUserCollectionWhenFoundedCollectionIsValid(UserSpecificationById specificationById, Optional<Collection<User>> expectedResult) {
        when(userRepository.findAll(any(UserSpecificationById.class))).thenReturn(expectedResult);

        Collection<User> actualResult = underTest.findAll(specificationById);

        verify(userRepository, times(1)).findAll(any(UserSpecificationById.class));
        Assert.assertTrue(expectedResult.isPresent());
        Assert.assertEquals(actualResult, expectedResult.get());
    }

    @Test(expected = ServiceException.class)
    @UseDataProvider("validSpecificationById")
    public void shouldThrowServiceExceptionWhenFoundedCollectionInvalid(UserSpecificationById specificationById) {
        when(userRepository.findAll(any(UserSpecificationById.class))).thenReturn(UserTestResource.EMPTY_OPTIONAL_USER_COLLECTION);

        underTest.findAll(specificationById);
    }
}
