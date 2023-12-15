//package pl.aplikacja.bot.botApi;
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.http.server.PathContainer;
//import org.springframework.web.util.pattern.PathPatternParser;
//
//public class VaadinSecurityUtils {
//    static final PathPatternParser pathPatternParser = new PathPatternParser();
//
//    public static boolean isVaadinInternalRequest(HttpServletRequest vaadinRequest) {
//        String requestPath = vaadinRequest.getPathInfo();
//        return requestPath != null && pathPatternParser.parse("/**/vaadinServlet/**").matches(PathContainer.parsePath(requestPath));
//    }
//}