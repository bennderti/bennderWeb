jQuery(document).on('ready', function() {
     $("#input-login").click(function(e){
         login();
         return false;
     });
     //aceptando numericos
     $("#user-login").numeric();
});


function login(){
    ModalLoading.mostrar();
    $.ajax({
    url: 'login.html',
    type: 'POST',
    dataType: 'JSON',
    data: $("#form-login").serialize(),
    success: function(data) {
        if(data.validacion.codigo === '0'){
            window.location.href = data.goToUrl;
        }
        else{
            ModalBennder.mostrar({tipo:"advertencia",mensaje:data.validacion.mensaje,titulo:"Login"});
        }
        ModalLoading.cerrar();
    },
    error:function(x,y,z){
        ModalLoading.cerrar();
        ModalBennder.mostrar({tipo:"error",mensaje:"Problemas al validar usuario",titulo:"Login"});
    }
});
    
}

