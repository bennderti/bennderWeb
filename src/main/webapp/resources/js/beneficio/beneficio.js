

var BeneficioBennder = {    
    getBeneficio:function(idBeneficio){
        ModalLoading.mostrar();
        $.ajax({
            url: context+"/getCuponBeneficio/"+idBeneficio+".html",
            type: 'GET',
            dataType: 'JSON',
            success: function (data) {
                ModalLoading.cerrar();
                if (data.validacion.codigo === '0') {
                    ModalBennder.mostrar({tipo: "informativo", mensaje: data.validacion.mensaje, titulo: "Obtención Beneficio"});
                } else {
                    ModalBennder.mostrar({tipo: "advertencia", mensaje: data.validacion.mensaje, titulo: "Obtención Beneficio"});
                }
            },
            error: function (x, y, z) {
                ModalLoading.cerrar();
                ModalBennder.mostrar({tipo: "error", mensaje: "Problemas al obtener beneficio", titulo: "Obtención Beneficio"});
            }
        });       
    }
};



