

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sample1
 */
@WebServlet("/Sample1")
public class Sample1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sample1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			//コンテンツタイプの設定
			response.setContentType("text/html; charset=UTF-8");

			//時刻の取得
			Date dt = new Date();

			// HTML文書の書出し
			PrintWriter pw = response.getWriter();
			pw.println(
					"<html>\n" +
					"<head><title>サンプル</title></head>\n" +
					"<body><center>\n" +
					"<h2>ようこそ<h2>" +
					"<hr /> \n" +
					"今" + dt + "です。<br />\n" +
					"<br />\n" +
					"<a href=\"../car1.html\">乗用車</a><br />\n " +
					"<a href=\"../car2.html\">トラック</a><br />\n " +
					"<a href=\"../car3.html\">オープンカー</a><br />\n " +
					"</center></body>\n"+
					"</html>"
					);

			pw.close();

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
