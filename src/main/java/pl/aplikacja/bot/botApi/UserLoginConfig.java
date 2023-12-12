//package pl.aplikacja.bot.botApi;
//
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.core.AuthorizationGrantType;
//import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
//import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
//
//public class UserLoginConfig {
//
//
//    private static final String CLIENT_REGISTRATION_ID = "google";
//    private static final String CLIENT_ID = "544172631662-3sj598scne4q72lr9ou99b2ubf7ire7r.apps.googleusercontent.com";
//    private static final String CLIENT_SECRET = "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";
//    private static final String REDIRECT_URI = "{baseUrl}/login/oauth2/code/{registrationId}";
//
//
//    public static ClientRegistration.Builder getBuilder() {
//        return ClientRegistration.withRegistrationId(CLIENT_REGISTRATION_ID)
//                .clientId(CLIENT_ID)
//                .clientSecret(CLIENT_SECRET)
//                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .redirectUri(REDIRECT_URI)
//                .scope("openid", "profile", "email", "address", "phone")
//                .authorizationUri("https://accounts.google.com/o/oauth2/v2/auth")
//                .tokenUri("https://www.googleapis.com/oauth2/v4/token")
//                .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
//                .userNameAttributeName(IdTokenClaimNames.SUB)
//                .jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
//                .clientName("Google");
//    }
//}
