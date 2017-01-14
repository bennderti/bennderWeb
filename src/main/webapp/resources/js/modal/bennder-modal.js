jQuery(document).on('ready', function() {
	$('#myModal').modal({
		  backdrop: 'static',
		  keyboard: false,
		  show:false
        }); 		
        $('#myModal').on('shown.bs.modal', function () {
                  console.log("shown.bs.modal!!!");
        });
});
//.- Logica de mostrar modal genérico

var ModalBennder  = {
    
    TIPO:{
        INFORMATIVO:"informativo",
        ADVERTENCIA:"advertencia",
        ERROR:"error"        
    },
    mostrar:function(opt){
       //.- objeto
       //{titulo:,mensaje,tipo,eventoAceptar,eventoCancelar};
       $("div.modal-bennder .modal-content .modal-title").html(opt.titulo);
       $("div.modal-bennder .modal-content .modal-text").html(opt.mensaje);
       $('#myModal').modal('show');
       
       //.- Listener
    }
};