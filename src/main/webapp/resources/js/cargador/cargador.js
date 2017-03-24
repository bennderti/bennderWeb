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
    cargarCategoriaProveedor:function(){
        var id=$("#select-proveedores").val();
        $.ajax({
            url: 'obtenerCategoriaByProveedor.html',
            type: 'GET',
            dataType: 'JSON',
            data: {id:id},
            success: function (response) {
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
                    for(var i= 0;i < response.beneficios.length;i++){
                       var b = response.beneficios[i];
                       $("#select-beneficio").append("<option value ='"+b.idBeneficio+"'>"+b.titulo+"</option>");
                       
                    } 
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



