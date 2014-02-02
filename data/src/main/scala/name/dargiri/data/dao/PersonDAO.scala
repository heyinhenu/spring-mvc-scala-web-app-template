package name.dargiri.data.dao

import name.dargiri.data.model.Person
import java.util.UUID

/**
 * Created by dionis on 2/2/14.
 */
trait PersonDAO extends BaseDAO[Person, UUID] {
  override def entityClass: Class[Person] = classOf[Person]
}

class PersonDAOImpl extends PersonDAO
