package com.tomasnama.servlet;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Servlet implementation class PrintServlet
 */
@WebServlet(urlPatterns = { "/print" })
public class PrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int DEFAULT_BUFFER_SIZE = 8192;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrintServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InputStream input = getClass().getClassLoader().getResourceAsStream("/test.pdf");
		BufferedOutputStream output = null;

		output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);

		try {
			String ref = request.getParameter("ref");

			response.reset();
			response.setBufferSize(DEFAULT_BUFFER_SIZE);
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "filename=\"document.pdf\"");

			byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];

			int bytesRead = 0;

			ByteArrayOutputStream bao = new ByteArrayOutputStream();

			while ((bytesRead = input.read(buffer)) != -1) {
				output.write(buffer, 0, bytesRead);
			}

		} catch (Exception e) {
			response.reset();
			response.setBufferSize(DEFAULT_BUFFER_SIZE);
			response.setContentType("text/html");
			output.write("ERROR".getBytes(Charset.forName("UTF-8")));
		} finally {
			if (output != null) {
				output.close();
			}
			if (input != null) {
				input.close();
			}
		}

	}
}
