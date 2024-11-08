package kh.edu.cstad.identity.init;

import jakarta.annotation.PostConstruct;
import kh.edu.cstad.identity.security.service.JpaRegisteredClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ClientInit {
    private final PasswordEncoder passwordEncoder;
    private final JpaRegisteredClientRepository jpaRegisteredClientRepository;


    @PostConstruct
    public void init() {

        TokenSettings tokenSettings = TokenSettings.builder()
                .accessTokenFormat(OAuth2TokenFormat.SELF_CONTAINED)
                .accessTokenTimeToLive(Duration.ofDays(1))
                .reuseRefreshTokens(false)
                .refreshTokenTimeToLive(Duration.ofDays(30))
                .build();


        ClientSettings clientSettings = ClientSettings.builder()
                .requireProofKey(true)
                .requireAuthorizationConsent(true)
                .build();

        RegisteredClient webClient = RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId("yelp")
                .clientSecret(passwordEncoder.encode("password"))
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantTypes(grantTypes -> {
                    grantTypes.add(AuthorizationGrantType.AUTHORIZATION_CODE);
                    grantTypes.add(AuthorizationGrantType.REFRESH_TOKEN);
                })
                .redirectUris(uris -> {
                    uris.add("http://localhost:9090/login/oauth2/code/yelp");
                        uris.add("http://localhost:8168/login/oauth2/code/yelp");
                })
                .postLogoutRedirectUris(uris -> {
                    uris.add("http://localhost:8168");
                })
                .scopes(scope -> {
                    scope.add(OidcScopes.OPENID);
                    scope.add(OidcScopes.EMAIL);
                    scope.add(OidcScopes.PROFILE);
                })
                .clientSettings(clientSettings)
                .tokenSettings(tokenSettings)
                .build();

        jpaRegisteredClientRepository.save(webClient);

    }
}
