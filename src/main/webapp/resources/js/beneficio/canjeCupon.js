jQuery(document).on('ready', function () {
    $("#valida-cupon").click(function (e) {
        CanjeCupon.validaCanje();
        return false;
    });
    //aceptando numericos

    //.- restricciones caractéres
    $("#password-sucursal").alphanumeric({allow: ".-_"});
    $("#id-vendedor").numeric();

    //.- enter 
    $("#id-vendedor,#password-sucursal").keyup(function (e) {
        if (e.keyCode === 13) {
            CanjeCupon.validaCanje();
        }
    });

});

var CanjeCupon = {    
    validacion:function(){
        if($.trim($("#id-vendedor").val()) === ""){
            return {mensaje:"Favor completar rut de vendedor sin digito verificador",isValid : false};
        }
        if($.trim($("#direccion-sucursal").val()) === "-1"){
            return {mensaje:"Favor seleccionar sucursal",isValid : false};
        }
        if($.trim($("#password-sucursal").val()) === ""){
            return {mensaje:"Favor completar password de sucursal",isValid : false};
        }
        return {mensaje:"OK",isValid : true};
    },
    validaCanje: function () {
        var val = this.validacion();
        if(!val.isValid){
            ModalBennder.mostrar({tipo: "advertencia", mensaje: val.mensaje, titulo: "Validación Cupón"});
            return false;
        }
        ModalLoading.mostrar();
        $.ajax({
            url: 'validacionCanjeCuponPOS.html',
            type: 'POST',
            dataType: 'JSON',
            data: $("#form-valida-canje-cupon").serialize(),
            success: function (data) {
                ModalLoading.cerrar();
//                if (data.validacion.codigo === '0') {
//                    window.location.href = data.goToUrl;
//                } else {
//                    ModalBennder.mostrar({tipo: "advertencia", mensaje: data.validacion.mensaje, titulo: "Login"});
//                }
    
                ModalBennder.mostrar({tipo: "informativo", mensaje: data.validacion.mensaje, titulo: "Validación Cupón"});
                
            },
            error: function (x, y, z) {
                ModalLoading.cerrar();
                ModalBennder.mostrar({tipo: "error", mensaje: "Problemas al validar usuario", titulo: "Validación Cupón"});
            }
        });
    }
};



