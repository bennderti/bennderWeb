

var PaginadorBeneficio = { 
   paginador: {},
   cargaBeneficios:function(){        
        this.paginar(0,0);
   },
   paginar:function(indicePagina,esInicial){    
        ModalLoading.mostrar();
        $.ajax({
            url: context+"/categoria/beneficiosPaginados.html",
            type: 'GET',
            dataType: 'JSON',
            data:{indicePagina:indicePagina,esInicial:esInicial,idCatP:PaginadorBeneficio.getInfoCat().idCatP,idCat:PaginadorBeneficio.getInfoCat().idCat},
            success: function (data) {
                ModalLoading.cerrar();
                PaginadorBeneficio.showBeneficioPaginados(data.beneficios,data.paginador);
            },
            error: function (x, y, z) {
                ModalLoading.cerrar();
                ModalBennder.mostrar({tipo: "error", mensaje: "Problemas al cargar beneficios", titulo: "Beneficios"});
            }
        });
   },
   setInfoCat:function(idCatP,idCat){
       $("#idCategoriaPadre").val(idCatP);
       $("#idCategoria").val(idCat);
   },
   getInfoCat:function(){      
      return {idCatP:parseInt($("#idCategoriaPadre").val()),idCat:parseInt($("#idCategoria").val())};
   },
   generarIndicePagina:function(total,cantidadPagina,indiceActive){
       
       var nPaginas = total/cantidadPagina;
       if(nPaginas === 0){
           nPaginas = 1;
       }
       var html = "";
       for(var i = 0; i < nPaginas; i++){
           //html+='<li><a href="#" onclick="PaginadorBeneficio.paginar('+i+',1);">'+(i+1)+'</a></li>'; 
           //html+='<li id="idx-'+i+'" style="cursor: pointer;">'+(i+1)+'</li>'; 
           html+='<li id="idx-'+i+'"><a href="#">'+(i+1)+'</a></li>'; 
       }
       $(".pagination ul").html(html);
       $(".pagination ul li:eq("+indiceActive+")").html(indiceActive+1)
                                                  .addClass("active");
       $(".pagination ul li").off();
       $(".pagination ul li").on("click",function(){
           var idx = $(this).attr("id").split("-")[1];
           PaginadorBeneficio.paginar(parseInt(idx),1);
       });
   },
   showBeneficioPaginados:function(arrayBeneficio,paginador){
       //.- set info paginación
       this.setInfoCat(paginador.categoria.idCategoriaPadre,paginador.categoria.idCategoria);
       //.- Datos paginador
       this.paginador = paginador;
       //.- generar lista A
       this.generarListaA(arrayBeneficio);
       //.- generar lista B
       this.generarListaB(arrayBeneficio);       
       //.- generar indices de páginas
       this.generarIndicePagina(paginador.total,paginador.cantidadPagina,paginador.indicePagina);
       //.- genera show results
       this.generarShowResult(paginador.total,paginador.cantidadPagina,paginador.indicePagina);
       
   },
   generarShowResult:function(t,c,i){
       //var texto = "Mostrando "+(c)+"-"+(i+1)*c +" de "+t+" beneficios";
       var texto = "Mostrando "+(c)+" de "+t+" beneficios";
       $(".show-result p").html(texto);
   
   },
   formatPesos:function(pesos){
       var value = pesos;
       var num = '$ ' + value.toFixed(0).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1.");
       return num;
   },
   generaCalificacion:function(calificacion){
       var html = '<div class="pro-rating">';
       
       if(calificacion === 1){
           html+='<i class="fa fa-star"></i>';
       }
       if(calificacion === 2){
           html+='<i class="fa fa-star"></i><i class="fa fa-star"></i>';
       }       
       if(calificacion === 3){
           html+='<i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i>';
       }       
       if(calificacion === 4){
           html+='<i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i>';
       }       
       if(calificacion === 5){
           html+='<i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i>';
       }     
       html+='</div>';
       return html;
   },
   generarListaA:function(arrayBeneficio){
       //.- generar lista A
       var mix = "";
       for(var i= 0 ;i < arrayBeneficio.length; i++){
           var beneficio = arrayBeneficio[i];
           //.- html -> mix (inicio)
           mix += '<div class = "mix '+beneficio.nombreProveedor+' ranking-'+beneficio.calificacion+' col-lg-4 col-md-4 col-sm-4" ';
           if(beneficio.tipoBeneficio.idTipoBeneficio === 2){
               mix+= ' data-precioOferta="'+beneficio.precioOferta+'" ';
           }
           if(beneficio.tipoBeneficio.idTipoBeneficio === 1){
               mix+= ' data-descuento="'+beneficio.porcentajeDescuento+'" ';
           } 
           mix += '>';
           //single-product
           var singleProduct = '<div class="single-product">';
           //sproductIimg
           var productIimg = '<div class="product-img" >';
           
            productIimg+=' <a href="/BennderWeb/detalleBeneficio/'+beneficio.idBeneficio+'.html" >'+
                         '             <img class="primary-img" src="'+beneficio.imagenesBeneficio[0].urlImagen+'"/>'+
                         '             <img class="secondary-img" src="'+beneficio.imagenesBeneficio[1].urlImagen+'" />'+
                         ' </a>';                             
           productIimg+= ' <div class="product-action hidden">'+
                         '     <div class="pro-button-top">'+
                         '         <a href="#">add to cart</a>'+
                         '     </div>'+
                         '     <div class="pro-button-bottom">'+
                         '         <a href="#"><i class="fa fa-heart"></i></a><a href="#"><i class="fa fa-retweet"></i>'+
                         '         </a><a href="#"><i class="fa fa-search-plus"></i></a>'+
                         '     </div>'+
                         ' </div>';
           
           productIimg+='</div>';
           singleProduct+=productIimg;
           //product-info
            var productInfo = '<div class="product-info">';
           
            productInfo+='<h3><a href="/BennderWeb/detalleBeneficio/'+beneficio.idBeneficio+'.html" >'+beneficio.titulo+'</a></h3>'+
                        '<h4>'+beneficio.nombreProveedor+'</h4>';
             if(beneficio.tipoBeneficio.idTipoBeneficio === 1){
                productInfo+='<div class="pro-price">'+
                             '    <span class="normal">'+beneficio.porcentajeDescuento+' %</span>'+
                             '</div>';
             }   
             if(beneficio.tipoBeneficio.idTipoBeneficio === 2){
                 var precioOferta = this.formatPesos(beneficio.precioOferta);
                 var precioNormal = this.formatPesos(beneficio.precioNormal);
                  productInfo+='<div class="pro-price">'+
                               ' <span class="normal">'+precioOferta+'</span>'+
                               ' <span class="old">'+precioNormal+'</span>'+
                               '</div>';
             }
             productInfo+=this.generaCalificacion(beneficio.calificacion);   
             
           productInfo+='</div>';
           singleProduct+=productInfo;
           
           singleProduct+= '</div>';
           mix+=singleProduct;
           //.- html -> mix (fin)
           mix+='</div>';
       }
       
       $(".list.lista-a").html(mix);
   },
   generarListaB:function(arrayBeneficio){
       //.- generar lista A
       var mix = "";
       for(var i= 0 ;i < arrayBeneficio.length; i++){
           var beneficio = arrayBeneficio[i];
           //.- html -> mix (inicio)
           mix += '<div class="col-md-12">';
           
           //single-product
           var singleProduct = '<div class="single-product">';
           //sproductIimg
           var productIimg = '<div class="product-img">';
           
            productIimg+=' <a href="/BennderWeb/detalleBeneficio/'+beneficio.idBeneficio+'.html" >'+
                         '             <img class="primary-img" src="'+beneficio.imagenesBeneficio[0].urlImagen+'"/>'+
                         '             <img class="secondary-img" src="'+beneficio.imagenesBeneficio[1].urlImagen+'" />'+
                         ' </a>';                             
           productIimg+= ' <div class="product-action hidden">'+
                         '     <div class="pro-button-top">'+
                         '         <a href="#">add to cart</a>'+
                         '     </div>'+
                         '     <div class="pro-button-bottom">'+
                         '         <a href="#"><i class="fa fa-heart"></i></a><a href="#"><i class="fa fa-retweet"></i>'+
                         '     </a><a href="#"><i class="fa fa-search-plus"></i></a>'+
                         '     </div>'+
                         ' </div>';
           
           productIimg+='</div>';
           singleProduct+=productIimg;
           //product-info
            var productInfo = '<div class="product-info">';
           
            productInfo+='<h3><a href="/BennderWeb/detalleBeneficio/'+beneficio.idBeneficio+'.html" >'+beneficio.titulo+'</a></h3>'+
                        '<h4>'+beneficio.nombreProveedor+'</h4>';
             if(beneficio.tipoBeneficio.idTipoBeneficio === 1){
                productInfo+='<div class="pro-price">'+
                             '    <span class="normal">'+beneficio.porcentajeDescuento+' %</span>'+
                             '</div>';
             }   
             if(beneficio.tipoBeneficio.idTipoBeneficio === 2){
                 var precioOferta = this.formatPesos(beneficio.precioOferta);
                 var precioNormal = this.formatPesos(beneficio.precioNormal);
                  productInfo+='<div class="pro-price">'+
                               ' <span class="normal">'+precioOferta+'</span>'+
                               ' <span class="old">'+precioNormal+'</span>'+
                               '</div>';
             }
             productInfo+=this.generaCalificacion(beneficio.calificacion);             
             productInfo+='<div class="product-desc">'+
                         '   <p>'+beneficio.descripcion+'</p>'+
                         '</div>'+
                         '<div class="product-action">'+
                         '    <div class="pro-button-top">'+
                         '        <a href="#">add to cart</a>'+
                         '    </div>'+
                         '    <div class="pro-button-bottom">'+
                         '        <a href="#"><i class="fa fa-heart"></i></a><a href="#"><i class="fa fa-retweet"></i>'+
                         '    </a><a href="#"><i class="fa fa-search-plus"></i></a>'+
                         '    </div>'+
                         '</div>';
             
             
             
           productInfo+='</div>';
           singleProduct+=productInfo;
           
           singleProduct+= '</div>';
           mix+=singleProduct;
           //.- html -> mix (fin)
           mix+='</div>';
       }
       
       $(".shop-list.lista-b").html(mix);
   }
};



