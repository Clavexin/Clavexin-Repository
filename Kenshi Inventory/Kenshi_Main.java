import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
public class Kenshi_Main {

static int iwidth;
static int ilength;
static int iX;
static int iY;
static int nX;
static int nY;
static int nwidth;
static int nlength;
static int[][] array = new int[10][10];
static JButton[][] t = new JButton[10][10];
	public static void main(String[] args) {
		window();
	}

public static void window() {
    JFrame window = new JFrame("Kenshi");
    window.setSize(700,100);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLayout(new FlowLayout());
    Label textwidth = new Label("WIDTH: ");
    Label textlength = new Label("LENGTH: ");
    Label textXY = new Label("X Y:");
    TextField itemwidth = new TextField(10);
    TextField itemlength = new TextField(10);
    TextField itemXY= new TextField(10);
    JButton itementer = new JButton("CLICK");
    JButton EXITSYS = new JButton("EXIT");
    window.add(textwidth);
    window.add(itemwidth);
    window.add(textlength);
    window.add(itemlength);
    window.add(textXY);
    window.add(itemXY);
    window.add(itementer);
    window.add(EXITSYS);
    window.setVisible(true);
    itementer.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
			iwidth = Integer.parseInt(itemwidth.getText());
			ilength = Integer.parseInt(itemlength.getText());
			String XY=itemXY.getText();
	        String[] strArr = XY.split("\\s");
	        iX=Integer.parseInt(strArr[0]);
	        iY=Integer.parseInt(strArr[1]);
	        try {
				cal();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
        }
    });
    EXITSYS.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
}

public static void cal() throws InterruptedException {
	for( int i  = 0; i<iwidth ; i++) {
		for(int j = 0; j<ilength;j++) {
			array[iX+i][iY+j] = 1;
		}
	}
	print();
}

public static void print() throws InterruptedException {
    JFrame print = new JFrame("Kenshi");
    print.setSize(1000,1100);
    print.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    print.setLayout(new GridLayout(2,1));
    Panel panel1 = new Panel();
	panel1.setLayout(new GridLayout(10,10));
	panel1.setSize(900,900);
	Panel panel2 = new Panel();
	panel2.setLayout(new FlowLayout());
	panel2.setSize(100, 30);
	Label SIZEXINST = new Label("LENGTH :");
	TextField SIZEXTEXT = new TextField(10);
	Label SIZEYINST = new Label("WIDTH :");
	TextField SIZEYTEXT = new TextField(10);
    JButton finishprogram = new JButton("FINISH");
    panel2.add(SIZEXINST);
    panel2.add(SIZEXTEXT);
    panel2.add(SIZEYINST);
    panel2.add(SIZEYTEXT);
    panel2.add(finishprogram);
    print.add(panel1);
    print.add(panel2);
    finishprogram.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
    for(int i = 0;i<array.length;i++) {
    	for(int j = 0;j<array[0].length;j++) {
    		int a=i;
    		int b=j;
			if(array[i][j]==1) {
    			t[i][j] = new JButton();
                t[i][j].setBackground(Color.BLACK);
                t[i][j].setForeground(Color.BLACK);
                t[i][j].setSize(100, 100);
                panel1.add(t[i][j]);
                t[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int c = Integer.parseInt(SIZEXTEXT.getText());
						int d = Integer.parseInt(SIZEYTEXT.getText());
						System.out.printf("%d %d %d %d\n",a, b, c, d);
					}
				});
                
    		}
    		if(array[i][j]==0) {
    			t[i][j] = new JButton();
                t[i][j].setBackground(Color.WHITE);
                t[i][j].setForeground(Color.WHITE);
                t[i][j].setSize(100, 100);
                panel1.add(t[i][j]);
                t[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int c = Integer.parseInt(SIZEXTEXT.getText());
						int d = Integer.parseInt(SIZEYTEXT.getText());
						System.out.printf("%d %d %d %d\n",a, b, c, d);
						if(array[a][b]!=1) {
							for(int i=0;i<c;i++) {
								for(int j=0;j<d;j++) {
									t[a+i][b+j].setBackground(Color.BLACK);
									array[a][b] = 1;
								}
							}
						}
					}
				});
    		}
    	}
    }
    print.setVisible(true);
}
}