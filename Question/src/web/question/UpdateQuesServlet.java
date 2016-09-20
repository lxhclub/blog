package web.question;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.QuestionService;
import service.SelectorService;
import service.impl.QuestionServiceImpl;
import service.impl.SelectorServiceImpl;

public class UpdateQuesServlet extends HttpServlet {
	

	
		
		@Override
		public void destroy() {
			super.destroy();
		}

		
		@Override
		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			doPost(request, response);
		}

		
		@Override
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			QuestionService qs = new QuestionServiceImpl();
			SelectorService ss = new SelectorServiceImpl();
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("oid");
			int delSel=0;
			System.out.println("id="+id);
			int oid = Integer.parseInt(id);
			String qseq = request.getParameter("seq");
			int seq = Integer.parseInt(qseq);
			delSel = ss.deleteSelecter(seq, oid);
			if (delSel > 0) {
				int deleteQues = qs.deleteQues(seq, oid);
				if (deleteQues > 0) {
					String content = request.getParameter("content");
					//content=new String(content.getBytes("iso8859-1"),"UTF-8");
					int qtype = Integer.parseInt(request.getParameter("qtype"));
					int addQues = qs.addQues(oid, content, qtype, seq);
					System.out.println(addQues);
					if (addQues > 0) {
				//插入选项数据
				int listCnt = Integer.parseInt(request.getParameter("listCnt"));
				System.out.println("listCnt="
						+ request.getParameter("listCnt"));
				for (int i = 0; i < listCnt; i++) {
					String name = String.valueOf("txt_" + i);
					String value = request.getParameter(name);
					//value=new String(value.getBytes("iso8859-1"),"UTF-8");
					ss.addSelecter(oid, seq, value, i);
				}
				System.out.println("listCnt=" + listCnt);
					}
				}
			}
			response.sendRedirect("quesList.jsp?oid=" + oid);

	}
		
	}




