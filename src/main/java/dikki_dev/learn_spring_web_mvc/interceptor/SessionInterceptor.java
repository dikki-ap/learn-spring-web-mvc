package dikki_dev.learn_spring_web_mvc.interceptor;

import dikki_dev.learn_spring_web_mvc.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

// Membuat Custom "Interceptor" wajib implement "HandlerInterceptor" dan wajib daftarkan sebagai Bean
@Component
public class SessionInterceptor implements HandlerInterceptor {

    // Method "sebelum Handling"
    // Jika ada user yang mencoba akses, dan belum login dibaca dari Session, maka akan di "re-direct" ke halaman login
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

        // Ambil current Session
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");

        // Jika data Session tidak ada maka arahkan ke halaman login
        if(user == null){
            response.sendRedirect("/login");
            return false; // "false" artinya tidak akan dilanjutkan ke "Interceptor" atau "Controller" lainnya
        }

        return true; // "true" artinya dilanjutkan ke "Interceptor" atau "Controller" lainnya
    }
}
