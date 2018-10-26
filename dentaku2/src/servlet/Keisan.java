package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BackMoney;
import model.Logic;
import model.OturiLogic;


@WebServlet("/Keisan")
public class Keisan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
	dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keisan = request.getParameter("keisan");
		String way = request.getParameter("way");
		String[] eng = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","y","v","x","w","y","z","!","#","$","'","%","&","(",")","*","?","}","{","`","+","-","~","|"};
		String[] ENG = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","W","Y","Z"};
		for(String english:eng){
			if(keisan.contains(english)){
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorAlp.jsp");
				dispatcher.forward(request, response);
			}
		}
		for(String ENGLISH:ENG){
			if(keisan.contains(ENGLISH)){
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorAlp.jsp");
				dispatcher.forward(request, response);
			}
		}

		if(keisan.equals("")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/notWrite.jsp");
			dispatcher.forward(request, response);
		}else if(!keisan.matches(".*[0-9].*")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorAlp.jsp");
			dispatcher.forward(request, response);
		}else{

		String[] math = keisan.split(" ");

		for(String mat:math){
			if(mat.equals("")){
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ErrorAlp.jsp");
				dispatcher.forward(request, response);
			}
		}

		double result = 0.0;
		String oturi =null;
		String oturi1 = null;

		// TODO 足し算
		if(way.equals("1")){
			Logic logic = new Logic();
			result = logic.tasu(math);
		}
		// TODO 引き算
		if(way.equals("2")){
			Logic logic = new Logic();
			result = logic.hiku(math);
		}

		// TODO 掛け算
		if(way.equals("3")){
			Logic logic = new Logic();
			result = logic.kakeru(math);
		}
		// TODO 割り算
		if(way.equals("4")){
			Logic logic = new Logic();
			result = logic.waru(math);
		}

		// TODO 平均
		if(way.equals("5")){
			Logic logic = new Logic();
			result = logic.heikin(math);
		}
		// TODO 半径
		if(way.equals("6")){
			if(math.length != 1){
				RequestDispatcher dispatcher = request.getRequestDispatcher("/twoWriteError.jsp");
				dispatcher.forward(request, response);
			}else{
				Logic logic = new Logic();
				result = logic.en(keisan);
			}
		}

		// TODO 乱数取得
		if(way.equals("7")){
			if(math.length != 1){

				RequestDispatcher dispatcher = request.getRequestDispatcher("/twoWriteError.jsp");
				dispatcher.forward(request, response);
			}else{
				Logic logic = new Logic();
				result = logic.ran(keisan);
			}
		}

		// TODO おつり
		if(way.equals("8")){
			int first =0;
			int itemPrice = 0;
			int payPrice = 0;
			for(String mat:math){
				if(first == 0){
					itemPrice = Integer.parseInt(mat);
					first++;
				}else{
					payPrice = Integer.parseInt(mat);
				}
			}
			try{
			if(math.length != 2){
				RequestDispatcher dispatcher = request.getRequestDispatcher("/twoWriteError.jsp");
				dispatcher.forward(request, response);
			}else if(itemPrice>payPrice){
				RequestDispatcher dispatcher = request.getRequestDispatcher("/oturi.jsp");
				dispatcher.forward(request, response);
			}else{
				OturiLogic oturiLogic = new OturiLogic();
				oturi = oturiLogic.oturi(math);

				BackMoney backmoney = new BackMoney();
				oturi1 = backmoney.backmoney(math);
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		}


		request.setAttribute("result",result);
		request.setAttribute("oturi", oturi);
		request.setAttribute("oturi1", oturi1);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
		dispatcher.forward(request, response);
		}
	}

}
