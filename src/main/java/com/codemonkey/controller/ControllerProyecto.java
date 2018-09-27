package com.codemonkey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable ;

import com.codemonkey.service.DepartamentoService;
import com.codemonkey.service.UsuarioService;
import com.codemonkey.service.ComputadoraService;

import com.codemonkey.service.UsuarioCrudService;
import com.codemonkey.service.ComputadoraCrudService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import com.codemonkey.entity.Computadora;
import com.codemonkey.entity.Departamento;
import com.codemonkey.entity.Usuario;
import com.codemonkey.config.Propiedades;
import com.codemonkey.repository.UsuarioRepositoryPage;
import com.codemonkey.repository.ComputadoraRepositoryPage;
import com.codemonkey.model.PagerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;


@Controller
public class ControllerProyecto{

    private final Logger LOGGER = LoggerFactory.getLogger(ControllerProyecto.class);

    /*Paginacion*/
    private static final int BUTTONS_TO_SHOW = 3;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 3;
    private static final int[] PAGE_SIZES = { 3, 10};
    /*Paginacion*/

     @Autowired
     private UsuarioRepositoryPage usuarioRepositoryPage;
     
     @Autowired
     private ComputadoraRepositoryPage computadoraRepositoryPage;
    
    
	@Value("${aplicacion.home}")
    private String home;
    @Value("${aplicacion.computadoras}")
    private String computerss;
    @Value("${aplicacion.usuarios}")
    private String userss;
    @Value("${aplicacion.departamentos}")
	private String deptos;
    @Value("${aplicacion.detalle}")
	private String detalle;
    
    @Autowired
	private Propiedades propiedades;

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ComputadoraService computadoraService;

    @Autowired
    private UsuarioCrudService usuarioCrudService;

    @Autowired
    private ComputadoraCrudService computadoraCrudService;


    /*HTML*/
    //http://localhost:8080/home
    @GetMapping("/home")
    public String goHome(Model model){
        LOGGER.info("Home del sitio");
        model.addAttribute("home",this.home);
        return "home";
    }

    //http://localhost:8080/departamentos
    @GetMapping("/departamentos")
    public String getDepartamentos(Model model){
        model.addAttribute("departs", departamentoService.getAllDepartamentos());
        model.addAttribute("deptos", this.deptos);
        LOGGER.info("Has entrado a departamentos");
        return "departamentosList";
    }


    //paginacion
    //http://localhost:8080/usuarios
    @GetMapping("/usuarios")
    public ModelAndView getUsuarios(@RequestParam("pageSize") Optional<Integer> pageSize,@RequestParam("page") Optional<Integer> page){
        ModelAndView modelAndView = new ModelAndView("usuariosListPage");
        modelAndView.addObject("userss", this.userss);
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        Page<Usuario> users = usuarioRepositoryPage.findAll(new PageRequest(evalPage, evalPageSize));
        LOGGER.info("--Total de paginas:" + users.getTotalPages() + "  ,numeros: " + users.getNumber());
        PagerModel pager = new PagerModel(users.getTotalPages(),users.getNumber(),BUTTONS_TO_SHOW);
        modelAndView.addObject("users",users);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        modelAndView.addObject("total",usuarioService.getAllUsuarios());
        modelAndView.addObject("usuario", new Usuario());
        LOGGER.info("--Has entrado a usuarios");
        return modelAndView;
    }

    //http://localhost:8080/usuarios
    /*@GetMapping("/usuarios")
    public String getUsuarios(Model model){
        model.addAttribute("users", usuarioService.getAllUsuarios());
        model.addAttribute("userss", this.userss);
        LOGGER.info("Has entrado a usuarios");
        return "usuariosList";
    }*/


    //Paginacion
    //http://localhost:8080/computadoras
    @GetMapping("/computadoras")
    public ModelAndView  getComputadoras(@RequestParam("pageSize") Optional<Integer> pageSize,@RequestParam("page") Optional<Integer> page){
        ModelAndView modelAndView = new ModelAndView("computadorasListPage");
        modelAndView.addObject("total",computadoraService.getAllComputadoras());
        modelAndView.addObject("arrendadas",computadoraCrudService.computadorasArrendadas());
        modelAndView.addObject("noarrendadas",computadoraCrudService.computadorasNoArrendadas());
        modelAndView.addObject("computerss", this.computerss);
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        Page<Computadora> computers = computadoraRepositoryPage.findAll(new PageRequest(evalPage, evalPageSize));
        LOGGER.info("--Total de paginas:" + computers.getTotalPages() + "  ,numeros: " + computers.getNumber());
        PagerModel pager = new PagerModel(computers.getTotalPages(),computers.getNumber(),BUTTONS_TO_SHOW);
        modelAndView.addObject("computers",computers);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        modelAndView.addObject("computadora",new Computadora());
        LOGGER.info("--Has entrado a computadoras");
        return modelAndView;
    }

