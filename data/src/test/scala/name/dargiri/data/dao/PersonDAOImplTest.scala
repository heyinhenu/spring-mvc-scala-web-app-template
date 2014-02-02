package name.dargiri.data.dao

import name.dargiri.data.SpringDbTest
import name.dargiri.data.model.Person
import java.util.UUID

/**
 * Created by dionis on 2/2/14.
 */
class PersonDAOImplTest extends SpringDbTest {
  val dao = new PersonDAOImpl
  dao.entityManager = em

  "Person" should "have id assigned when created" in {
    val entity: Person = new Person()
    entity.username = "dionis"
    dao.persist(entity)

    assert(entity.id !== null)
  }

  it should "be found by id after persisting" in {
    val entity: Person = new Person()
    entity.username = "dionis"
    dao.persist(entity)

    assert(entity.id !== null)

    val found: Option[Person] = dao.find(entity.id)
    found should equal (Some(entity))
  }

  it should "not be found by id if not found" in {
    val entity: Person = new Person()
    entity.username = "dionis"
    dao.persist(entity)

    assert(entity.id !== null)

    val found: Option[Person] = dao.find(UUID.randomUUID())
    found should equal (None)
  }
}
