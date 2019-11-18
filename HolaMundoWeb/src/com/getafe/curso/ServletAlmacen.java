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

			String nombre = request.getParameter("nombre");
			double precio = Double.parseDouble(request.getParameter("precio"));
			int stock = Integer.parseInt(request.getParameter("stock"));
			
			ProductosFD.instancia().altaProducto(nombre, precio, stock);
			
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
		}
		
		response.sendRedirect("almacen.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
