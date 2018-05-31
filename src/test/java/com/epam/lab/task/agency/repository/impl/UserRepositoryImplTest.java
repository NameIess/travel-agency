package com.epam.lab.task.agency.repository.impl;

import com.epam.lab.task.agency.entity.User;
import com.epam.lab.task.agency.repository.UserRepository;
import com.epam.lab.task.agency.repository.datasource.GenericDataSource;
import com.epam.lab.task.agency.repository.specification.impl.UserSpecificationById;
import com.epam.lab.task.agency.resources.user.UserDataProvider;
import com.epam.lab.task.agency.resources.user.UserTestResource;
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
public class UserRepositoryImplTest extends UserDataProvider {
    private GenericDataSource<User, Long> dataSource;
    private UserRepository underTest;
    private Collection<User> userCollection;

    @Before
    public void doSetup() {
        dataSource = mock(GenericDataSource.class);
        underTest = new UserRepositoryImpl(dataSource);
        userCollection = mock(Collection.class);
    }

    @Test
    @UseDataProvider("validUserAndOptional")
    public void shouldReturnOptionalUserWhenSavedUserIsValid(User user, Optional<User> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(userCollection);
        when(dataSource.insert(any(User.class))).thenReturn(expectedResult);

        Optional<User> actualValue = underTest.save(user);

        verify(dataSource, times(1)).insert(any(User.class));
        Assert.assertEquals(actualValue, expectedResult);
    }

    @Test
    @UseDataProvider("validUser")
    public void shouldDeleteUserWhenDeletedUserIsValid(User user) {
        when(dataSource.getDataSource()).thenReturn(userCollection);

        underTest.delete(user);

        verify(dataSource, times(1)).delete(any(User.class));
    }

    @Test
    @UseDataProvider("validUserEmptyOptional")
    public void shouldReturnOptionalUserWhenSavedUserInvalid(User user, Optional<User> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(userCollection);
        when(dataSource.insert(any(User.class))).thenReturn(expectedResult);

        Optional<User> actualResult = underTest.save(user);

        verify(dataSource, times(1)).insert(any(User.class));
        Assert.assertFalse(expectedResult.isPresent());
        Assert.assertFalse(actualResult.isPresent());
    }

    @Test
    @UseDataProvider("validUserAndOptional")
    public void shouldUpdateUserWhenUpdatedUserIsValid(User user, Optional<User> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(userCollection);
        when(dataSource.update(any(User.class))).thenReturn(expectedResult);

        Optional<User> actualResult = underTest.update(user);

        verify(dataSource, times(1)).update(any(User.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptionalCollection")
    public void shouldReturnUserCollectionWhenSpecificationSatisfies(UserSpecificationById specificationById, Optional<Collection<User>> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(userCollection);
        when(dataSource.findAllByCriteria(any(UserSpecificationById.class))).thenReturn(expectedResult);

        Optional<Collection<User>> actualResult = underTest.findAll(specificationById);

        verify(dataSource, times(1)).findAllByCriteria(any(UserSpecificationById.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @UseDataProvider("invalidSpecificationById")
    public void shouldReturnUserCollectionWhenSpecificationNotSatisfies(UserSpecificationById specificationById) {
        when(dataSource.getDataSource()).thenReturn(userCollection);
        when(dataSource.findAllByCriteria(any(UserSpecificationById.class))).thenReturn(UserTestResource.EMPTY_OPTIONAL_USER_COLLECTION);

        Optional<Collection<User>> actualResult = underTest.findAll(specificationById);

        verify(dataSource, times(1)).findAllByCriteria(any(UserSpecificationById.class));
        Assert.assertFalse(actualResult.isPresent());
    }

    @Test
    @UseDataProvider("validSpecificationByIdAndOptional")
    public void shouldReturnUserWhenSpecificationSatisfies(UserSpecificationById specificationById, Optional<User> expectedResult) {
        when(dataSource.getDataSource()).thenReturn(userCollection);
        when(dataSource.findOneByCriteria(any(UserSpecificationById.class))).thenReturn(expectedResult);

        Optional<User> actualResult = underTest.findOne(specificationById);

        verify(dataSource, times(1)).findOneByCriteria(any(UserSpecificationById.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @UseDataProvider("invalidSpecificationById")
    public void shouldReturnUserWhenSpecificationNotSatisfies(UserSpecificationById specificationById) {
        when(dataSource.getDataSource()).thenReturn(userCollection);
        when(dataSource.findOneByCriteria(any(UserSpecificationById.class))).thenReturn(UserTestResource.EMPTY_OPTIONAL_USER);

        Optional<User> actualResult = underTest.findOne(specificationById);

        verify(dataSource, times(1)).findOneByCriteria(any(UserSpecificationById.class));
        Assert.assertFalse(actualResult.isPresent());
    }
}
