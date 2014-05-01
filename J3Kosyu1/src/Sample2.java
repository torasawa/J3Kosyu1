

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sample2
 */
@WebServlet("/Sample2")
public class Sample2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sample2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			// フォームデータの取得
			String tmp = request.getParameter("cars");
			String carname = new String(tmp.getBytes("8859_1"), "UTF-8");

			// コンテンツタイプの設定
			response.setContentType("text/html; charset=UTF-8");

			// HTML文書の書出し
			PrintWriter pw = response.getWriter();
			pw.println(
					"<html>\n" +
					"<head><title>" + carname + "</title></head>\n" +
					"<body><center>\n" +
					"<h2>" + carname + "</h2>\n" +
					carname + "のお買い上げありがとうございました。<br />\n" +
					"</center></body>\n" +
					"</html>\n"
					);

			pw.close();

		}catch(Exception e){
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
