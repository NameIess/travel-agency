package com.epam.lab.task.agency.repository.datasource;

import com.epam.lab.task.agency.entity.User;
import com.epam.lab.task.agency.resources.user.UserDataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(DataProviderRunner.class)
public class UserDataSourceTest extends UserDataProvider {
    private GenericDataSource<User, Long> underTest;
    private Collection<User> userCollection;

    @Before
    public void doSetup() {
        underTest = UserDataSource.getInstance();
        userCollection = mock(ArrayList.class);
        underTest.setDataSource(userCollection);
    }

    @Test
    @UseDataProvider("validUserCollection")
    public void shouldDeleteUserCollectionWhenDeletedUserIsValid(Collection<User> users) {
        underTest.delete(users);

        verify(userCollection, times(1)).removeAll(anyCollectionOf(User.class));
    }

    @Test
    @UseDataProvider("validUserAndOptional")
    public void shouldUpdateUserWhenUpdatedUserIsValid(User user, Optional<User> expectedResult) {
        when(userCollection.removeIf(any(Predicate.class))).thenReturn(true);

        Optional<User> actualResult = underTest.update(user);

        verify(userCollection, times(1)).add(any(User.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    @UseDataProvider("validUserEmptyOptional")
    public void shouldUpdateUserWhenUpdatedUserInvalid(User user, Optional<User> expectedResult) {
        when(userCollection.removeIf(any(Predicate.class))).thenReturn(false);

        Optional<User> actualResult = underTest.update(user);

        verify(userCollection, times(0)).add(any(User.class));
        Assert.assertEquals(actualResult, expectedResult);
    }
}
