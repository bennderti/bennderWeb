jQuery(document).on('ready', function () {
    
        //.- restricciones caractéres
    //$("#nombre-proveedor").alphanumeric({allow: ".-_"});
    $("#ipt-celular,#ipt-fonoFijo").numeric();
    
});

var Perfil = {
    onCancelar:function(){
        window.location.href = "home.html";
    },
    cambiarPassword:function(){
        
    },
    onChangeRegion:function(){
        var idRegion = $("#select-region").val();
        if(idRegion!=='-1'){
            $.ajax({
                url: context+'/perfil/getComunaByIdReg.html',
                type: 'GET',
                dataType: 'JSON',
                data: {idRegion:idRegion},
                success: function (array) {
                    if(array !==undefined && array !== null){
                        $("#select-comunas option").remove();
                        $("#select-comunas").append("<option value ='-1'>--Seleccione Comuna--</option>");
                        for(var i= 0;i < array.length;i++){
                           var c = array[i];
                           $("#select-comunas").append("<option value ='"+c.idComuna+"'>"+c.nombre+"</option>");
                        } 
                    }
                },
                error: function (x, y, z) {
                    ModalBennder.mostrar({tipo: "error", mensaje: "Error al cargar comunas", titulo: "Comuna"});
                }
            }); 
        }
        else{
            ModalBennder.mostrar({tipo: "advertencia", mensaje: "Favor seleccionar región.", titulo: "Región"});
        }
    },
    onValidaGuardaPerfil:function(){
        
        ModalLoading.mostrar();
        $.ajax({
            url: context+'/perfil/guardar.html',
            type: 'POST',
            dataType: 'JSON',
            data: $("#form-perfil").serialize(),
            success: function (data) {                
                if(data!==null && data !=='undefined'){
                    if(data.codigoNegocio === '0' && data.codigo ==='0'){                        
                      window.location.href = "../home.html";
                    }
                    else{
                        ModalLoading.cerrar();
                        ModalBennder.mostrar({tipo: "error", mensaje: data.mensaje, titulo: "Datos Perfil"});
                    }
                    
                }
                else{
                    ModalLoading.cerrar();
                    ModalBennder.mostrar({tipo: "error", mensaje:"Problemas al guardar datos de perfil" , titulo: "Datos Perfil"});
                }
            },
            error: function (x, y, z) {
                ModalLoading.cerrar();
                ModalBennder.mostrar({tipo: "error", mensaje: "Problemas al guardar información  de perfil", titulo: "Datos Perfil"});
            }
        });
    }
};