    //http://localhost:8080/computadoras
    /*@GetMapping("/computadoras")
    public String getComputadoras(Model model){
        model.addAttribute("computers",computadoraService.getAllComputadoras());
        model.addAttribute("computerss", this.computerss);
        LOGGER.info("Has entrado a computadoras");
        return "computadorasList";
    }*/

    //http://localhost:8080/computadorasModel
    @GetMapping("/computadorasModel")
    public String getComputadorasForm(Model model){
        List<Departamento> departamentosSelect = departamentoService.getAllDepartamentos();
        /*Map<String,Integer> departamentosSelect = new HashMap<>();
        departamentosSelect.put("Direccion general",1);
        departamentosSelect.put("Sistemas de informacion",2);
        departamentosSelect.put("Recursos humanos",3);
        departamentosSelect.put("Investigacion",4);
        departamentosSelect.put("Diseño y comunicacion",5);
        departamentosSelect.put("Evaluacion",6);
        departamentosSelect.put("Hemeroteca",7);*/
        Map<String,String> mapSistema = new HashMap<>();
        mapSistema.put("Windows XP","Windows XP");
        mapSistema.put("Windows 7","Windows 7");
        mapSistema.put("Windows 8","Windows 8");
        mapSistema.put("Windows 10","Windows 10");
        mapSistema.put("Linux OS","Linux OS");
        mapSistema.put("Mac OS X","Mac OS X");
        mapSistema.put("No especificado","No especificado");
        Map<String, Boolean> actualizarMap = new HashMap<>();
        actualizarMap.put("Actualizada", true);
        actualizarMap.put("No actualizada", false);
        Map<String, String> tipoMap = new HashMap<>();
        tipoMap.put("Escritorio", "escritorio");
        tipoMap.put("Portatil", "portatil");
        tipoMap.put("No especificada", "no especificada");
        model.addAttribute("computer", new Computadora());
        model.addAttribute("computers", computadoraService.getAllComputadoras());
        model.addAttribute("departamentosSelect",departamentosSelect);
        model.addAttribute("actualizarMap",actualizarMap);
        model.addAttribute("mapSistema",mapSistema);
        model.addAttribute("tipoMap",tipoMap);
        LOGGER.info("--Has entrado a /computadorasModel");
        return "formComputadoras";
    }

    @PostMapping("/agregarComputadora")
    public String getComputadorasForm(@ModelAttribute("computer") Computadora computadora){
    	computadoraService.addComputadora(computadora);
    	LOGGER.info("--Has entrado a /agregarComputadora");
        return "redirect:/computadorasModel";
    }

    @GetMapping("/eliminarComputadora")
	public String deleteComputadora(@RequestParam(name="idcomputadora",required=true) long idcomputadora){
		computadoraService.deleteComputadora(idcomputadora);
		return "redirect:/computadoras";
	}

    //http://localhost:8080/usuariosModel
    @GetMapping("/usuariosModel")
    public String getUsuariosForm(Model model){
        List<Departamento> departamentosSelect = departamentoService.getAllDepartamentos();
        List<Computadora> computadorasSelect = computadoraService.getAllComputadoras();
        model.addAttribute("user", new Usuario());
        model.addAttribute("users", usuarioService.getAllUsuarios());
        model.addAttribute("cargosMap",getCargosMap());
        model.addAttribute("departamentosSelect",departamentosSelect);
        model.addAttribute("computadorasSelect",computadorasSelect);
        LOGGER.info("--Has entrado a /usuariosModel");
        return "formUsuarios";
    }

    @PostMapping("/agregarUsuario")
    public String getUsuariosForm(@ModelAttribute("user") Usuario usuario){
        usuarioService.addUsuario(usuario);
        LOGGER.info("--Has entrado a /agregarUsuario");
        return "redirect:/usuariosModel";
    }

    @GetMapping("/eliminarUsuario")
	public String deleteUsuario(@RequestParam(name="idusuario",required=true) long idusuario){
		usuarioService.deleteUsuario(idusuario);
		return "redirect:/usuarios";
    }

    /* Buscar usuario x nombre */
    @GetMapping("/hallarUsuarioByNombre")
    public String hallarUsuarioByNombre(@RequestParam("nombre") String nombre, Model model){
        LOGGER.info("--Nombre a buscar: "+nombre);
        List<Usuario> buscarUsuarioByNombre = usuarioCrudService.buscarUsuarioByNombre(nombre);
        model.addAttribute("usuariosHalladosByNombre",buscarUsuarioByNombre);
        model.addAttribute("mensaje","Búsqueda realizada");    
        return "usuarioHalladoByNombre";
    }

