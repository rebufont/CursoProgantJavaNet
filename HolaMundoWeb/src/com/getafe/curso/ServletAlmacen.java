package com.getafe.curso;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletAlmacen")
public class ServletAlmacen extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public ServletAlmacen()
    {
        super();
    }

    /*
     * Este método doGet() es llamado por el servidor "internamente"
     * cuando recibe una solicitud HTTP de tipo "GET". A esto se le llama "callback".
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		
		String accion = request.getParameter("accion");
		
		if (accion.equals("Nuevo"))
		{
			try
			{
				String nombre = request.getParameter("nombre");
				double precio = Double.parseDouble(request.getParameter("precio"));
				int stock = Integer.parseInt(request.getParameter("stock"));
				
				ProductosFD.instancia().altaProducto(nombre, precio, stock);
			}
			catch (RuntimeException e)
			{
				// TODO: Informar del error al usuario
			}
			
			response.sendRedirect("almacen.jsp");
			
		}
		else if (accion.equals("Eliminar"))
		{
			Enumeration<String> parameterNames = request.getParameterNames();
			while (parameterNames.hasMoreElements())
			{
				String atr = parameterNames.nextElement();
				
				System.out.println(atr);
				
				if (atr.startsWith("elim"))
				{
					System.out.println(" *** " + request.getParameter(atr));
					
					System.out.println("Eliminando: " + atr);
				
					int idProducto = Integer.parseInt(atr.substring(4));
					Producto p = ProductosFD.instancia().getProductoById(idProducto);

					ProductosFD.instancia().eliminarProducto(idProducto);
					
				}
				
			}
			response.sendRedirect("almacen.jsp");
			
		}
		else if (accion.equals("Modificar..."))
		{
			String parIdModificar = request.getParameter("idModificar");
			
			if (parIdModificar != null)
			{
				int idModificar = Integer.parseInt(parIdModificar);
				
				response.sendRedirect("almacen_modificar.jsp?idModificar=" + idModificar);
			}
			else
			{
				response.sendRedirect("almacen.jsp");	
				
			}
			
		}
		else if (accion.equals("Guardar..."))
		{
			String parIdModificar = request.getParameter("modIdProducto");
			if (parIdModificar != null)
			{
				int idProducto = Integer.parseInt(parIdModificar);
				
				String nombre = request.getParameter("modNombre");
				double precio = Double.parseDouble(request.getParameter("modPrecio"));
				int stock = Integer.parseInt(request.getParameter("modStock"));				
			
				ProductosFD.instancia().modificar(idProducto, nombre, precio, stock);
				
				response.sendRedirect("almacen.jsp");
			}
			else
			{
				response.sendRedirect("almacen.jsp");
				
			}
		}
		else
		{
			// Por aquí no se debería pasar nunca
			response.sendRedirect("almacen.jsp");		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
