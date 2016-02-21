package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.*;
import java.awt.*;

@Controller
@RequestMapping("/start")
public class MainController {
    public MainController(){
        System.out.println("Hi_start");
        //JOptionPane.showMessageDialog(new Frame(), "Hi drug");
    }
    @RequestMapping("/what")
    public void go(){
        System.out.println("Hi_ 2");
        JOptionPane.showMessageDialog(new Frame(), "Hi rus");
    }
}
