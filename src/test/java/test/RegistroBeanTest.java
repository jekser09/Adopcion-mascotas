package test;

import co.edu.ucentral.ingsf.springprime.bean.RegistroBean;
import org.junit.jupiter.api.Test;

import java.nio.channels.Channels;

import static org.junit.jupiter.api.Assertions.*;

class RegistroBeanTest {

    @Test
    void registro() {
        RegistroBean r=new RegistroBean();
        r.registro();
    }
}