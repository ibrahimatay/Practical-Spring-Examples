package models;

import com.ibrahimatay.models.Guest;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.UUID;

import static org.junit.Assert.*;

public class GuestTest {
    private static final String JOHN = "John";
    private static final String DOE = "Doe";
    private static final UUID GUEST_ID = UUID.randomUUID();

    @Test
    public void shouldCreateGuestWithFirstNameAndLastName() {
        Guest guest = new Guest(JOHN, DOE);

        assertNull(guest.getId());
        assertSame(JOHN, guest.getFirstName());
        assertSame(DOE, guest.getLastName());
    }

    // ReflectionTestUtils is usually used for:
    // 1) ORM Related Unit Testing
    // 2) @Autowired, @Inject, @Resource manual injection in Unit Testing
    // 3) @PostConstruct, @PreDestroy method execution if they are private
    // Keep in mind that each case above can be also achieved with package-private access modifier,
    // this breaks encapsulation, but keeps compile-time-feedback at satisfying level
    // https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/util/ReflectionTestUtils.html
    @Test
    public void shouldSetGuestId() {
        Guest guest = new Guest(JOHN, DOE);

        ReflectionTestUtils.setField(guest, "id", GUEST_ID, UUID.class);

        assertEquals(GUEST_ID, guest.getId());
    }
}
