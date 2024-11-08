package kh.edu.cstad.web_gateway.security;

import kh.edu.cstad.web_gateway.dto.UserProfile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/profile")
    UserProfile secured(@AuthenticationPrincipal Authentication auth) {
        OAuth2AuthenticationToken oauth2 = (OAuth2AuthenticationToken) auth;
        DefaultOidcUser oidcUser = (DefaultOidcUser) oauth2.getCredentials();
        System.out.println(oidcUser.getAttributes());
        return new UserProfile(oidcUser.getName(),
                oidcUser.getUserInfo().getClaimAsString("uuid"),
                oidcUser.getIdToken().getClaimAsString("reksmey1")
        );
    }

}
