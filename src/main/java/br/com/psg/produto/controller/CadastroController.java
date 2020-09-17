package br.com.psg.produto.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.com.psg.produto.dao.ProdutoDAO;
import br.com.psg.produto.dao.impl.ProdutoDAOImpl;
import br.com.psg.produto.modal.Produto;

@WebServlet("/produto/cadastro")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1MB
		maxFileSize = 1024 * 1024 * 4, // 4MB
		maxRequestSize = 1024 * 1024 * 4 // 4MB
)

public class CadastroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String uploadPath = "C:/uploads/";
	
	private ProdutoDAO produtoDao = ProdutoDAOImpl.getInstance();

	public CadastroController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String prodId = request.getParameter("id");
		String nome = request.getParameter("nome");
		String tipo = request.getParameter("tipo");
		double preco = Double.parseDouble(request.getParameter("preco"));
		String vencimento = request.getParameter("vencimento");

		Produto produto = new Produto(nome, tipo, preco, vencimento);
		
		Part upload = request.getPart("upload");

		if (upload != null) {
            System.out.println(upload.getName());
            System.out.println(upload.getSize());
            System.out.println(upload.getContentType());
            System.out.println(upload.getSubmittedFileName());
             
        }
		

		PrintWriter out = response.getWriter();

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			out.println("<h1>Voce não enviou um arquivo!</h1>");
			return;
		}

		try {
			
				if (upload != null) {

					String fileName = System.currentTimeMillis() + "_"  + upload.getSubmittedFileName();

					upload.write(uploadPath + fileName);
					produto.setArquivo(fileName);

				}
			

			if (prodId == null || prodId == "")
				produtoDao.saveProduto(produto);
			else {
				Long id = Long.parseLong(prodId);
				produto.setId(id);
				produtoDao.updateProduto(produto);
			}


		} catch (Exception e) {
			out.println("Erro 001 CadastroController: " + e.getMessage());
			return;
		}

		response.sendRedirect(request.getContextPath() + "/");
	}

}
