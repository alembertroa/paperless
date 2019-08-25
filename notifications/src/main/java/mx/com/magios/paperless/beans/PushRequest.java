package mx.com.magios.paperless.beans;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PushRequest implements Serializable{

    private static final long serialVersionUID = -2252770703338727900L;

    private String to;

    private String message;

}
