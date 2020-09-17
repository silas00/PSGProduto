package br.com.psg.produto.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

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

			String filePath = uploadPath + produto.getArquivo();

			byte[] uploadedFile = Files.readAllBytes(Paths.get(filePath));

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