package Slide3;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;

/**
 * Servlet implementation class UploadFile
 */
@WebServlet("/UploadFile")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 15 // 15 MB
		)

public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/UpLoadFile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullname = request.getParameter("fullname");
		Part photo = request.getPart("photo");
		System.out.println(photo.getSubmittedFileName());
		String path = "/static/files/" + photo.getSubmittedFileName();
		System.out.println(path);
		String filename = request.getServletContext().getRealPath(path);
		System.out.println(filename);
//		ServletContext servletContext = request.getServletContext();
//		System.out.println(servletContext);
//		if (servletContext != null) {
//		    String filename = servletContext.getRealPath(path);
//		    System.out.println(filename);
		    photo.write(filename);
//		} else {
//		}
//		photo.write(filename);
		request.getRequestDispatcher("/views/UpLoadFile.jsp").forward(request, response);
	}

}
