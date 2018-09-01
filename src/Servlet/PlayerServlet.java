package Servlet;

import Domain.PageBean;
import Domain.Player;
import Service.PlayerService;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class PlayerServlet extends BaseServlet {

    private PlayerService playerService = new PlayerService();

    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        Player player = CommonUtils.toBean(request.getParameterMap(),Player.class);
        player.setId(CommonUtils.uuid());
        playerService.add(player);
        request.setAttribute("msg","恭喜，成功添加球员");
        return "/msg.jsp";
    }

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int pageCode = getPageCode(request);
        int pageRecode = 10;
        PageBean<Player> pageBean = playerService.findAll(pageCode,pageRecode);
        pageBean.setUrl(getUrl(request));
        request.setAttribute("pb",pageBean);
        return "f:/list.jsp";
    }

    private int getPageCode(HttpServletRequest request){
        String value = request.getParameter("pc");
        if (value == null || value.trim().isEmpty()){
            return 1;
        }
        return Integer.parseInt(value);
    }

    public String preEdit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String id = request.getParameter("id");
        Player player = playerService.find(id);
        request.setAttribute("customer",player);
        return "/edit.jsp";
    }

    public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Player player = CommonUtils.toBean(request.getParameterMap(),Player.class);
        playerService.edit(player);
        request.setAttribute("msg","恭喜，编辑球员成功");
        return "/msg.jsp";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
        playerService.delete(id);
        request.setAttribute("msg","恭喜，删除球员成功");
        return "/msg.jsp";
    }

    public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Player player = CommonUtils.toBean(request.getParameterMap(),Player.class);
        player = encodeing(player);
        int pageCode = getPageCode(request);
        int pageRecord = 10;
        PageBean<Player> pageBean = playerService.query(player,pageCode,pageRecord);
        pageBean.setUrl(getUrl(request));
        request.setAttribute("pb",pageBean);
        return "/list.jsp";
    }

    private Player encodeing(Player player) throws UnsupportedEncodingException {
        String name = player.getName();
        String team = player.getTeam();
        String position = player.getPosition();
        String age = player.getAge();

        if (name != null && !name.trim().isEmpty()){
            name = new String(name.getBytes("ISO-8859-1"),"utf-8");
            player.setName(name);
        }

        if (team != null && !team.trim().isEmpty()){
            team = new String(team.getBytes("ISO-8859-1"),"utf-8");
            player.setTeam(team);
        }

        if (position != null && !position.trim().isEmpty()){
            position = new String(position.getBytes("ISO-8859-1"),"utf-8");
            player.setPosition(position);
        }

        if (age != null && !age.trim().isEmpty()){
            age = new String(age.getBytes("ISO-8859-1"),"utf-8");
            player.setAge(age);
        }

        return player;

    }

    private String getUrl(HttpServletRequest request){
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String queryString = request.getQueryString();

        if (queryString.contains("&pc=")) {
            int index = queryString.lastIndexOf("&pc=");
            queryString = queryString.substring(0, index);
        }

        return contextPath + servletPath + "?" + queryString;
    }

}
