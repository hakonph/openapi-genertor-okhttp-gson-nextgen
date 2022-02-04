package no.test.kake;

import org.junit.jupiter.api.Test;
import org.openapitools.client.JSON;
import org.openapitools.client.model.Parent;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OpenapiGeneratorTest {

    @Test
    void test() {
        new JSON();//to setup json
        assertThrows(IOException.class,
                () ->  JSON.deserialize("""
                        {"discriminator":"Child1"}
                        """, Parent.class));
    }
}
