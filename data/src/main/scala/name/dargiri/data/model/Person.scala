package name.dargiri.data.model

import javax.persistence._
import java.util.UUID
import java.util.{Set => JSet}

/**
 * Created by dionis on 2/2/14.
 */
@Entity
@Table(name = "people")
class Person extends Model[UUID] {
  @Id
  @Column(name = "id")
  var id: UUID = _
  @Column(name = "username")
  var username: String = _

  override def assignId(): Unit = {
    id = UUID.randomUUID()
  }


  def canEqual(other: Any): Boolean = other.isInstanceOf[Person]

  override def equals(other: Any): Boolean = other match {
    case that: Person =>
      (that canEqual this) &&
        id == that.id
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(id)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