    /* Buscar usuario x nombre de usuario */
    @GetMapping("/hallarUsuarioByUsuario")
    public String hallarUsuarioByUsuario(@RequestParam("usuario") String usuario, Model model){
        LOGGER.info("--Nombre de usuario a buscar: "+usuario);
        List<Usuario> buscarUsuarioByUsuario = usuarioCrudService.buscarUsuarioByUsuario(usuario);
        model.addAttribute("usuariosHalladosByUsuario",buscarUsuarioByUsuario);
        model.addAttribute("mensaje","Búsqueda realizada");    
        return "usuarioHalladoByUsuario";
    }

    /* Buscar usuario x computadora bien */
    @GetMapping("/hallarUsuarioByComputadoraBien")
    public String hallarUsuarioByComputadoraBien(@RequestParam("computadora") String computadora, Model model){
        LOGGER.info("--Bien a buscar: "+computadora);
        List<Usuario> buscarUsuarioByComputadoraBien = usuarioCrudService.buscarUsuarioByComputadoraBien(computadora);
        model.addAttribute("usuariosHalladosByComputadoraBien",buscarUsuarioByComputadoraBien);
        model.addAttribute("mensaje","Búsqueda realizada");    
        return "usuarioHalladoByComputadoraBien";
    }
    /* Buscar usuario x computadora arrendado */
    @GetMapping("/hallarUsuarioByComputadoraArrendado")
    public String hallarUsuarioByComputadoraArrendado(@RequestParam("computadora") String computadora, Model model){
        LOGGER.info("--Bien a buscar: "+computadora);
        List<Usuario> buscarUsuarioByComputadoraArrendado = usuarioCrudService.buscarUsuarioByComputadoraArrendado(computadora);
        model.addAttribute("usuariosHalladosByComputadoraArrendado",buscarUsuarioByComputadoraArrendado);
        model.addAttribute("mensaje","Búsqueda realizada");    
        return "usuarioHalladoByComputadoraArrendado";
    }

    /* Buscar usuario x Ip */
    @GetMapping("/hallarUsuarioByComputadoraIp")
    public String hallarUsuarioByComputadoraIp(@RequestParam("ip") String ip, Model model){
        LOGGER.info("--Ip a buscar: "+ip);
        List<Usuario> buscarUsuarioByComputadoraIp = usuarioCrudService.buscarUsuarioByComputadoraIp(ip);
        model.addAttribute("usuariosHalladosByComputadoraIp",buscarUsuarioByComputadoraIp);
        model.addAttribute("mensaje","Búsqueda realizada");    
        return "usuarioHalladoByComputadoraIp";
    }


    /* Buscar computadora x no. bien */
    @GetMapping("/hallarComputadoraByBien")
    public String hallarComputadoraByBien(@RequestParam("bien") String bien, Model model){
        LOGGER.info("--Bien a buscar: "+bien);
        List<Computadora> buscarComputadoraByBien = computadoraCrudService.computadorasByBien(bien);
        LOGGER.info("--Computadoras:"+buscarComputadoraByBien.toString());
        List<Usuario> buscarUsuarioByComputadoraBien = usuarioCrudService.buscarUsuarioByComputadoraBien(bien);
        LOGGER.info("--Usuarios:"+buscarUsuarioByComputadoraBien.toString());
        model.addAttribute("usuariosHalladosByComputadoraBien",buscarUsuarioByComputadoraBien);
        model.addAttribute("computadorasHalladasByBien",buscarComputadoraByBien);
        model.addAttribute("mensaje","Búsqueda realizada"); 
        return "computadoraHalladaByBien";
    }
    
    /* Buscar computadora x no. arrendamiento */
    @GetMapping("/hallarComputadoraByArrendado")
    public String hallarComputadoraByArrendado(@RequestParam("arrendado") String arrendado, Model model){
        LOGGER.info("--No. arrendado a buscar: "+arrendado);
        List<Computadora> buscarComputadoraByArrendado = computadoraCrudService.computadorasByArrendado(arrendado);
        model.addAttribute("computadorasHalladasByArrendado",buscarComputadoraByArrendado);

        List<Usuario> buscarUsuarioByComputadoraArrendado = usuarioCrudService.buscarUsuarioByComputadoraArrendado(arrendado);
        model.addAttribute("usuariosHalladosByComputadoraArrendado",buscarUsuarioByComputadoraArrendado);


        model.addAttribute("mensaje","Búsqueda realizada"); 
        return "computadoraHalladaByArrendado";
    }

