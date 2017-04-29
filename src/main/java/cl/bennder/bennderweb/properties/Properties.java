/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 *
 * @author dyanez
 * using in jsp: http://forum.spring.io/forum/spring-projects/container/119045-how-to-get-a-property-placeholder-variable-in-a-jsp
 * other: https://www.mkyong.com/spring/spring-propertysources-example/
 * */

@Configuration
@PropertySource("classpath:bennder.properties")
public class Properties {

    public static String URL_SERVIDOR;

    @Value("${URL_SERVIDOR}")
    public void setUrlServidor(String urlServidor) {
        URL_SERVIDOR = urlServidor;
    } 
    
}
