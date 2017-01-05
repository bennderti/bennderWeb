/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author dyanez
 */
@Component
public class Properties {
    
    public static String URL_SERVIDOR;

    @Value("${URL_SERVIDOR}")
    public void setUrlServidor(String urlServidor) {
        URL_SERVIDOR = urlServidor;
    } 
}