    /* Buscar computadora x no. IP */
    @GetMapping("/hallarComputadoraByIp")
    public String hallarComputadoraByIp(@RequestParam("ip") String ip, Model model){
        LOGGER.info("--IP a buscar: "+ip);
        List<Computadora> buscarComputadoraByIp = computadoraCrudService.computadorasByIp(ip);
        model.addAttribute("computadorasHalladasByIp",buscarComputadoraByIp);
        model.addAttribute("mensaje","Búsqueda realizada"); 
        return "computadoraHalladaByIp";
    }


    /*Ver detalle de la computadora*/
    @GetMapping("/detalleComputadora")
    public String getDetalleComputadora(@RequestParam(name="idcomputadora", required=true) long idcomputadora, Model model){
        Computadora computadoraDetalle = computadoraService.getComputadoraById(idcomputadora);
        if(computadoraDetalle != null){
            LOGGER.info("--Has entrado a detalle de computadora:"+computadoraDetalle);
            model.addAttribute("computadora",computadoraDetalle); 
            model.addAttribute("detalle",this.detalle); 
            return "detalleComputadora";
        }
        return "redirect:/usuarios";
    }

    /*Editar usuario*/
    @GetMapping("/updateUsuario")
    public String updateUsuario(@RequestParam(name="idusuario", required=true) long idusuario, Model model){
        if(idusuario != 0){
            LOGGER.info("--Intentas actualizar usuario:"+idusuario);
            Usuario usuarioUpdate = usuarioService.getUsuarioById(idusuario);
            if(usuarioUpdate != null){
                List<Departamento> departamentosSelect = departamentoService.getAllDepartamentos();
                List<Computadora> computadorasSelect = computadoraService.getAllComputadoras();
                List<Usuario> usuariosSelect = usuarioService.getAllUsuarios();
                LOGGER.info("--Intentas actualizar usuario existente:"+usuarioUpdate);
                model.addAttribute("cargosMap",getCargosMap());
                model.addAttribute("usuariox",usuarioUpdate);
                model.addAttribute("departamentosSelect",departamentosSelect);
                model.addAttribute("computadorasSelect",computadorasSelect);
                model.addAttribute("usuariosSelect",usuariosSelect);
                return "updateUsuario";
            }
        }
        return "redirect:/usuarios";
    }



    @PostMapping("/actualizarUsuario")
    public String getUpdateUsuariosForm(@ModelAttribute(name="usuariox") Usuario usuariox, Model model, 
    @RequestParam(name="idusuario", required=true) long idusuario,
    @RequestParam(name="nombre") String nombre, @RequestParam(name="apellidos")String apellidos,
    @RequestParam(name="usuario") String usuario, @RequestParam(name="password")String password,
    @RequestParam(name="cargo") String cargo, @RequestParam(name="departamento") long departamento,
    @RequestParam(name="computadora") long computadora){
        //usuarioService.updateUsuario(idusuario, apellidos, cargo, nombre, password,usuario,idcomputadora,iddepartamento);
        /*if(usuariox != null){
            LOGGER.info("--Has entrado a /actualizarUsuario:"+usuario);
            usuarioService.updateUsuario(usuariox.getIdUsuario(), usuariox.getApellidos(),usuariox.getCargo() , usuariox.getNombre(), usuariox.getPassword() ,usuariox.getUsuario(), usuariox.getComputadora().getIdComputadora(), usuariox.getDepartamento().getIdDepartamento());
        }*/
        Usuario usuarioActualizado = null;
        try{
            usuarioActualizado=usuarioService.updateUsuario(idusuario, apellidos, cargo, nombre, password,usuario,computadora,departamento);
        }catch(Exception ex){
            LOGGER.info("--Ha ocurrido un error:");
            ex.printStackTrace();
        }

        if(usuariox != null && idusuario!=0 && usuarioActualizado!=null ){
            LOGGER.info("--Has entrado a /actualizarUsuario:"+usuariox);
            LOGGER.info("--Clave:"+idusuario);
            LOGGER.info("--Nombre:"+nombre);
            LOGGER.info("--Apellidos:"+apellidos);
            LOGGER.info("--Usuario:"+usuario);
            LOGGER.info("--Password:"+password);
            LOGGER.info("--Cargo:"+cargo);
            LOGGER.info("--Departamento:"+departamento);
            LOGGER.info("--Computadora:"+computadora);
            //model.addAttribute("resultado","Usuario actualizado:"+usuariox);
            model.addAttribute("resultado","Usuario actualizado:"+usuarioActualizado);
        }
        return "usuarioModificado";
        //return "redirect:/usuariosModel";
    }

