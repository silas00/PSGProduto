package br.com.psg.produto.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.psg.produto.dao.ProdutoDAO;
import br.com.psg.produto.dao.impl.ProdutoDAOImpl;
import br.com.psg.produto.modal.Produto;

@WebServlet("/produto/download")
public class DownLoadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DownLoadController() {

	}

	private final String uploadPath = "C:/uploads/";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			ProdutoDAO dao = ProdutoDAOImpl.getInstance();

			Long id = Long.parseLong(request.getParameter("id"));
			Produto produto = dao.findProdutoById(id);

			byte[] uploadedFile;

			File file = new File(uploadPath + produto.getArquivo());

			uploadedFile = new byte[(int) file.length()];

			ByteArrayOutputStream baos = new ByteArrayOutputStream(uploadedFile.length);
			baos.write(uploadedFile, 0, uploadedFile.length);

			response.setHeader("Content-Disposition", "attachment;filename=" + produto.getArquivo());
			response.setContentLength(baos.size());

			OutputStream os = response.getOutputStream();

			baos.writeTo(os);

			os.flush();
			os.close();

		}

		catch (Exception e) {

			System.out.println("Erro 003 DownLoadController: " + e.getMessage());
			
		}
	}
}