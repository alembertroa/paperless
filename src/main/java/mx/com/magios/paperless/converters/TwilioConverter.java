package mx.com.magios.paperless.converters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TwilioConverter{

    public String convertUrl(String url, String to, String from, String message){
        StringBuilder builder = new StringBuilder();
        builder
                .append(url)
                .append("To=whatsapp")
                .append(to)
                .append("From=whatsapp")
                .append(from).append("Body=")
                .append(message);

        return builder.toString();
    }
}