    /*Editar computadora */
    @GetMapping("/updateComputadora")
    public String updateComputadora(@RequestParam(name="idcomputadora", required=true) long idcomputadora, Model model){
        if(idcomputadora != 0){
            LOGGER.info("--Intentas actualizar computadora:"+idcomputadora);
            Computadora computadoraUpdate = computadoraService.getComputadoraById(idcomputadora);
            if(computadoraUpdate != null){
                List<Departamento> departamentosSelect = departamentoService.getAllDepartamentos();
                List<Computadora> computadorasSelect = computadoraService.getAllComputadoras();
                Map<String,String> mapSistema = new HashMap<>();
                mapSistema.put("Windows XP","Windows XP");
                mapSistema.put("Windows 7","Windows 7");
                mapSistema.put("Windows 8","Windows 8");
                mapSistema.put("Windows 10","Windows 10");
                mapSistema.put("Linux OS","Linux OS");
                mapSistema.put("Mac OS X","Mac OS X");
                mapSistema.put("No especificado","No especificado");
                Map<String, Boolean> actualizarMap = new HashMap<>();
                actualizarMap.put("Actualizada", true);
                actualizarMap.put("No actualizada", false);
                Map<String, String> tipoMap = new HashMap<>();
                tipoMap.put("Escritorio", "escritorio");
                tipoMap.put("Portatil", "portatil");
                tipoMap.put("No especificada", "no especificada");
                LOGGER.info("--Intentas actualizar computadora existente:"+computadoraUpdate);
                model.addAttribute("computadorax",computadoraUpdate);
                model.addAttribute("cargosMap",getCargosMap());
                model.addAttribute("computadorasSelect",computadorasSelect);
                model.addAttribute("departamentosSelect",departamentosSelect);
                model.addAttribute("actualizarMap",actualizarMap);
                model.addAttribute("mapSistema",mapSistema);
                model.addAttribute("tipoMap",tipoMap);
                return "updateComputadora";
            }
        }
        return "redirect:/computadoras";
    }

    @PostMapping("/actualizarComputadora")
    public String getUpdateComputadorasForm(@ModelAttribute(name="computadorax") Computadora computadorax, Model model, 
    @RequestParam(name="idcomputadora", required=true) long idcomputadora,
    @RequestParam(name="bien") String bien, @RequestParam(name="arrendado")String arrendado,
    @RequestParam(name="asignado") String asignado, @RequestParam(name="ip")String ip,
    @RequestParam(name="dns") String dns, @RequestParam(name="red") String red,
    @RequestParam(name="operativo") String operativo, @RequestParam(name="maquina") String maquina,
    @RequestParam(name="tipo") String tipo, @RequestParam(name="modelo") String modelo,@RequestParam(name="dominio") String dominio,
    @RequestParam(name="administrador") String administrador, @RequestParam(name="ubicacion") String ubicacion,
    @RequestParam(name="actualizada") boolean actualizada,@RequestParam(name="departamento") long departamento){
        Computadora computadoraActualizada = null;
        try{
            computadoraActualizada = computadoraService.updateComputadora(idcomputadora, bien,arrendado,asignado,ip,dns,red,operativo,maquina,tipo,modelo,dominio,administrador,ubicacion,actualizada,departamento);
        }catch(Exception ex){
            LOGGER.info("--Ha ocurrido un error:");
            ex.printStackTrace();
        }

        if(computadorax != null && idcomputadora!=0 && computadoraActualizada!=null ){
            LOGGER.info("--Has entrado a /actualizarUsuario:"+computadorax);
            LOGGER.info("--Clave:"+idcomputadora);
            model.addAttribute("resultado","Computadora actualizada:"+computadoraActualizada);
        }
        return "computadoraModificada";
    }


    /*Exportar usuarios a excel*/
    @GetMapping("/exceluser")
    public String getImprimeExcelUser(){
        List<Usuario> usuariosSelect = usuarioService.getAllUsuarios();
        File f = new File("C:\\Users\\USUARIO\\Downloads\\usuarios.xls");
        if(f.exists()){
            f.delete();
        }
        try{
            toExcelUser(usuariosSelect,new File("C:\\Users\\USUARIO\\Downloads\\usuarios.xls"));
        }catch(IOException | NullPointerException ioe){
            LOGGER.info("--Ha ocurrido una excepcion:"+ioe.toString());
        }
        return "redirect:/usuarios";
    }

    public void toExcelUser(List<Usuario> usuariosSelect, File file) throws IOException{
        FileWriter excel = new FileWriter(file);
        excel.write("Usuario");excel.write("\t");
        excel.write("Password");excel.write("\t");
        excel.write("Nombre");excel.write("\t");
        excel.write("Apellidos");excel.write("\t");
        excel.write("Cargo");excel.write("\t");
        excel.write("Computadora");excel.write("\t");
        excel.write("Departamento");excel.write("\t");
        excel.write("\n");
        for(Usuario usuario : usuariosSelect){
            excel.write(usuario.getUsuario()+"\t");
            excel.write(usuario.getPassword()+"\t");
            excel.write(usuario.getNombre()+"\t");
            excel.write(usuario.getApellidos()+"\t"); 
            excel.write(usuario.getCargo()+"\t"); 
            excel.write(usuario.getComputadora().getBien()+"\t"); 
            excel.write(usuario.getDepartamento().getNombre()+"\t");   excel.write("\n");
        }
        excel.close();
    }


