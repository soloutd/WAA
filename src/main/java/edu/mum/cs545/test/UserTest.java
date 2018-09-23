package edu.mum.cs545.test;

import edu.mum.cs545.model.User;
import edu.mum.cs545.repository.UserRepository;
import edu.mum.cs545.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class UserTest {
    @Mock
    UserRepository userRepositoryMock;

    @InjectMocks
    UserServiceImpl userService;

    List<User> users = new ArrayList<User>();

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);
        User userOne = new User();
        User userTwo = new User();
        userOne.setFirstName("Amartuvshin");
        userOne.setEmail("abold@mum.edu");
        userOne.setLastName("Bold");
        userTwo.setFirstName("Batbileg");
        userTwo.setEmail("batbileg@mum.edu");
        userTwo.setLastName("Dorj");
        users.add(userOne);
        users.add(userTwo);
    }

    @Test
    public void getAll() throws Exception {
        when(userRepositoryMock.findAll()).thenReturn(users);
        List<User> users = userService.getAll();
        for(User user :users ) {
            System.out.println(user.getFirstName());
            System.out.println(user.getLastName());
            System.out.println(user.getEmail());
        }
    }
}
