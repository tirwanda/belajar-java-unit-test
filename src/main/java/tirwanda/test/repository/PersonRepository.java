package tirwanda.test.repository;

import tirwanda.test.data.Person;

public interface PersonRepository {

    Person selectById(String id);
    void insert(Person person);
}