    /*Exportar computadoras a excel*/
    @GetMapping("/excelcomp")
    public String getImprimeExcelComp(){
        List<Computadora> computadorasSelect = computadoraService.getAllComputadoras();
        File f = new File("C:\\Users\\USUARIO\\Downloads\\computadoras.xls");
        if(f.exists()){
            f.delete();
        }
        try{
            toExcelComp(computadorasSelect,new File("C:\\Users\\USUARIO\\Downloads\\computadoras.xls"));
        }catch(IOException | NullPointerException ioe){
            LOGGER.info("--Ha ocurrido una excepcion:"+ioe.toString());
        }
        return "redirect:/computadoras";
    }

    public void toExcelComp(List<Computadora> computadorasSelect, File file) throws IOException{
        FileWriter excel = new FileWriter(file);
        excel.write("Usuario");excel.write("\t");
        excel.write("Bien");excel.write("\t");
        excel.write("Arrendado");excel.write("\t");
        excel.write("Asignado");excel.write("\t");
        excel.write("Ip");excel.write("\t");
        excel.write("Dns");excel.write("\t");
        excel.write("Red");excel.write("\t");
        excel.write("Operativo");excel.write("\t");
        excel.write("Tipo");excel.write("\t");
        excel.write("Modelo");excel.write("\t");
        excel.write("Dominio");excel.write("\t");
        excel.write("Administrador");excel.write("\t");
        excel.write("Ubicacion");excel.write("\t");
        excel.write("Actualizada");excel.write("\t");
        excel.write("Departamento");excel.write("\t");
        excel.write("\n");
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        int cont=0;
        for(Computadora comp : computadorasSelect){
            excel.write(usuarios.get(cont).getUsuario()+" : "+usuarios.get(cont).getCargo()+"\t");
            excel.write(comp.getBien()+"\t");
            excel.write(comp.getArrendado()+"\t");
            excel.write(comp.getAsignado()+"\t");
            excel.write(comp.getIp()+"\t"); 
            excel.write(comp.getDns()+"\t"); 
            excel.write(comp.getRed()+"\t"); 
            excel.write(comp.getOperativo()+"\t"); 
            excel.write(comp.getTipo()+"\t"); 
            excel.write(comp.getModelo()+"\t"); 
            excel.write(comp.getDominio()+"\t");
            excel.write(comp.getAdministrador()+"\t"); 
            excel.write(comp.getUbicacion()+"\t"); 
            excel.write(comp.isActualizada()? "Actualizada": "No actualizada"+"\t");
            excel.write(comp.getDepartamento().getNombre()+"\t");   excel.write("\n");
            cont++;
        }
        excel.close();
    }

    /* Exportar usuarios a html */
    @GetMapping("/htmluser")
    public String getHtmlUser(){
        List<Usuario> usuariosSelect = usuarioService.getAllUsuarios();
        File f = new File("C:\\Users\\USUARIO\\Downloads\\usuarios.html");
        if(f.exists()){
            f.delete();
        }
        try{
            toHTMLUser(usuariosSelect,new File("C:\\Users\\USUARIO\\Downloads\\usuarios.html"));
        }catch(IOException | NullPointerException ioe){
            LOGGER.info("--Ha ocurrido una excepcion:"+ioe.toString());
        }
        return "redirect:/usuarios";
    }

