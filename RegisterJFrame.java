import com.sun.source.tree.NewArrayTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Scanner;

public class RegisterJFrame extends JFrame implements MouseListener {

    public RegisterJFrame(){
        this.setSize(550,600);
        //设置标题
        this.setTitle("白猪拼图注册");
        //设置位置
        this.setLocationRelativeTo(null);
        //关闭模式
        this.setDefaultCloseOperation(1);
        //添加内容吧
        JLabel main=new JLabel(new ImageIcon("C:\\Users\\86134\\IdeaProjects\\feibo\\Register\\ground.png"));
        main.setBounds(0,0,508,560);
        JLabel register=new JLabel(new ImageIcon("C:\\Users\\86134\\IdeaProjects\\feibo\\Register\\register.png"));
        register.setBounds(150,200,240,174);
        this.getContentPane().add(register);
        this.getContentPane().add(main);
        this.setVisible(true);
        //监视一下
        register.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        boolean a=true;
        while (a) {
            System.out.println("请输入账号");
            Scanner sc = new Scanner(System.in);
            user us = new user();
            us.setUsers(sc.next());
            System.out.println("请输入密码");
            us.setPassword(sc.next());
            user.us.add(us);
            System.out.println("注册完毕，如果要登录扣1");
            if (sc.nextInt()==1)
            {
                new LoginJFrame();
                this.setVisible(false);
                a=false;
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
