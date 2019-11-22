package com.getafe.curso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * El web service se llama con /CalculadoraWS?x=3&y=7&op=sumar
 */
@WebServlet("/Calculadora")
public class Calculadora extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public Calculadora()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter writer = response.getWriter();
		
		// Recuperar los parámetros
		String parX = request.getParameter("x");
		String parY = request.getParameter("y");
		String op = request.getParameter("op");
		
		
		// Guardarlos en variables, pasar x e y a entero
		int x, y;
		try
		{
			 x = Integer.parseInt(parX);
		}
		catch (NumberFormatException e)
		{
			throw new RuntimeException("Argumento 'x' no numerico: " + parX);
		}

		try
		{
			 y = Integer.parseInt(parY);
		}
		catch (NumberFormatException e)
		{
			throw new RuntimeException("Argumento 'y' no numerico: " + parY);
		}
		
		// Hacer if / else o switch para calcular el valor
		int resultado; 
		if("sumar".equals(op))
		{
			resultado = x + y;
		}
		else if ("restar".equals(op))
		{
			resultado = x - y;
		}
		else if ("multiplicar".equals(op))
		{
			resultado = x * y;
		}
		else if ("dividir".equals(op))
		{
			resultado = x / y;
		}
		else
		{
			throw new RuntimeException("Operacion no disponible: " + op);
		}
		
		// Montar la estructura JSON y devolverla al cliente
		//cadResultado = "{ \"sumar\": \"" + cadResultado + "\"}";
		//writer.print(((Integer)resultado).toString());
		
		ResultadoOperacion result = new ResultadoOperacion(x, y, op, resultado);
		
		Gson gson = new Gson();
		
		String json = gson.toJson(result);
		writer.append(json);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		doGet(request, response);
	}

}
