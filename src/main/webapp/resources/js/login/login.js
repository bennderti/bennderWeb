jQuery(document).on('ready', function() {
     $("#input-login").click(function(e){
         login();
         return false;
     });
});


function login(){
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
    },
    error:function(x,y,z){
        ModalBennder.mostrar({tipo:"error",mensaje:"Problemas al validar usuario",titulo:"Login"});
    }
});
    
}

