package Controller;

import Config.ConexionBD;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import Modelo.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Controlador {

    ConexionBD con = new ConexionBD();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView();
    int id;
    List datos;

    @RequestMapping("index.htm")
    public ModelAndView menu() {
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("rol.htm")
    public ModelAndView ListarRoles() {
        String sql = "select * from rol";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("rol");
        return mav;
    }

    @RequestMapping(value = "agregarRol.htm", method = RequestMethod.GET)
    public ModelAndView AgregarRol() {
        mav.addObject(new rolModel());
        mav.setViewName("agregarRol");
        return mav;
    }

    @RequestMapping(value = "agregarRol.htm", method = RequestMethod.POST)
    public ModelAndView AgregarRol(rolModel a) {
        String sql = "Insert into rol(nombre_rol, fecha_creacion, activo) values(?,?,?)";
        this.jdbcTemplate.update(sql, a.getNombreRol(), a.getFechaCreacion(), a.getActivo());
        mav.addObject(new rolModel());
        return new ModelAndView("redirect:/rol.htm");
    }

    @RequestMapping("tipoauto.htm")
    public ModelAndView ListarTiposAutos() {
        String sql = "select * from tipo";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("listaAutos", datos);
        mav.setViewName("tipoauto");
        return mav;
    }

    @RequestMapping(value = "agregarTipoAuto.htm", method = RequestMethod.GET)
    public ModelAndView AgregarTipoAuto() {
        mav.addObject(new tipoModel());
        mav.setViewName("agregarTipoAuto");
        return mav;
    }

    @RequestMapping(value = "agregarTipoAuto.htm", method = RequestMethod.POST)
    public ModelAndView AgregarTipoAuto(tipoModel a) {
        String sql = "Insert into tipo(nombre_tipo, fecha_creacion, activo) values(?,?,?)";
        this.jdbcTemplate.update(sql, a.getNombreTipo(), a.getFechaCreacion(), a.getActivo());
        mav.addObject(new tipoModel());
        return new ModelAndView("redirect:/tipoauto.htm");
    }

    @RequestMapping("usuario.htm")
    public ModelAndView ListarUsuarios() {
        String sql = "SELECT u.id_usuario, u.user_name, u.nombre, u.apellido, u.fecha_nacimiento, u.direccion, u.telefono, u.correo, u.activo, r.nombre_rol FROM usuario u INNER JOIN rol r ON u.id_rol = r.id_rol";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("usuario");
        return mav;
    }

    @RequestMapping(value = "agregarUsuario.htm", method = RequestMethod.GET)
    public ModelAndView AgregarUsuario() {
        String sql = "select * from rol";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("agregarUsuario");
        return mav;
    }

    @RequestMapping(value = "agregarUsuario.htm", method = RequestMethod.POST)
    public ModelAndView AgregarUsuario(usuarioModel a) {
        String sql = "Insert into usuario(user_name, contrasena, nombre, apellido, fecha_nacimiento, direccion, telefono, correo, activo, id_rol) values(?,?,?,?,?,?,?,?,?,?)";
        this.jdbcTemplate.update(sql, a.getUser_name(), a.getContrasena(), a.getNombre(), a.getApellido(), a.getFecha_nacimiento(), a.getDireccion(), a.getTelefono(), a.getCorreo(), a.getActivo(), a.getId_rol());
        mav.addObject(new usuarioModel());
        return new ModelAndView("redirect:/usuario.htm");
    }

    @RequestMapping("marca.htm")
    public ModelAndView ListarMarcas() {
        String sql = "select * from marca";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("marca");
        return mav;
    }

    @RequestMapping(value = "agregarMarca.htm", method = RequestMethod.GET)
    public ModelAndView AgregarMarca() {
        mav.addObject(new marcaModel());
        mav.setViewName("agregarMarca");
        return mav;
    }

    @RequestMapping(value = "agregarMarca.htm", method = RequestMethod.POST)
    public ModelAndView AgregarMarca(marcaModel a) {
        String sql = "Insert into marca(nombre_marca, fecha_creacion, activo) values(?,?,?)";
        this.jdbcTemplate.update(sql, a.getNombre_marca(), a.getFecha_creacion(), a.getActivo());
        mav.addObject(new marcaModel());
        return new ModelAndView("redirect:/marca.htm");
    }

    @RequestMapping("automovil.htm")
    public ModelAndView ListarAutomoviles() {
        String sql = "select a.id_automovil, a.gama, a.fecha_creacion, a.precio, a.ocupado, a.activo, m.nombre_marca, t.nombre_tipo from automovil a INNER JOIN tipo t ON a.id_tipo = t.id_tipo INNER JOIN marca m ON a.id_marca = m.id_marca";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("automovil");
        return mav;
    }

    @RequestMapping(value = "agregarAutomovil.htm", method = RequestMethod.GET)
    public ModelAndView AgregarAutomovil() {
        String sql = "select * from marca";
        List datosMarca = this.jdbcTemplate.queryForList(sql);
        mav.addObject("listaMarca", datosMarca);
        sql = "select * from tipo";
        List datosTipo = this.jdbcTemplate.queryForList(sql);
        mav.addObject("listaTipo", datosTipo);
        mav.setViewName("agregarAutomovil");
        return mav;
    }

    @RequestMapping(value = "agregarAutomovil.htm", method = RequestMethod.POST)
    public ModelAndView AgregarAutomovil(automovilModel a) {
        String sql = "Insert into automovil(gama, fecha_creacion, precio, ocupado, activo, id_marca, id_tipo) values(?,?,?,?,?,?,?)";
        this.jdbcTemplate.update(sql, a.getGama(), a.getFecha_creacion(), a.getPrecio(), a.getOcupado(), a.getActivo(), a.getId_marca(), a.getId_tipo());
        mav.addObject(new automovilModel());
        return new ModelAndView("redirect:/automovil.htm");
    }

    @RequestMapping("renta.htm")
    public ModelAndView ListarRentas() {
        String sql = "SELECT r.id_renta, r.precio, r.fecha_alquiler, m.nombre_marca, u.user_name FROM  renta r INNER JOIN usuario u ON r.id_usuario = u.id_usuario INNER JOIN automovil a ON r.id_automovil = a.id_automovil INNER JOIN marca m ON a.id_marca = m.id_marca;";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("renta");
        return mav;
    }

    @RequestMapping(value = "agregarRenta.htm", method = RequestMethod.GET)
    public ModelAndView AgregarRenta() {
        String sql = "select a.id_automovil, a.gama, a.precio, m.nombre_marca from automovil a INNER JOIN marca m ON a.id_marca = m.id_marca";
        List datosAutomovil = this.jdbcTemplate.queryForList(sql);
        mav.addObject("listaAutomovil", datosAutomovil);
        sql = "select id_usuario, user_name FROM usuario";
        List datosCliente = this.jdbcTemplate.queryForList(sql);
        mav.addObject("listaCliente", datosCliente);
        mav.setViewName("agregarRenta");
        return mav;
    }

    @RequestMapping(value = "agregarRenta.htm", method = RequestMethod.POST)
    public ModelAndView AgregarRenta(rentaModel a) {
        String sql = "Insert into renta(precio, fecha_alquiler, id_automovil, id_usuario) values(?,?,?,?)";
        this.jdbcTemplate.update(sql, a.getPrecio(), a.getFecha_alquiler(), a.getId_automovil(), a.getId_usuario());
        mav.addObject(new rentaModel());
        return new ModelAndView("redirect:/renta.htm");
    }

    @RequestMapping(value = "editarRol.htm", method = RequestMethod.GET)
    public ModelAndView EditarRol(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "select * from rol where id_rol = " + id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("editarRol");
        return mav;
    }

    @RequestMapping(value = "editarRol.htm", method = RequestMethod.POST)
    public ModelAndView EditarRol(rolModel a) {
        String sql = "update rol set nombre_rol = ?, fecha_creacion = ?, activo = ? where id_rol = ?";
        this.jdbcTemplate.update(sql, a.getNombreRol(), a.getFechaCreacion(), a.getActivo(), id);
        mav.addObject(new rolModel());
        return new ModelAndView("redirect:/rol.htm");
    }

    @RequestMapping(value = "editarTipoAuto.htm", method = RequestMethod.GET)
    public ModelAndView EditarTipoAuto(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "select * from tipo where id_tipo = " + id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("editarTipoAuto");
        return mav;
    }

    @RequestMapping(value = "editarTipoAuto.htm", method = RequestMethod.POST)
    public ModelAndView EditarRol(tipoModel a) {
        String sql = "update tipo set nombre_tipo = ?, fecha_creacion = ?, activo = ? where id_tipo = ?";
        this.jdbcTemplate.update(sql, a.getNombreTipo(), a.getFechaCreacion(), a.getActivo(), id);
        mav.addObject(new tipoModel());
        return new ModelAndView("redirect:/tipoauto.htm");
    }

    @RequestMapping(value = "editarUsuario.htm", method = RequestMethod.GET)
    public ModelAndView EditarUsuario(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "select * from usuario where id_usuario = " + id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("editarUsuario");
        return mav;
    }

    @RequestMapping(value = "editarUsuario.htm", method = RequestMethod.POST)
    public ModelAndView EditarRol(usuarioModel a) {
        String sql = "update usuario set user_name = ?, contrasena = ?, nombre = ?, apellido = ?, fecha_nacimiento = ?, direccion = ?, telefono = ?, correo = ?  where id_usuario = ?";
        this.jdbcTemplate.update(sql, a.getUser_name(), a.getContrasena(), a.getNombre(), a.getApellido(), a.getFecha_nacimiento(), a.getDireccion(), a.getTelefono(), a.getCorreo(), id);
        mav.addObject(new tipoModel());
        return new ModelAndView("redirect:/usuario.htm");
    }

    @RequestMapping(value = "editarMarca.htm", method = RequestMethod.GET)
    public ModelAndView EditarMarca(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "select * from marca where id_marca = " + id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("editarMarca");
        return mav;
    }

    @RequestMapping(value = "editarMarca.htm", method = RequestMethod.POST)
    public ModelAndView EditarMarca(marcaModel a) {
        String sql = "update marca set nombre_marca = ?, fecha_creacion = ?  where id_marca = ?";
        this.jdbcTemplate.update(sql, a.getNombre_marca(), a.getFecha_creacion(), id);
        mav.addObject(new marcaModel());
        return new ModelAndView("redirect:/marca.htm");
    }
    
    @RequestMapping(value = "eliminarRol.htm")
    public ModelAndView EliminarRol(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "delete from rol where id_rol = " + id;
        this.jdbcTemplate.update(sql);
        return new ModelAndView("redirect:/rol.htm");
    }
    
    @RequestMapping(value = "eliminarTipoAuto.htm")
    public ModelAndView EliminarTipoAuto(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "delete from tipo where id_tipo = " + id;
        this.jdbcTemplate.update(sql);
        return new ModelAndView("redirect:/tipoauto.htm");
    }
    
    @RequestMapping(value = "eliminarUsuario.htm")
    public ModelAndView EliminarUsuario(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "delete from usuario where id_usuario = " + id;
        this.jdbcTemplate.update(sql);
        return new ModelAndView("redirect:/usuario.htm");
    }
    
    @RequestMapping(value = "eliminarMarca.htm")
    public ModelAndView EliminarMarca(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "delete from marca where id_marca = " + id;
        this.jdbcTemplate.update(sql);
        return new ModelAndView("redirect:/marca.htm");
    }
    
    @RequestMapping(value = "editarAutomovil.htm", method = RequestMethod.GET)
    public ModelAndView EditarAutomovil(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "select * from automovil where id_automovil = " + id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datosAutomovil", datos);
        sql = "select * from marca";
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datosMarca", datos);
        sql = "select * from tipo";
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datosTipo", datos);
        mav.setViewName("editarAutomovil");
        return mav;
    }
    
    @RequestMapping(value = "editarAutomovil.htm", method = RequestMethod.POST)
    public ModelAndView EditarAutomovil(automovilModel a) {
        String sql = "UPDATE automovil SET gama = ?, fecha_creacion = ?, precio = ?, ocupado = ?, activo = ?, id_marca = ?, id_tipo = ? WHERE id_automovil = ?";
        this.jdbcTemplate.update(sql, a.getGama(), a.getFecha_creacion(), a.getPrecio(), a.getOcupado(), a.getActivo(), a.getId_marca(), a.getId_tipo(), id);
        return new ModelAndView("redirect:/automovil.htm");
    }

    @RequestMapping(value = "eliminarAutomovil.htm")
    public ModelAndView EliminarAutomovil(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "DELETE FROM automovil WHERE id_automovil = " + id;
        this.jdbcTemplate.update(sql);
        return new ModelAndView("redirect:/automovil.htm");
    }
    
    @RequestMapping(value = "editarRenta.htm", method = RequestMethod.GET)
    public ModelAndView EditarRenta(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "SELECT * FROM renta WHERE id_renta = " + id;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datosRenta", datos);
        sql = "select a.id_automovil, a.gama, a.precio, m.nombre_marca from automovil a INNER JOIN marca m ON a.id_marca = m.id_marca";
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datosAutomovil", datos);
        sql = "SELECT * FROM usuario";
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datosCliente", datos);
        mav.setViewName("editarRenta");
        return mav;
    }
    
    @RequestMapping(value = "editarRenta.htm", method = RequestMethod.POST)
    public ModelAndView EditarRenta(rentaModel a) {
        String sql = "UPDATE renta SET precio = ?, fecha_alquiler = ?, id_automovil = ?, id_usuario = ? WHERE id_renta = ?";
        this.jdbcTemplate.update(sql, a.getPrecio(), a.getFecha_alquiler(), a.getId_automovil(), a.getId_usuario(), id);
        return new ModelAndView("redirect:/renta.htm");
    }

}
