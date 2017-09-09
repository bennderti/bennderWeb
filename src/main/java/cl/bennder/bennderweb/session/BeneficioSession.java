/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bennder.bennderweb.session;

import cl.bennder.entitybennderwebrest.model.Beneficio;
import cl.bennder.entitybennderwebrest.model.Paginador;
import cl.bennder.entitybennderwebrest.model.Validacion;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 *
 * @author dyanez
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BeneficioSession {
    private List<Beneficio> beneficios;
    private Paginador paginador;

    public BeneficioSession() {
    }

    public BeneficioSession(List<Beneficio> beneficios, Paginador paginador) {
        this.beneficios = beneficios;
        this.paginador = paginador;
    }

    public List<Beneficio> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(List<Beneficio> beneficios) {
        this.beneficios = beneficios;
    }

    public Paginador getPaginador() {
        return paginador;
    }

    public void setPaginador(Paginador paginador) {
        this.paginador = paginador;
    }
    
}
