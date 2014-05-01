

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Sample4
 */
@WebServlet("/Sample4")
public class Sample4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sample4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			//セッションの取得
			HttpSession hs = request.getSession(true);
			Integer cn = (Integer)hs.getAttribute("count");
			Date dt = (Date)hs.getAttribute("date");

			String str1, str2;

			//回数の設定
			if(cn == null) {
				cn = new Integer(1);
				dt = new Date();
				str1 = "初めておこしですね。";
				str2 = "";
			} else {
				cn = new Integer(cn.intValue() + 1);
				dt = new Date();
				str1 = cn + "回目のおこしですね。";
				str2 = "(前回:" + dt + ")";
			}

			// セッションの設定
			hs.setAttribute("count", cn);
			hs.setAttribute("date", dt);

			// コンテンツタイプの設定
			response.setContentType("text/html; charset=UTF-8");

			// HTML文書の書出し
			PrintWriter pw = response.getWriter();
			pw.println(
					"<html>\n" +
					"<head><title>サンプル</title></head>\n" +
					"<body><center>\n" +
					"<h2>ようこそ</h2>\n" +
					"<hr />\n" +
					str1 + "<br />\n" +
					str2 + "<br />\n" +
					"お選びください<br/>\n" +
					"<br />" +
					"<a href=\"../car1.html\">乗用車</a><br />\n " +
					"<a href=\"../car2.html\">トラック</a><br />\n " +
					"<a href=\"../car3.html\">オープンカー</a><br />\n " +
					"</center></body>\n"+
					"</html>"
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
