package de.codecentric.training.app;

import de.codecentric.training.domain.Entity;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class EntityCombineServiceTest {

    private EntityCombineService entityCombineService = new EntityCombineService();

    @Test
    public void shouldCombineTwoEntities() throws Exception {
        Entity hello = new Entity("Hello, ");
        Entity world = new Entity("World!");
        assertThat(entityCombineService.combine(hello, world), is(equalTo("Hello, World!")));
    }

    @Test
    public void shouldHandleNullFirstParameter() throws Exception {
        Entity first = null;
        Entity second = new Entity("Second");
        assertThat(entityCombineService.combine(first, second), is(equalTo("Second")));
    }

    @Test
    public void shouldHandleNullSecondParameter() throws Exception {
        Entity first = new Entity("First");
        Entity second = null;
        assertThat(entityCombineService.combine(first, second), is(equalTo("First")));
    }

    @Test
    public void shouldHandleNullParameters() throws Exception {
        Entity first = null;
        Entity second = null;
        assertThat(entityCombineService.combine(first, second), is(equalTo("")));
    }
}
