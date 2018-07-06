package vn.topica.sf18.api.controller;

import java.io.IOException;
import java.security.Principal;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@Slf4j
public class AuthController {

  @RequestMapping("/user")
  public Principal user(Principal principal) {
    log.info("(user)principal:{}", principal.getName());
    return principal;
  }

  @RequestMapping("/userRedirect")
  public void userRedirect(HttpServletResponse response, Principal principal) throws IOException {
    log.info("(user)principal:{}", principal.getName());
    if (principal != null && !principal.getName().equals("")) {
      response.sendRedirect("/?loggedIn=true");
    } else {
      response.sendRedirect("/?loggedIn=false");
    }
  }
}
