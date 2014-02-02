package name.dargiri.web.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import name.dargiri.web.util.spring.LayoutModelAndView
import name.dargiri.data.dto.PersonDTO
import java.util.UUID

/**
 * Created by dionis on 2/2/14.
 */
@Controller
@RequestMapping(value = Array(""))
class MainController {
  @RequestMapping(value = Array("/", "/home"))
  def home(): ModelAndView = {
    val mav = new LayoutModelAndView("main/home")
    val person = new PersonDTO(UUID.randomUUID(), "dionis")
    mav.addObject("person", person)
  }
}
