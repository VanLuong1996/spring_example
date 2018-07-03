package vn.topica.sf18.auth;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Slf4j
public class MyUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

  private Environment environment;

  public MyUrlAuthenticationSuccessHandler(Environment environment) {
    super();
    this.environment = environment;
  }

  // API
  @Override
  public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException {
    handle(request, response, authentication);
  }

  // IMPL
  protected void handle(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException {
    String domain = environment.getProperty("app.domain");
    if(domain == null){
      domain = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
    }
    log.info("(handle)doamin: {}", domain);
    final String targetUrl = domain + determineTargetUrl(authentication);
    log.info("(handle)targetUrl: {}", targetUrl);

    if (response.isCommitted()) {
      log.info("Response has already been committed. Unable to redirect to " + targetUrl);
      return;
    }

    redirectStrategy.sendRedirect(request, response, targetUrl);
  }

  protected String determineTargetUrl(final Authentication authentication) {
    boolean isUser = false;
    boolean isAdmin = false;
    final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
    for (final GrantedAuthority grantedAuthority : authorities) {
      if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
        isUser = true;
        break;
      } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
        isAdmin = true;
        break;
      }
    }

    log.info("(determineTargetUrl)isUser: {}, {}", isUser, authentication.getName());
    if (isUser) {
      return "/api/user?isAdmin=false";
    } else if (isAdmin) {
      return "/api/user?isAdmin=true";
    } else {
      throw new IllegalStateException();
    }
  }

  public void setRedirectStrategy(final RedirectStrategy redirectStrategy) {
    this.redirectStrategy = redirectStrategy;
  }

  protected RedirectStrategy getRedirectStrategy() {
    return redirectStrategy;
  }
}
