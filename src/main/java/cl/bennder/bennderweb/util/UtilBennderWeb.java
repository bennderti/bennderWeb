/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.util;

import cl.bennder.bennderweb.multitenancy.TenantContext;
import cl.bennder.bennderweb.services.CargadorServicesImpl;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerMapping;

/**
 *
 * @author ext_dayanez
 */
public class UtilBennderWeb {
    
     
    private static final Logger log = LoggerFactory.getLogger(UtilBennderWeb.class);
    public static  String getTenantId(HttpServletRequest req){
        String tenantId = null;
        
        try {
            /* Map<String, Object> pathVars = (Map<String, Object>) req.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

            if (pathVars.containsKey("tenantId")) {
               tenantId = pathVars.get("tenantId").toString();
               log.info("tenantId encontrado ->{}",tenantId);
            }*/

            tenantId = req.getServerName().split("\\.")[0];
            if (!tenantId.isEmpty() || tenantId.equalsIgnoreCase("www")){
                log.info("tenantId encontrado ->{}",tenantId);
            }
            else{
                log.info("tenantId NO encontrado");
            }     
        } catch (Exception e) {
            log.error("Exception en getTenantId.",e);
            tenantId = null;
        }

        return tenantId;
    }
}
