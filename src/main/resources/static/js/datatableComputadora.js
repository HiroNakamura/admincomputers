$(document).ready( function () {
	 var table = $('#computadoraTabla').DataTable({
			"sAjaxSource": "/rest/computadorasRest",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "bien"},
		      { "mData": "arrendado" },
		      { "mData": "asignado" },
		      { "mData": "ip" },
		      { "mData": "dns" },
		      { "mData": "red" },
		      { "mData": "operativo" },
		      { "mData": "maquina" },
		      { "mData": "tipo" },
		      { "mData": "modelo" },
		      { "mData": "dominio" },
		      { "mData": "ubicacion" },
		      { "mData": "administrador" },
		      { "mData": "estado" },
		      { "mData": "actualizada" },
		      { "mData": "departamento.nombre" }
			]
	 })
});
