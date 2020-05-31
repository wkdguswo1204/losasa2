package losasa2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LosMainController implements LosController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("#############");
		String view = "/view/main.jsp";
		return view;
	}
}
