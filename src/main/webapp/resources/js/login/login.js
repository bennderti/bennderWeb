jQuery(document).on('ready', function() {
     $("#input-login").click(function(e){
         login();
         return false;
     });
});


function login(){
    $.ajax({
    url: 'loginJs.html',
    type: 'POST',
    dataType: 'JSON',
    data: $("#form-login").serialize(),
    success: function(data) {
        window.location.href = "home.html";
        //alert(data.validacion.mensaje);
    },
    error:function(x,y,z){
        alert("Error");
    }
});
    
}

