package nl.miwnn.se13.equipaprimavera.ReceitaDePrimavera;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author Mirjam Schmitz
 * <p>
 * Purpose for the class
 **/
class ExampleTest {
    @Test
    void shouldShowSimpleAssertion() {
        Assertions.assertEquals(1,1);
    }

    @Test
    @DisplayName("shouldShow")
    void shouldShow() {
        
        org.junit.jupiter.api.Assertions.fail("Not implemented");
    }
}