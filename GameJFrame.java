import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.http.WebSocket;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, MouseListener {

    int[][] number = new int[4][4];
    int space=0;
    int[][] win = new int[][]{{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};
    int count = 0;
    JMenuItem replay = new JMenuItem("重新游戏");
    JMenuItem relogin = new JMenuItem("重新登录");
    JMenuItem closeitem = new JMenuItem("关闭游戏");

    JMenuItem accountitem = new JMenuItem("公众号");

    //JMenuItem select =new JMenuItem("切换图片");

    JMenuItem yu =new JMenuItem("宇神");
    public GameJFrame() {
        //初始化页面
        initpage();
        //初始化菜单
        initmenu();
        //初始化数据
        initdata();
        //初始化图片
        initimage();
        //移动玩法
        initplatguide();
    }

    String path = "C:\\Users\\86134\\IdeaProjects\\feibo\\图片\\";


    private void initplatguide() {
        //键盘监视吧 如果上

        this.addKeyListener(this);
    }

    private void initdata() {
        //定义一个一维数组
        int[] temp = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //打乱顺序
        Random r = new Random();
        for (int i = 0; i < temp.length; i++) {
            int random = r.nextInt(temp.length);
            int tempa = temp[i];
            temp[i] = temp[random];
            temp[random] = tempa;
        }
        int count = 0;
        //给二维数组添加数据
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                number[j][i] = temp[count];
                count++;
            }
        }
    }

    private void initimage() {
        //删除所有图片
        this.getContentPane().removeAll();
        //如果符合
        JLabel temp = new JLabel("步数:" + count);
        temp.setBounds(30, 30, 70, 30);
        this.getContentPane().add(temp);
        if (same()) {
            JLabel win = new JLabel(new ImageIcon(path + "win.png"));
            win.setBounds(200, 200, 229, 87);
            this.getContentPane().add(win);
            this.repaint();
        }
        //设置每行
        for (int i = 0; i < 4; i++) {
            //控制一行的照片输出
            for (int j = 0; j < 4; j++) {
                //创建一个图片对象Imageicon
                ImageIcon icon = new ImageIcon(path + number[i][j] + ".png");
                //创建一个管理容器Jlabel
                JLabel jLabel = new JLabel(icon);
                //设置管理容器位置jlabel
                jLabel.setBounds(100 * j + 100, 100 * i + 140, 100, 100);
                //添加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //把管理容器添加到页面中
                this.getContentPane().add(jLabel);
            }
        }
        //设置背景
        JLabel background = new JLabel(new ImageIcon(path + "ground.png"));
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);
        //刷新
        this.getContentPane().repaint();
    }


    private void initmenu() {
        //初始化菜单
        JMenuBar jMenuBar = new JMenuBar();
        //菜单上的功能
        JMenu functionjMenu = new JMenu("功能");
        JMenu aboutjMenu = new JMenu("关于我们");
        JMenu select =new JMenu("切换图片");
        //功能细分

        replay.addMouseListener(this);

        relogin.addMouseListener(this);

        closeitem.addMouseListener(this);

        accountitem.addMouseListener(this);

        yu.addMouseListener(this);
        //添加功能
        jMenuBar.add(functionjMenu);
        jMenuBar.add(aboutjMenu);
        functionjMenu.add(replay);
        functionjMenu.add(select);
        functionjMenu.add(relogin);
        functionjMenu.add(closeitem);
        aboutjMenu.add(accountitem);
        select.add(yu);
        //给页面设置菜单
        this.setJMenuBar(jMenuBar);
        //打开
        this.setVisible(true);
    }

    private void initpage() {
        //设置游戏框大小
        this.setSize(603, 680);
        //设置标题
        this.setTitle("侠骨柔情小白猪 痞帅中 v1.10");
        //设置位置
        this.setLocationRelativeTo(null);
        //关闭模式
        this.setDefaultCloseOperation(3);
        //取消默认位置
        this.setLayout(null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (same()) {
            return;
        }
        //查看图片a
        if (e.getKeyCode() == 65) {
            //先把里面东西删除
            this.getContentPane().removeAll();
            //再插入完成图
            JLabel complete = new JLabel(new ImageIcon(path + "clue.png"));
            complete.setBounds(100, 140, 400, 400);
            JLabel background = new JLabel(new ImageIcon(path + "ground.png"));
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(complete);
            this.getContentPane().add(background);
            //刷新
            this.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (same()) {
            return;
        }
        int x = 0;
        int y = 0;
        //先获取空白处的位置
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                if (number[j][i] == space) {
                    x = j;
                    y = i;
                }
            }
        }
        //跟上边交换
        if (e.getKeyCode() == 38) {
            if (x == 0) {
                return;
            }
            number[x][y] = number[x - 1][y];
            number[x - 1][y] = space;

            //步数加1
            count++;
            initimage();
            //跟下边交换
        } else if (e.getKeyCode() == 40) {
            if (x == 3) {
                return;
            }
            number[x][y] = number[x + 1][y];
            number[x + 1][y] = space;

            //步数加1
            count++;
            initimage();
        }
        //跟右边交换
        else if (e.getKeyCode() == 39) {
            if (y == 3) {
                return;
            }
            number[x][y] = number[x][y + 1];
            number[x][y + 1] = space;

            //步数加1
            count++;
            initimage();
        }
        //跟左边交换
        else if (e.getKeyCode() == 37) {
            if (y == 0) {
                return;
            }
            number[x][y] = number[x][y - 1];
            number[x][y - 1] = space;

            //步数加1
            count++;
            initimage();
        }
        int count = 0;
        //便捷通过s
        if (e.getKeyCode() == 83) {
            int[] temp = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
            for (int j = 0; j < 4; j++) {
                for (int i = 0; i < 4; i++) {
                    number[j][i] = temp[count];
                    count++;
                }
            }
            initimage();
        }
        //查看图片a
        if (e.getKeyCode() == 65) {
            initimage();
        }

    }

    public boolean same() {
        //如果不匹配才能键盘监视
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < number.length; j++) {
                if (number[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource()==replay)
        {
            System.out.println("重新游戏");
            count=0;
            initdata();
            initimage();
        } else if (e.getSource()==relogin)
        {
            System.out.println("重新登录");
            new LoginJFrame();
        } else if (e.getSource()==closeitem) {
            System.out.println("关闭游戏");
            System.exit(1);
        } else if (e.getSource()==accountitem) {
            System.out.println("公众号");
            this.getContentPane().removeAll();
            JLabel media=new JLabel(new ImageIcon(path+"wx.png"));
            media.setBounds(100,100,399,399);
            this.getContentPane().add(media);
            this.getContentPane().repaint();
        } else if (e.getSource()==yu) {
            System.out.println("切换宇神");

            path="C:\\Users\\86134\\IdeaProjects\\feibo\\YU\\";
            space=15;
            initdata();
            initimage();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
