package com.getafe.curso;

import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
	name = "ServletPedido",
	urlPatterns = "/ServletPedido"
)
public class ServletPedido extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public ServletPedido()
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

		// Inicializar / recuperar carrito de la compra
		CarritoCompra carrito = Util.getCarritoCompra(session);
		
		// Recorrer los parámetros "cant"<Id>
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements())
		{
			String atr = parameterNames.nextElement();
			if (atr.startsWith("cant"))
			{
				int idProducto = Integer.parseInt(atr.substring(4));
				Producto p = ProductosFD.instancia().getProductoById(idProducto);
				
				ElementoPedido elemento = new ElementoPedido(p);
				
				// TODO: Validar cantidad pedida
				String sCantPed = request.getParameter(atr);
				elemento.setCantidadPedida(Integer.parseInt(sCantPed));
				elemento.setTotal(p.getPrecio() * elemento.getCantidadPedida());
				
				carrito.addElemento(elemento);
				
			}
			
			session.setAttribute("carritoCompra", carrito);
		}
		
		Util.logSesion(session);
		
		response.sendRedirect("frmProductos.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
