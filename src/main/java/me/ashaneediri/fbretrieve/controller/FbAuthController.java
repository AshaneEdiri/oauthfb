package me.ashaneediri.fbretrieve.controller;

import me.ashaneediri.fbretrieve.service.FbAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Controller class to grant authorization and for redirection.
 *
 */
@Controller
@RequestMapping("/api/facebook")
public class FbAuthController {

    @Autowired
    private FbAuthService fbAuthService;

    @GetMapping("/grant")
    public void grantPermissions(@RequestParam(value = "code", required = false) String code,
                                 @RequestParam(value = "error_code", required = false) String errorCode,
                                 HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (code != null) {

            if (fbAuthService.obtainAccessToken(code).equals("bearer")) {
                HttpSession httpSession = request.getSession(true);
                response.sendRedirect("/home.html");
                return;
            }
            response.sendRedirect("/index.html");
            return;
        }
        response.sendRedirect("/index.html");
    }
}