    public void toHTMLUser(List<Usuario> usuariosSelect, File file) throws IOException{
        try (FileWriter html = new FileWriter(file)) {
            html.write("<!DOCTYPE html>" +"<html lang='es'>"
                    + "<head> <meta charset='utf-8'> <title>Registro de usuarios</title>" 
                    +"</head><body style='background-color:#edefee;color:#ad0505;'>");
            html.write("<h1 align='center' style='background-color: white;'>Registro de usuarios</h1>");
            html.write("<table id='tablaUsuario' align='center' border='0' dt:table='true'><tr>");
            html.write("<tr>");
            html.write("<th style='background-color:white; color:black;'>Usuario</th>");
            html.write("<th style='background-color:white; color:black;'>Password</th>");
            html.write("<th style='background-color:white; color:black;'>Nombre</th>");
            html.write("<th style='background-color:white; color:black;'>Apellidos</th>");
            html.write("<th style='background-color:white; color:black;'>Cargo</th>");
            html.write("<th style='background-color:white; color:black;'>Departamento</th>");
            html.write("<th style='background-color:white; color:black;'>Computadora</th>");
            html.write("</tr>");

            
            for(int i=0; i < usuariosSelect.size(); i++){
                html.write("<tr>");
                for(int j=0; j < usuariosSelect.size(); j++){
                    try{
                        
                        html.write("<td style='background-color: #A9E2F3 ; color:black;'>"+usuariosSelect.get(i).getUsuario() +"</td>");
                        html.write("<td style='background-color: #A9E2F3 ; color:black;'>"+usuariosSelect.get(i).getPassword() +"</td>");
                        html.write("<td style='background-color: #A9E2F3 ; color:black;'>"+usuariosSelect.get(i).getNombre() +"</td>");
                        html.write("<td style='background-color: #A9E2F3 ; color:black;'>"+usuariosSelect.get(i).getApellidos() +"</td>");
                        html.write("<td style='background-color: #A9E2F3 ; color:black;'>"+usuariosSelect.get(i).getCargo() +"</td>");
                        html.write("<td style='background-color: #A9E2F3 ; color:black;'>"+usuariosSelect.get(i).getDepartamento().getNombre() +"</td>");
                        html.write("<td style='background-color: #A9E2F3 ; color:black;'>"+usuariosSelect.get(i).getComputadora().getBien() +"</td>");
                        
                    }catch(NullPointerException | ArrayIndexOutOfBoundsException npe){
                        LOGGER.info("--Ha ocurrido una excepcion:"+npe.toString());
                    }
                }
                html.write("</tr>");
            }    
            html.write("</table>");
            html.write("</body>\n" +"</html>");
        }
    }


    /* Exportar computadoras a html */
    @GetMapping("/htmlcomp")
    public String getHtmlComp(){
        List<Computadora> computadorasSelect = computadoraService.getAllComputadoras();
        File f = new File("C:\\Users\\USUARIO\\Downloads\\computadoras.html");
        if(f.exists()){
            f.delete();
        }
        try{
            toHTMLComp(computadorasSelect,new File("C:\\Users\\USUARIO\\Downloads\\computadoras.html"));
        }catch(IOException | NullPointerException ioe){
            LOGGER.info("--Ha ocurrido una excepcion:"+ioe.toString());
        }
        return "redirect:/computadoras";
    }

    public void toHTMLComp(List<Computadora> computadorasSelect, File file) throws IOException{
        try (FileWriter html = new FileWriter(file)) {
            html.write("<!DOCTYPE html>" +"<html lang='es'>"
                    + "<head> <meta charset='utf-8'> <title>Registro de computadoras</title>" 
                    +"</head><body style='background-color:#edefee;color:#ad0505;'>");
            html.write("<h1 align='center' style='background-color: white;'>Registro de computadoras</h1>");
            html.write("<table id='tablaUsuario' align='center' border='0' dt:table='true'><tr>");
            html.write("<tr>");
            html.write("<th style='background-color:white; color:black;'>Usuario:Cargo</th>");
            html.write("<th style='background-color:white; color:black;'>Bien</th>");
            html.write("<th style='background-color:white; color:black;'>Arrendado</th>");
            html.write("<th style='background-color:white; color:black;'>Asignado</th>");
            html.write("<th style='background-color:white; color:black;'>Ip</th>");
            html.write("<th style='background-color:white; color:black;'>Dns</th>");
            html.write("<th style='background-color:white; color:black;'>Red</th>");
            html.write("<th style='background-color:white; color:black;'>Operativo</th>");
            html.write("<th style='background-color:white; color:black;'>Tipo</th>");
            html.write("<th style='background-color:white; color:black;'>Modelo</th>");
            html.write("<th style='background-color:white; color:black;'>Dominio</th>");
            html.write("<th style='background-color:white; color:black;'>Administrador</th>");
            html.write("<th style='background-color:white; color:black;'>Ubicacion</th>");
            html.write("<th style='background-color:white; color:black;'>Actualizacion</th>");
            html.write("<th style='background-color:white; color:black;'>Departamento</th>");
            html.write("</tr>");

            List<Usuario> usuarios = usuarioService.getAllUsuarios();
            for(int i=0; i < computadorasSelect.size(); i++){
                html.write("<tr>");
                for(int j=0; j < computadorasSelect.size(); j++){
                    try{
                        
                        String cadena = computadorasSelect.get(i).isActualizada()? "Actualizada" : "No actualizada";
                        String result = computadorasSelect.get(i).isActualizada()? "<td style='background-color: #A9E2F3 ; color:green; font-weight: bold;'>"
                        +cadena
                        +"</td>" : "<td style='background-color: #A9E2F3 ; color:red; font-weight: bold;'>"
                        +cadena 
                        +"</td>";

                        html.write("<td style='background-color: #A9E2F3 ; color:black;'>"+usuarios.get(j).getUsuario()+" : "+usuarios.get(j).getCargo()+"</td>");
                        html.write("<td style='background-color: #A9E2F3 ; color:black;'>"+computadorasSelect.get(i).getBien() +"</td>");
                        html.write("<td style='background-color: #A9E2F3 ; color:black;'>"+computadorasSelect.get(i).getArrendado() +"</td>");
                        html.write("<td style='background-color: #A9E2F3 ; color:black;'>"+computadorasSelect.get(i).getAsignado() +"</td>");
                        html.write("<td style='background-color: #A9E2F3 ; color:black;'>"+computadorasSelect.get(i).getIp() +"</td>");
                        html.write("<td style='background-color: #A9E2F3 ; color:black;'>"+computadorasSelect.get(i).getDns() +"</td>");
                        html.write("<td style='background-color: #A9E2F3 ; color:black;'>"+computadorasSelect.get(i).getRed() +"</td>");
                        html.write("<td style='background-color: #A9E2F3 ; color:black;'>"+computadorasSelect.get(i).getOperativo() +"</td>");
                        html.write("<td style='background-color: #A9E2F3 ; color:black;'>"+computadorasSelect.get(i).getTipo() +"</td>");
                        html.write("<td style='background-color: #A9E2F3 ; color:black;'>"+computadorasSelect.get(i).getModelo() +"</td>");
                        html.write("<td style='background-color: #A9E2F3 ; color:black;'>"+computadorasSelect.get(i).getDominio() +"</td>");
                        html.write("<td style='background-color: #A9E2F3 ; color:black;'>"+computadorasSelect.get(i).getAdministrador() +"</td>");
                        html.write("<td style='background-color: #A9E2F3 ; color:black;'>"+computadorasSelect.get(i).getUbicacion() +"</td>");
                        html.write(result);
                        html.write("<td style='background-color: #A9E2F3 ; color:black;'>"+computadorasSelect.get(i).getDepartamento().getNombre() +"</td>");
                        
                    }catch(NullPointerException | ArrayIndexOutOfBoundsException npe){
                        LOGGER.info("--Ha ocurrido una excepcion:"+npe.toString());
                    }
                }
                html.write("</tr>");
            }    
            html.write("</table>");
            html.write("</body>\n" +"</html>");
        }
    }




