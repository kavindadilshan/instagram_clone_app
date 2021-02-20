package lk.ijse.ws.instagram.instagram_clone.filter;



import lk.ijse.ws.instagram.instagram_clone.entity.User;
import lk.ijse.ws.instagram.instagram_clone.repository.UserRepository;
import lk.ijse.ws.instagram.instagram_clone.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter
public class AuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private ProfileDetailRepository profileDetailRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String token = httpServletRequest.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer")) {

            token = token.substring(7);
            System.out.println("token : "+token);

            String username = jwtTokenUtil.getUsernameFromToken(token);

            User user = userRepository.getUserByUsername(username);

            httpServletResponse.setHeader("token", jwtTokenUtil.generateToken(user));
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);

    }

}