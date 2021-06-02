package tirwanda.test.sevice;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tirwanda.test.data.Person;
import tirwanda.test.repository.PersonRepository;
import tirwanda.test.service.PersonService;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository);
    }

    @Test
    void getPersonNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> personService.get("Not Found"));
    }

    @Test
    void getPersonSuccess() {
        // Adding behavior ke mock Object
        Mockito.when(personRepository.selectById("Edho")).thenReturn(new Person("01", "Edho"));

        var person = personService.get("Edho");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("Edho", person.getName());
        Assertions.assertEquals("01", person.getId());
    }

    @Test
    void testCreateSuccess() {
        var person = personService.register("Edho");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("Edho", person.getName());
        Assertions.assertNotNull(person.getId());

        Mockito.verify(personRepository, Mockito.times(1))
                .insert(new Person(person.getId(), "Edho"));
    }
}
