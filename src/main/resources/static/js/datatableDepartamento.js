$(document).ready( function () {
	 var table = $('#departamentoTabla').DataTable({
			"sAjaxSource": "/rest/departamentosRest",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "nombre"},
		      { "mData": "responsable" }
			]
	 })
});
