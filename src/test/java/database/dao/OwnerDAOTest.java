package database.dao;

import database.dto.OwnerDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Scanner;

import static org.junit.Assert.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class OwnerDAOTest {


    @Mock
    Scanner scanner;

    OwnerDAO ownerDAO;

    @Before
    public void setUp() throws Exception {
        ownerDAO = new OwnerDAO();
    }

    @Before


    @Test
    public void shouldName() {
        //given
        Mockito.when(scanner.next()).thenReturn("John");
        ownerDAO.createOwner(scanner);
        OwnerDTO ownerDTO = ownerDAO
        //when
        assertEquals();
        //then

    }
}