package cn.DoO.Background.api.controller.status;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.DoO.Background.api.servlet.login.RootLoginServlet;
import cn.DoO.Background.api.servlet.status.CommentPoststatusServlet;
import cn.DoO.Background.api.servlet.status.LoginPoststatusServlet;
import cn.DoO.Background.api.servlet.status.PostPoststatusServlet;
import cn.DoO.Background.api.servlet.status.WebPoststatusServlet;



/**
 * @desc     写入登陆控制状态
 * @author 云尧
 *
 */
@SuppressWarnings("serial")

@WebServlet("/api/controller/status/loginpoststatus")
public class LoginPoststatus extends HttpServlet{

	LoginPoststatusServlet loginServlet=new LoginPoststatusServlet();
	
	
	@Override
	protected void service(HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		try {
			loginServlet.lPostStatus(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			
			Map<String, Object> data = new HashMap<>();
			data.put("code", "500");
			data.put("msg", "服务器内部错误");
			out.print(JSON.toJSONString(data));

		} finally {
			out.close();
		}
		
		
	}

	
}
