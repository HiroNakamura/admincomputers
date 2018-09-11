$(document).ready( function () {
	 var table = $('#usuarioTabla').DataTable({
			"sAjaxSource": "/rest/usuariosRest",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "nombre"},
		      { "mData": "apellidos" },
		      { "mData": "usuario" },
		      { "mData": "password" },
		      { "mData": "cargo" },
		      { "mData": "computadora.bien" },
		      { "mData": "departamento.nombre" }
			]
	 })
});
