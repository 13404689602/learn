import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;
import java.util.Scanner;

public class LoginJFrame extends JFrame implements MouseListener {
    user user=new user();
    boolean verify=false;
    public LoginJFrame(){
        this.setSize(550,600);
        //设置标题
        this.setTitle("白猪拼图登录");
        //设置位置
        this.setLocationRelativeTo(null);
        //关闭模式
        this.setDefaultCloseOperation(1);
        //添加内容
        JLabel mai=new JLabel(new ImageIcon("C:\\Users\\86134\\IdeaProjects\\feibo\\Register\\ground.png"));
        mai.setBounds(0,0,200,250);
        JLabel login=new JLabel(new ImageIcon("C:\\Users\\86134\\IdeaProjects\\feibo\\Register\\login.png"));
        login.setBounds(200,200,175,113);
        this.getContentPane().add(login);
        this.getContentPane().add(mai);
        this.setVisible(true);
        login.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("请输入账号");
        Scanner sc=new Scanner(System.in);
        String users=sc.next();
        System.out.println("请输入密码");
        String password=sc.next();
        for (int i = 0; i < user.us.size(); i++) {
            if(Objects.equals(users, user.us.get(i).getUsers()) && Objects.equals(password, user.us.get(i).getPassword()))
            {
                verify=true;
                System.out.println("登录成功");
                this.setVisible(false);
                break;
            }
        }

        if (verify)
        {
            new GameJFrame();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
