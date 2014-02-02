package name.dargiri.data.model

import java.io.{Serializable => JSerial}
/**
 * Created by dionis on 2/2/14.
 */

/**
 * Created by dionis on 2/2/14.
 */
trait Model[ID <: JSerial] {
  def id: ID
  def isNew: Boolean = id == null
  def assignId(): Unit
}

