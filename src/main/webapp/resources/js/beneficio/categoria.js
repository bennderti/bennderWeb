/**
 * Created by Diego on 30-06-2017.
 */
$(function () {
	//Filtro de precio
	$( '#btn-filtrar-precio' ).on('click', function () {
		console.log($( '#amount' ).val());
		console.log("MIN IS " + miPri);
		console.log("MAX IS " + mxPri);
		Filtrador.filtrarPorPrecio(miPri, mxPri);
	});

    //Filtro de descuento
	$( '#btn-filtrar-descuento' ).on('click', function () {
		console.log($( '#amount' ).val());
		console.log("MIN IS " + miDes);
		console.log("MAX IS " + mxDes);
		Filtrador.filtrarPorDescuento(miDes, mxDes);
	});

    //Filtro de categorias
    $( '#filtrosProveedor li a' ).on('click', function () {
        console.log("filtrando por: " + $(this).data('filter'));
        Filtrador.filtrarPorProveedor($(this).data('filter'));
    });
});

var Filtrador = {
	filtrarPorPrecio:function (precioMin, precioMax) {
		ModalLoading.mostrar();
		var inputCategoriaSeleccionada = $('#inputCategoriaSeleccionada').val();

		$.ajax({
			url: context+'/categoria/filtrarBeneficiosPorPrecio.html',
			type: 'GET',
			dataType: 'JSON',
			data: {
				categoriaSeleccionada: inputCategoriaSeleccionada,
				precioMin: precioMin,
				precioMax: precioMax
			}
		})
			.done(function (data) {
				console.log(data);

				$('div .list').html("");
				$.each(data.beneficios, function(index, beneficio){
					console.log("datos obtenidos de beneficio");
					console.log(beneficio);
					Filtrador.renderearBeneficio(beneficio)
				});
			})
            .fail(function (jqXHR, textStatus, errorThrown) {
                console.log("Error filtrando beneficios por precio");
                console.log(textStatus);
                console.log(errorThrown);
            })
			.always(function () {
                ModalLoading.cerrar();
            });
	},

	filtrarPorDescuento:function (descMin, descMax) {
		/*$(".list div.mix").hide().filter(function () {
			var price = parseInt($(this).data("descuento"), 10);
			return price >= descMin && price <= descMax;
		}).show();*/
        ModalLoading.mostrar();
        var inputCategoriaSeleccionada = $('#inputCategoriaSeleccionada').val();

        $.ajax({
            url: context+'/categoria/filtrarBeneficiosPorDescuento.html',
            type: 'GET',
            dataType: 'JSON',
            data: {
                categoriaSeleccionada: inputCategoriaSeleccionada,
                descuentoMin: descMin,
                descuentoMax: descMax
            }
        })
            .done(function (data) {
                console.log(data);

                $('div .list').html("");
                $.each(data.beneficios, function(index, beneficio){
                    console.log("datos obtenidos de beneficio");
                    console.log(beneficio);
                    Filtrador.renderearBeneficio(beneficio)
                });
            })
            .fail(function (jqXHR, textStatus, errorThrown) {
                console.log("Error filtrando beneficios por descuento");
                console.log(textStatus);
                console.log(errorThrown);
            })
            .always(function () {
                ModalLoading.cerrar();
            });
	},

    filtrarPorProveedor:function (proveedor) {
        ModalLoading.mostrar();
        var inputCategoriaSeleccionada = $('#inputCategoriaSeleccionada').val();

        $.ajax({
            url: context+'/categoria/filtrarBeneficiosPorProveedor.html',
            type: 'GET',
            dataType: 'JSON',
            data: {
                proveedor: proveedor,
                categoriaSeleccionada: inputCategoriaSeleccionada
            }
        })
            .done(function (data) {
                console.log(data);

                $('div .list').html("");
                $.each(data.beneficios, function(index, beneficio){
                    console.log("datos obtenidos de beneficio");
                    console.log(beneficio);
                    Filtrador.renderearBeneficio(beneficio)
                });
            })
            .fail(function (jqXHR, textStatus, errorThrown) {
                console.log("Error filtrando beneficios por descuento");
                console.log(textStatus);
                console.log(errorThrown);
            })
            .always(function () {
                ModalLoading.cerrar();
            });
    },

	renderearBeneficio:function(beneficio) {
		var item = '<div class="' + beneficio.nombreProveedor + ' ranking-' + beneficio.calificacion + ' col-lg-4 col-md-4 col-sm-4"';
		switch (beneficio.tipoBeneficio.idTipoBeneficio) {
			case 2:
				item += 'data-precioOferta="' + beneficio.precioOferta + '"';
				break;
			case 1:
				item += 'data-descuento="' + beneficio.porcentajeDescuento + '"';
				break;
		}
		item += '>';
		item += '<div class="single-product">' +
				'   <div class="product-img">' +
				'       <a href="/detalleBeneficio/' + beneficio.idBeneficio + '.html">';

		if (beneficio.imagenesBeneficio.size != 0){
			item += '           <img class="primary-img" src="' + beneficio.imagenesBeneficio[0].urlImagen + '"/>' +
					'           <img class="secondary-img" src="' + beneficio.imagenesBeneficio[1].urlImagen + '" />'
		}
		else {
            item += '           <img class="primary-img" src="/resources/img/product/1.jpg"/>' +
                    '           <img class="secondary-img" src="/resources/img/product/2.jpg"/>';
        }
		item += '       </a> ' +
                '       <div class="product-action hidden">' +
                '           <div class="pro-button-top">' +
                '               <a href="#">add to cart</a>' +
                '           </div>' +
                '           <div class="pro-button-bottom">' +
                '               <a href="#"><i class="fa fa-heart"></i></a><a href="#"><i class="fa fa-retweet"></i></a>' +
                '               <a href="#"><i class="fa fa-search-plus"></i></a>' +
                '           </div>' +
                '       </div>' +
                '   </div>' +
                '<div class="product-info">' +
                '   <h3><a href="/detalleBeneficio/' + beneficio.idBeneficio + '.html">' + beneficio.titulo + '</a></h3>' +
                '   <h4>' + beneficio.nombreProveedor + '</h4>';

        switch (beneficio.tipoBeneficio.idTipoBeneficio){
            case 1:
                item += '   <div class="pro-price">' +
                        '       <span class="normal">' + beneficio.porcentajeDescuento + '%</span>' +
                        '   </div>';
                break
            case 2:
                item += '   <div class="pro-price">' +
                        '       <fmt:setLocale value="es_CL" scope="session"/>' +
                        '       <span class="normal">' +
                        '           <fmt:formatNumber value="' + beneficio.precioOferta + '" type="currency" currencySymbol="$"/>' +
                        '       </span>' +
                        '       <span class="old">' +
                        '           <fmt:formatNumber value="' + beneficio.precioNormal + '" type="currency" currencySymbol="$"/>' +
                        '       </span>' +
                        '   </div>';
                break
        }
        item += Filtrador.renderearCalificacion(beneficio.calificacion) +
                '</div>' +
                '</div>' +
                '</div>';

		$('div .list').append(item);

	},
    
    renderearCalificacion:function (calificacion) {
	    var htmlCalificacion = '<div class="pro-rating">' ;
        for (var i = 1; i <= calificacion; i++){
            htmlCalificacion += '   <i class="fa fa-star"></i>';
        }
        htmlCalificacion += '</div>';
        return htmlCalificacion;
    }
};

