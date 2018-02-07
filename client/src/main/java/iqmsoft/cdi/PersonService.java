package iqmsoft.cdi;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;

import iqmsoft.domain.User;
import iqmsoft.domain.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@Slf4j
@Stateless
public class PersonService {

  @Inject UserRepository userRepository;

  @Asynchronous
  @SneakyThrows
  public Future<List<String>> removeAny(final String name) {
    Thread.sleep(4321);

    val users = userRepository.findByName(name);

    log.info("User will be removed: {}", users);
    userRepository.deleteByName(name);
    log.info("User removeAny done.");

    val result = new ArrayList<String>();

    if (null != users)
      for (final User user : users)
        result.add(user.getName());

    return new AsyncResult<List<String>>(result);
  }

  @Asynchronous
  @SneakyThrows
  public Future<User> createPerson(final String name) {
    Thread.sleep(3456);
    val person = new User(name);
    log.info("User created done.");
    return new AsyncResult<User>(userRepository.save(person));
  }

  @Asynchronous
  @SneakyThrows
  public Future<List<User>> getPeople() {
    Thread.sleep(2345);
    log.info("Getting All Users ");
    return new AsyncResult<List<User>>(
        new ArrayList<User>(userRepository.findAll())
    );
  }
}
