package de.codecentric.training.app;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import de.codecentric.training.domain.Entity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(HierarchicalContextRunner.class)
public class EntityCombineServiceTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    private EntityCombineService entityCombineService;

    @Before
    public void setUp() throws Exception {
        entityCombineService = new EntityCombineService();
    }

    @Test(expected = IllegalArgumentException.class)
    public void junitShouldBePresent(){
        assertTrue(true);
        throw new IllegalArgumentException();
    }

    public class GivenFirstEntityNull {

        private String inThisContext;

        @Before
        public void setUp(){
            inThisContext = "someValue";
        }

        @Test
        public void shouldReturnSecondParameter() throws Exception {
            Entity result = entityCombineService.combine(null, new Entity("Welt!"));
            assertEquals("Welt!", result.getValue());
        }

        public class GivenSecondParameterIsNull {

            @Test
            public void shouldReturnEmptyString() throws Exception {
                assertEquals(new Entity(""), entityCombineService.combine(null, null));
                assertEquals("someValue", inThisContext);
            }
        }
    }

    @Test
    public void testCombine(){
        Entity result = entityCombineService.combine(new Entity("Hallo, "), new Entity("Welt!"));
        assertEquals("Hallo, Welt!", result.getValue());
    }

    @Test
    public void givenNullSecondParameterShouldReturnFirstParameter() throws Exception {
        Entity result = entityCombineService.combine(new Entity("Hallo"), null);
        assertEquals("Hallo", result.getValue());
    }

}
