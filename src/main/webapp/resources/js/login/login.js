
function login(){
    $.ajax({
    url: 'loginJs.html',
    type: 'POST',
    dataType: 'JSON',
    data: $("form").serialize(),
    success: function(data) {
        
        
        alert(data.validacion.mensaje);
    },
    error:function(x,y,z){
        alert("Error");
    }
});
    
}

