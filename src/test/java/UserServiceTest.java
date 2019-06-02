import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


public class UserServiceTest {

    private UserService objectToTest;
    private DataAccessObject dao;

    @Before
    public void setUp(){
        dao = Mockito.mock(InternetDataAccessObject.class);
        when(dao.getUserData(anyString())).thenReturn("Michał Nowotka");
        objectToTest = new UserService(dao);
    }

    @Test
    public void testGreeting(){
        assertThat(objectToTest.greeting()).endsWith( "Hello, World!");
    }


    @Test
    public void testGetUserData(){
        assertThat(objectToTest.getUserData("mnowotka")).contains("Michał Nowotka");
    }

}
