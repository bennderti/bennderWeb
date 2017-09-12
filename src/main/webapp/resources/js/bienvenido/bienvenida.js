/* 
 * @author mgutierrez
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var BienvenidaBennder = {
    siguiente:function(){
     
        var listaCategoriasSeleccionadas = [];
     
        $('li.selected span.text').each(function(index){
            
//            alert("index: " + index);
            
            listaCategoriasSeleccionadas[index] = $(this).attr('id');
            
//            listaCategoriasSeleccionadas.push($(this).attr('id'));          
        })
        
        if(listaCategoriasSeleccionadas.length>0)
        {
            $.ajax({
                url: context+'/bienvenido/guardarDatosBienvenida.html',
                type: 'POST',
                data: {listaCategoriasSelec:listaCategoriasSeleccionadas},
                dataType: 'json',
                traditional:true,
                success: function (data) {
                    if(data!==null && data !=='undefined')
                    {
                        if(data.codigo=="0")
                        {
                            if(data.codigoNegocio=="0")
                            {                            
                                window.location.href = context+"/home.html";
                            }
                            else
                                ModalBennder.mostrar({tipo: "error", mensaje: data.mensaje, titulo: "Bienvenida a Bennder"});
                        }
                        else
                            ModalBennder.mostrar({tipo: "error", mensaje: data.mensaje , titulo: "Bienvenida a Bennder"});

                    }
                    else{
                        ModalBennder.mostrar({tipo: "error", mensaje:"Problemas al guardar su información" , titulo: "Bienvenida a Bennder"});
                    }
                },
                error: function (x, y, z) {
                    ModalBennder.mostrar({tipo: "error", mensaje: "Error", titulo: "Publicación de Beneficios"});
                }
            }); 
        }
        else
        {
            ModalBennder.mostrar({tipo: "informativo", mensaje: "Debe seleccionar al menos una categoría", titulo: "Bienvenida a Bennder"});
        }
    }
}