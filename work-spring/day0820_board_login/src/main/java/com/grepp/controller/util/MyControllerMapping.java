package com.grepp.controller.util;

import com.grepp.controller.BoardController;
import com.grepp.controller.MainController;
import com.grepp.controller.MemberController;
import com.grepp.controller.MyController;

public class MyControllerMapping {
    private BoardController boardController = new BoardController();
    private MemberController memberController = new MemberController();
    private MainController mainController = new MainController();

    public MyController getController(String command){
        if(command.startsWith("/member"))
            return memberController;
        else if(command.startsWith("/board"))
            return boardController;
        else
            return mainController;
    }
}
