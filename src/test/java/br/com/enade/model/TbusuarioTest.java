package br.com.enade.model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;


public class TbusuarioTest {
    
    Tbusuario validuser = new Tbusuario();
    
    public TbusuarioTest() {
    }

    @Test
    public void testGetSetIdUsuario() {
        System.out.println("getIdUsuario");
        validuser.setIdUsuario(new Long(1));
        assertEquals(new Long(1), validuser.getIdUsuario());
    }

    // @Test
    // public void testGetSetNomeUsuario() {
    //     System.out.println("getNomeUsuario");
    //     validuser.setNomeUsuario("Z�");
    //     assertEquals("Z�", validuser.getNomeUsuario());
    // }

    @Test
    public void testGetSetEmailUsuario() {
        System.out.println("getEmailUsuario");
        validuser.setEmailUsuario("ze@ze.com");
        assertEquals("ze@ze.com", validuser.getEmailUsuario());
    }

    // @Test
    // public void testGetSenhaUsuario() {
    //     System.out.println("Falha");
    //     fail("The test case is a prototype.");
    // }

    // @Ignore("Class not ready for tests")
    // public void testSetSenhaUsuario() {
    //     System.out.println("Ignorado");

    // }
    
}
