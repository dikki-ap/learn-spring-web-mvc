package dikki_dev.learn_spring_web_mvc.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Membuat Custom Converter dari String to Date
// Converter ini nantinya akan dibaca otomatis oleh Spring ketika Spring membutuhkan Convert dari String ke Date
@Component
@Slf4j
public class StringToDateConverter implements Converter<String, Date> {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


    @Override
    public Date convert(String source) {
        try{
            return simpleDateFormat.parse(source);
        }catch (ParseException ex){
            log.warn("Error convet date from string {}", source, ex);
            return null;
        }
    }
}
