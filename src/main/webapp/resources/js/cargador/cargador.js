jQuery(document).on('ready', function () {

    
    $("#select-proveedores").on("change",function(){
        Cargador.cargarCategoriaProveedor();
    });

    $("#select-categorias").on("change",function(){
        Cargador.cargarSubCatById();
    });
    $("#select-sub-categorias").on("change",function(){
        Cargador.cargarBeneficioByIdCat();
    });
});
var Cargador = {
    onSelectPrincipal:function(index){
       $("#input-indexPrincipal").val(index); 
    },
    uploadImagesBeneficios:function(){
       if($("#select-beneficio").val() === "-1"){
           ModalBennder.mostrar({tipo: "error", mensaje: "Favor seleccionar beneficio", titulo: "Cargador"});
       }
       else{
           //<input type="hidden" name="indexPrincipal" id="input-indexPrincipal"/>
           ModalLoading.mostrar();
           $("#input-idBeneficio").val($("#select-beneficio").val());
           $("#btn-upload-images-submit").click();
       } 
    },
    addFile:function(){
        var fileIndex = $('#fileTable tr').children().length;
        if(fileIndex !== undefined){
//            $('#fileTable').append(
//				'<tr><td>'+
//				'	<input type="file" name="files['+ fileIndex +']" />'+
//				'</td></tr>');
                        
                        
            $('#fileTable').append(            
                                    '<tr>'+
                                    '    <td>'+
                                    '        <div class="input-group">'+
                                    '            <span class="input-group-addon beautiful">'+
                                    '                <input type="radio" name="optradio" onclick="Cargador.onSelectPrincipal('+ fileIndex +')"> Principal '+
                                    '            </span> '+
                                    '            <input name="files['+ fileIndex +']" type="file" class="form-control">'+
                                    '        </div>'+
                                    '    </td>'+
                                    '</tr>');
        }
		
    },
    limpiaSelectores:function(){
        $("#select-categorias option").remove();
        $("#select-categorias").append("<option value ='-1'>Seleccione categoria...</option>");        
        $("#select-beneficio option").remove();
        $("#select-beneficio").append("<option value ='-1'>Seleccione beneficio...</option>");
        $("#select-sub-categorias option").remove();
        $("#select-sub-categorias").append("<option value ='-1'>Seleccione sub categoria...</option>");
        
    },
    mostrarUploadImagenes:function(mostrar){
        $("div.images-upload").css("display",mostrar?"block":"none");
        
    },
    cargarCategoriaProveedor:function(){
        var id=$("#select-proveedores").val();
        $.ajax({
            url: 'obtenerCategoriaByProveedor.html',
            type: 'GET',
            dataType: 'JSON',
            data: {id:id},
            success: function (response) {
                Cargador.limpiaSelectores();
                if(response !==undefined && response !== null){
                    $("#select-categorias option").remove();
                    $("#select-categorias").append("<option value ='-1'>Seleccione categoria...</option>");
                    for(var i= 0;i < response.categorias.length;i++){
                       var c = response.categorias[i];
                       $("#select-categorias").append("<option value ='"+c.idCategoria+"'>"+c.nombre+"</option>");
                    } 
                }
                
            },
            error: function (x, y, z) {
                ModalBennder.mostrar({tipo: "error", mensaje: "Error al cargar categorias", titulo: "Cargador"});
            }
        }); 
    },
    cargarBeneficioByIdCat:function(){
        var id=$("#select-sub-categorias").val();
        $.ajax({
            url: 'getBeneficiosByIdCat.html',
            type: 'GET',
            dataType: 'JSON',
            data: {id:id},
            success: function (response) {
                if(response !==undefined && response !== null){
                    $("#select-beneficio option").remove();
                    $("#select-beneficio").append("<option value ='-1'>Seleccione beneficio...</option>");
                    Cargador.mostrarUploadImagenes(response.beneficios.length > 0);
                    
                    for(var i= 0;i < response.beneficios.length;i++){
                       var b = response.beneficios[i];
                       $("#select-beneficio").append("<option value ='"+b.idBeneficio+"'>"+b.titulo+"</option>");
                       
                    } 
                }
                else{
                   Cargador.mostrarUploadImagenes(false); 
                }
            },
            error: function (x, y, z) {
                ModalBennder.mostrar({tipo: "error", mensaje: "Error al cargar subctegorias", titulo: "Cargador"});
            }
        }); 
    },
    cargarSubCatById:function(){
        var id=$("#select-categorias").val();
        $.ajax({
            url: 'getSubCatById.html',
            type: 'GET',
            dataType: 'JSON',
            data: {id:id},
            success: function (response) {
                if(response !==undefined && response !== null){
                    $("#select-sub-categorias option").remove();
                    $("#select-sub-categorias").append("<option value ='-1'>Seleccione sub categoria...</option>");
                    for(var i= 0;i < response.categorias.length;i++){
                       var c = response.categorias[i];
                       $("#select-sub-categorias").append("<option value ='"+c.idCategoria+"'>"+c.nombre+"</option>");
                    } 
                }
            },
            error: function (x, y, z) {
                ModalBennder.mostrar({tipo: "error", mensaje: "Error al cargar subctegorias", titulo: "Cargador"});
            }
        }); 
        
    }
};



