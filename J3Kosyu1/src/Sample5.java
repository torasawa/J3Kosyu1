

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sample5
 */
@WebServlet("/Sample5")
public class Sample5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sample5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			//フォームデータの取得
			String carname = "";
			String tmp = request.getParameter("cars");
			if(tmp != null){
				carname = new String(tmp.getBytes("8859_1"), "UTF-8");
			}

			// サーブレットコンテキストの取得
			ServletContext sc = getServletContext();

			response.setContentType("text/html; charset=UTF-8");

			// リクエストの転送
			if(carname.length() != 0) {
				sc.getRequestDispatcher("/thanks.html").forward(request, response);
			} else {
				sc.getRequestDispatcher("/error.html").forward(request, response);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
