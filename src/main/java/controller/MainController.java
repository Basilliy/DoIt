package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.awt.*;

@Controller
@RequestMapping(value="Start")
public class MainController {
    public MainController(){
        JOptionPane.showMessageDialog(new Frame(), "Hi");
    }
    @RequestMapping(value="go")
    public void go(){
        JOptionPane.showMessageDialog(new Frame(), "Hi");
    }
}
