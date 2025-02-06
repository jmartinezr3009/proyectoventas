package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALEDA
 */
public class Controlador extends HttpServlet {
    Empleado em = new Empleado();
    Cliente c = new Cliente();
    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    ClienteDAO cdao = new ClienteDAO();
    EmpleadoDAO edao = new EmpleadoDAO();
    int ide;
    int idc;
    int idp;

    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item = 0;  // Inicializado en 0
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar = 0.0;  // Inicializado en 0.0

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar" -> {
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                }
                case "Agregar" -> {
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTel");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUser");
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                }
                case "Editar" -> {
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                }
                case "Actualizar" -> {
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String tel1 = request.getParameter("txtTel");
                    String est1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUser");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                }
                case "Delete" -> {
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                }
                default -> throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if (menu.equals("Cliente")) {
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        }
        if (menu.equals("Producto")) {
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if (menu.equals("NuevaVenta")) {
            switch (accion) {
                case "BuscarCliente" -> {
                    String dni = request.getParameter("codigo_cliente");  // Corregido el nombre del parámetro
                    c.setDni(dni);
                    Cliente cl = cdao.buscar(dni);
                    request.setAttribute("Cliente", cl);
                }
                case "BuscarProducto" -> {
                    int id = Integer.parseInt(request.getParameter("codigoproducto"));
                    p = pdao.listarId(id);
                    request.setAttribute("producto", p); 
                    request.setAttribute("lista", lista);
                }
                case "Agregar" -> {
                    totalPagar = 0.0;
                    item = item + 1;
                    cod = p.getId();
                    descripcion = request.getParameter("nomproducto");
                    precio = Double.parseDouble(request.getParameter("Precio"));
                    cant = Integer.parseInt(request.getParameter("Cantidad"));
                    subtotal = precio * cant;
                    v = new Venta();
                    v.setItem(item);
                    v.setId(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                }
                default -> throw new AssertionError();
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}