    /*Cargos*/
    public static Map<String,String> getCargosMap(){
        Map<String,String> cargosMap = new HashMap<>();
        cargosMap.put("Director general","Director general");
        cargosMap.put("Ayudante general","Ayudante general");
        cargosMap.put("Programador","Programador");
        cargosMap.put("Jefe de area","Jefe de area");
        cargosMap.put("Soporte tecnico","Soporte tecnico");
        cargosMap.put("Lider de proyecto","Lider de proyecto");
        cargosMap.put("Capturista","Capturista");
        cargosMap.put("Diseñador","Diseñador");
        cargosMap.put("Investigador","Investigador");
        cargosMap.put("Evaluador","Evaluador");
        cargosMap.put("Servicio social","Servicio social");
        cargosMap.put("No especificado","No especificado");
        return cargosMap;
    }

    //***************Ejemplos*********************

    //http://localhost:8080/listaDepartamentos
    @GetMapping("/listaDepartamentos")
    public String departamentosForm(Model model){
        List<Departamento> departamentosSelect = departamentoService.getAllDepartamentos();
        model.addAttribute("departamentosSelect",departamentosSelect);
        return "listaDepartamentos";
    }

    @PostMapping("/search")
    public String departamentosPost(@ModelAttribute("departamentos") Departamento departamentos) {
        LOGGER.info("Has elegido: "+departamentos.getNombre());
        return "search";
    }

    //*********************************************

    /*REST*/
    //http://localhost:8080/departamentosTable
    @GetMapping("/departamentosTable")
    public String getDepartamentosTable(){
        LOGGER.info("Has entrado a departamentosTable");
        return "departamentosTable";
    }

    //http://localhost:8080/usuariosTable
    @GetMapping("/usuariosTable")
    public String getUsuariosTable(){
        LOGGER.info("Has entrado a usuariosTable");
        return "usuariosTable";
    }

    //http://localhost:8080/computadorasTable
    @GetMapping("/computadorasTable")
    public String getComputadorasTable(){
        LOGGER.info("Has entrado a computadorasTable");
        return "computadorasTable";
    }

    /*Consumir REST*/
    @GetMapping("/consumir/consumirDepartamentoRest")
    public ModelAndView consumirDepartamentoRest(){
        ModelAndView mav = new ModelAndView("consumirDepartamentoRest");
        return mav;
    }

}
