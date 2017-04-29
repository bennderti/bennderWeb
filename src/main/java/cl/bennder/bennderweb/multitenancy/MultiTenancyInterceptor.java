package cl.bennder.bennderweb.multitenancy;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Diego on 05-04-2017.
 */
@Component
public class MultiTenancyInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
            throws Exception {
        Map<String, Object> pathVars = (Map<String, Object>) req.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        if (pathVars.containsKey("tenantId")) {
            req.setAttribute("CURRENT_TENANT_IDENTIFIER", pathVars.get("tenantid"));
            TenantContext.setCurrentTenant(pathVars.get("tenantId").toString());
            return true;
        }
        res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        res.setContentType(MediaType.APPLICATION_JSON_VALUE);
        res.getWriter().write("{\"error\": \"No tenant supplied\"}");
        res.getWriter().flush();
        return false;
    }

    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        TenantContext.clear();
    }
}