package epita.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import epita.fr.datamodels.QuestionModel;

@WebServlet("/question")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	QuestionModel questionModel = new QuestionModel();
	request.setAttribute("question", questionModel.findAll());
	request.getRequestDispatcher("question/index.jsp").forward(request,response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int score= 0;
		QuestionModel questionModel	=new QuestionModel();	
		String[ ]questionIds=request.getParameterValues("questionId");
		for(String questionId:questionIds) {
			int answerIdConnect = questionModel.findAnswerIdCorrect(Integer.parseInt(questionId));
		if(answerIdConnect == Integer.parseInt(request.getParameter("question_"+questionId))) {
			score++;
		}
		}
		request.setAttribute("score", score);
		request.getRequestDispatcher("question/request.jsp").forward(request, response);
		
			}

}
