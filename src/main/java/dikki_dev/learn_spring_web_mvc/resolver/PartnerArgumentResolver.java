package dikki_dev.learn_spring_web_mvc.resolver;

import dikki_dev.learn_spring_web_mvc.model.Partner;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


// Membuat "Custom Argument Resolver" dengan implementasi "HandlerMethodArgumentResolver" Interface
@Component
public class PartnerArgumentResolver implements HandlerMethodArgumentResolver {

    // Wajib Override
    // Ambil di mana parameternya sesuai "Partner.class"
    // Jika ada di Controller method tipe data parameter dari "Partner.class" otomatis akan masuk ke Resolver ini
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Partner.class);
    }

    // Wajib Override
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest servletRequest = (HttpServletRequest) webRequest.getNativeRequest();

        // User wajib mengirimkan Header "X-API-KEY"
        String apiKey = servletRequest.getHeader("X-API-KEY");

        // Jika apiKey nya ada maka kita query ke database, dan membuat Partner baru
        if(apiKey != null){
            ///  TODO: Membuat Partner baru di Database dan return hasilnya
            return new Partner(apiKey, "Sample Partner"); // Contoh return hasil dari create Partner di Database nya
        }

        throw new RuntimeException("Unauthorized Exception");
    }
}
