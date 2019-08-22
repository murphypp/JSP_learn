package com.ucar.training.controller;

import com.ucar.training.entity.Message;
import com.ucar.training.entity.User;
import com.ucar.training.service.IMessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MessageController {
    @Resource
    private IMessageService messageServiceImpl;
    @RequestMapping("/leavingMessage")
    public String toLeaveMessage(HttpSession session, HttpServletRequest request){
        User user = (User) session.getAttribute("current");
        String username = user.getUsername();
        request.setAttribute("count",messageServiceImpl.getUserMessages(username));
        return "forward:leavingMessage.jsp";
    }
    @RequestMapping("/addMessage")
    public String addMessage(String message, HttpSession session){
        User user = (User) session.getAttribute("current");
        String username = user.getUsername();
        Message m = new Message(message,username);
        messageServiceImpl.addMessage(m);
        return "redirect:leavingMessage.action";
    }
    @RequestMapping("/messageManage")
    public String messageManage(){
        return "forward:viewMessages.action";
    }

    @RequestMapping("/viewMessages")
    public String viewMessages(HttpServletRequest request){
        String select = request.getParameter("select");
        if(select == null)select = "";
        List<Message> messages;
        messages = messageServiceImpl.getAllMessage();
        if(!"".equals(select)){
            messages = messageServiceImpl.getUserMessages(select);
        }
        request.setAttribute("allMessages",messages);
        return "forward:/manage/messageManage.jsp";
    }
    @RequestMapping("/delMessage")
    public String delMessage(String id){
        messageServiceImpl.deleteMessage(id);
        return "redirect:/viewMessages.action";
    }

}
