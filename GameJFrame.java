import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.util.Random;

public class GameJFrame extends JFrame {

    int[][] number=new int[3][3];
    public GameJFrame(){
        //初始化页面
        initpage();
        //初始化菜单
        initmenu();
        //初始化数据
        initdata();
        //初始化图片
        initimage();
    }

    private void initdata() {
        //定义一个一维数组
        int[] temp ={0,1,2,3,4,5,6,7,8};
        //打乱顺序
        Random r=new Random();
        for (int i = 0; i < temp.length; i++) {
            int random= r.nextInt(temp.length);
            int tempa=temp[i];
            temp[i]=temp[random];
            temp[random]=tempa;
        }
        int count=0;
        //给二维数组添加数据
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                number[j][i]=temp[count];
                count++;
            }
        }
    }

    private void initimage() {
        //设置每行
        for (int i = 0; i < 3; i++) {
            //控制一行的照片输出
            for (int j = 0; j < 3; j++) {
                //创建一个图片对象Imageicon
                ImageIcon icon=new ImageIcon("C:\\Users\\86134\\IdeaProjects\\feibo\\图片\\"+number[i][j]+".png");
                //创建一个管理容器Jlabel
                JLabel jLabel=new JLabel(icon);
                //设置管理容器位置jlabel
                jLabel.setBounds(80*j+180,80*i+220,80,80);
                //添加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //把管理容器添加到页面中
                this.getContentPane().add(jLabel);
            }
        }
        //设置背景
        JLabel background=new JLabel(new ImageIcon("C:\\Users\\86134\\IdeaProjects\\feibo\\图片\\ground.png"));
        background.setBounds(40,40,508,560);
        this.getContentPane().add(background);
    }


    private void initmenu() {
        //初始化菜单
        JMenuBar jMenuBar=new JMenuBar();
        //菜单上的功能
        JMenu functionjMenu=new JMenu("功能");
        JMenu aboutjMenu=new JMenu("关于我们");
        //功能细分
        JMenuItem replay=new JMenuItem("重新游戏");
        JMenuItem relogin=new JMenuItem("重新登录");
        JMenuItem closeitem=new JMenuItem("关闭游戏");

        JMenuItem accountitem=new JMenuItem("公众号");
        //添加功能
        jMenuBar.add(functionjMenu);
        jMenuBar.add(aboutjMenu);
        functionjMenu.add(replay);
        functionjMenu.add(relogin);
        functionjMenu.add(closeitem);
        aboutjMenu.add(accountitem);
        //给页面设置菜单
        this.setJMenuBar(jMenuBar);
        //打开
        this.setVisible(true);
    }

    private void initpage() {
        //设置游戏框大小
        this.setSize(603,680);
        //设置标题
        this.setTitle("肥波拼图");
        //设置位置
        this.setLocationRelativeTo(null);
        //关闭模式
        this.setDefaultCloseOperation(3);
        //取消默认位置
        this.setLayout(null);
    }
}
