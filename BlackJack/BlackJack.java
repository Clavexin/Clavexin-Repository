import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BlackJack {
	
public static JLabel resultwin = new JLabel();
public static JLabel resultdraw = new JLabel();
public static JLabel resultlose = new JLabel();

public static JLabel nomoneylabel = new JLabel();

public static int dealercount = 0;
public static int playercount = 0;
public static int[] drrn = new int[10];
public static int[] plrn = new int[10];
public static JLabel fakedrlb2= new JLabel();
public static JLabel betlabel = new JLabel("| 베팅 금액 입력:");
public static int money=0;
public static int betmoney=0;
static int i=0;
static String[] arr = {"0","1","2","3","4","5","6","7","8","9"};
static JLabel[] drlb = new JLabel[10];
static JLabel[] pllb = new JLabel[10];
	public static void main(String[] arguments) {

		JFrame inputf = new JFrame("INPUT YOUR MONEY");
        inputf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icon = Toolkit.getDefaultToolkit().getImage("img/blackjackicon.png");
		inputf.setIconImage(icon);
		inputf.setSize(1000,70);
		JPanel inputpn = new JPanel(new FlowLayout(FlowLayout.CENTER));
		inputf.add(inputpn);
		JLabel inputmoneylabel = new JLabel("보유 금액을 입력하십시오:");
		JTextField inputmoneytext = new JTextField(7);
		Action inputmoneyaction = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				money=Integer.parseInt(inputmoneytext.getText());
				table();
				
			}
		};
		inputmoneytext.addActionListener(inputmoneyaction);
		inputpn.add(nomoneylabel);
		inputpn.add(inputmoneylabel);
		inputpn.add(inputmoneytext);
		inputf.setVisible(true);
		
	}
	public static void table() {
		JFrame tableframe = new JFrame("BLACK JACK");
		tableframe.setLayout(new GridLayout(3,1));
		JPanel drpn = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel ctpn = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel plpn = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Image icon = Toolkit.getDefaultToolkit().getImage("img/blackjackicon.png");
		tableframe.setIconImage(icon);
		tableframe.setSize(1920,1080);
		tableframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		tableframe.add(drpn);
		tableframe.add(ctpn);
		tableframe.add(plpn);
		String moneytext = Integer.toString(money);
		JLabel nowmoney1= new JLabel("현재 보유 금액:");
		ctpn.add(nowmoney1);
		JLabel nowmoney2= new JLabel(moneytext);
		ctpn.add(nowmoney2);
		
		ctpn.add(betlabel);
		JTextField bettext = new JTextField(10);
		bettext.setSize(100,30);
		ctpn.add(bettext);
		JButton ctstart = new JButton("게임 시작");
		ctpn.add(ctstart);
		JButton ctplus = new JButton("HIT");
		JButton ctstop = new JButton("STAY");
		JButton ctnewgame = new JButton("새 게임에 참가하시겠습니까?");
		tableframe.repaint();
		tableframe.revalidate();
		ctstart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				betmoney = Integer.parseInt(bettext.getText());
				if(betmoney<=money) {
					money=money-betmoney;
					ctpn.remove(nowmoney2);
					ctpn.remove(nowmoney1);
					ctpn.remove(betlabel);
					ctpn.remove(bettext);
				}
				else {
					betlabel.setText("| 잔액이 부족합니다.");

					betmoney=0;
					tableframe.dispose();
					table();
				}
				drlb[1] = new JLabel();
				drlb[2] = new JLabel();
				drlb[3] = new JLabel();
				for(int i=1;i<4;i++) {
				new Random();
				drrn[i] = (int) (Math.random()*11+1);
				if(drrn[i]==1) {
					drlb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/1.jpg")));
				}
				else if(drrn[i]==2) {
					drlb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/2.png")));
				}
				else if(drrn[i]==3) {
					drlb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/3.png")));
				}
				else if(drrn[i]==4) {
					drlb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/4.png")));
				}
				else if(drrn[i]==5) {
					drlb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/5.png")));
				}
				else if(drrn[i]==6) {
					drlb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/6.png")));
				}
				else if(drrn[i]==7) {
					drlb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/7.png")));
				}
				else if(drrn[i]==8) {
					drlb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/8.png")));
				}
				else if(drrn[i]==9) {
					drlb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/9.png")));
				}
				else if(drrn[i]==10) {
					drlb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/J.png")));
				}
				else if(drrn[i]==11) {
					drlb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/A.png")));
				}
				else {
					drlb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/cardback.png")));
				}
				}
				dealercount=dealercount+drrn[1]+drrn[2];
				drpn.add(drlb[1]);
				fakedrlb2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/cardback.png")));
				drpn.add(fakedrlb2);
				ctpn.remove(ctstart);
				ctpn.add(ctplus);
				ctpn.add(ctstop);
				for(int j=0;j<10;j++) {
					pllb[j] = new JLabel();
					pllb[j].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/cardback.png")));
				}
				tableframe.repaint();
				tableframe.revalidate();
			}
		});
		i=0;
		ctplus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Random();
				int rannum = (int) (Math.random()*11+1);
				plpn.add(pllb[i]);
				if(rannum==1) {
					pllb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/1.jpg")));
				}
				else if(rannum==2) {
					pllb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/2.png")));
				}
				else if(rannum==3) {
					pllb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/3.png")));
				}
				else if(rannum==4) {
					pllb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/4.png")));
				}
				else if(rannum==5) {
					pllb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/5.png")));
				}
				else if(rannum==6) {
					pllb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/6.png")));
				}
				else if(rannum==7) {
					pllb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/7.png")));
				}
				else if(rannum==8) {
					pllb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/8.png")));
				}
				else if(rannum==9) {
					pllb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/9.png")));
				}
				else if(rannum==10) {
					pllb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/J.png")));
				}
				else if(rannum==11) {
					pllb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/A.png")));
				}
				else {
					pllb[i].setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/cardback.png")));
				}
				playercount=playercount+rannum;
				i++;
				tableframe.repaint();
				tableframe.revalidate();
				if(i==10) {
					ctpn.remove(ctplus);
				}
			}
		});
		
		ctstop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ctpn.remove(ctplus);
				drpn.remove(fakedrlb2);
				drpn.add(drlb[2]);
				if(dealercount<17) {
					dealercount=dealercount+drrn[3];
					drpn.add(drlb[3]);
				}
				ctpn.remove(ctstop);
				tableframe.repaint();
				tableframe.revalidate();
				resultwin.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/win.jpg")));
				resultdraw.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/draw.png")));
				resultlose.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/lose.png")));
				if(playercount<=21) {
					if(dealercount<=21) {
						if(playercount>dealercount) {
							ctpn.add(resultwin);
							money=money+betmoney*2;
						}
						else if(playercount==dealercount) {
							ctpn.add(resultdraw);
							money=money+betmoney;
						}
						else {
							ctpn.add(resultlose);
						}
					}
					else {
						ctpn.add(resultwin);
						money=money+betmoney*2;
					}
				}
				else {
					if(dealercount>21) {
						ctpn.add(resultdraw);
						money=money+betmoney;
					}
					else{
						ctpn.add(resultlose);
					}
				}
				String moneytext = Integer.toString(money);
				ctpn.add(nowmoney1);
				nowmoney2.setText(moneytext);
				ctpn.add(nowmoney2);
				ctpn.add(ctnewgame);
				tableframe.repaint();
				tableframe.revalidate();
			}
		});
		
		ctnewgame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tableframe.dispose();
				i=0;
				dealercount=0;
				playercount=0;
				if(money<=0) {
					nomoneylabel.setText("보유 금액이 0원 이하라 더 이상 게임 진행이 불가능 합니다. |");
				}
				else{
					table();
				}
			}
		});
		tableframe.setVisible(true);
		
	}
}
