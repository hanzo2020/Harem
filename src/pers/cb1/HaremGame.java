package pers.cb1;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/*
 * 选妃项目，后期想改成蔡徐坤
 * 对话框
 * JOptionPane是java选项面板类
 */
//sound = Applet.newAudioClip(new File("sounds/背景音乐.wav").toURL())
public class HaremGame {
	public static void main(String[] args) {
		//JOptionPane.showMessageDialog(null, "hi");//参数1：对话框的父窗体，参数2：提示信息
		//JOptionPane.showMessageDialog(null,"hello","打招呼",JOptionPane.QUESTION_MESSAGE );//参数2：对话框种的提示信息，参数3：对话框的标题信息，参数4:对话框的消息类型
		//JOptionPane.showMessageDialog(null,"hello","打招呼",JOptionPane.QUESTION_MESSAGE, new ImageIcon("image/1.jpg"));
		//JOptionPane.showInputDialog(null,"做出你的选择！","标题", 0,new ImageIcon("image/test1.jpg"),new String[]{"蔡徐坤","离婚少妇","擒牛振威"},null);
		//JOptionPane.showConfirmDialog(null, "是否为蔡徐坤投上一票");
		Scanner input = new Scanner(System.in);
		String Name;//存放输入的姓名
		String addName[] = {"邦哥","吴亦凡","giao哥","冬泳怪鸽"};//可添加的人物
		int addNameCount = addName.length;//可添加人物数量
		String[] Names = {"貂蝉","孙尚香","大乔","小乔","菜虚鲲","","","","",""};//后宫妹子姓名数组,预留五个空间
		String[] levelNames = {"新秀","个人练习生","签约合伙人","C位"};//级别名称
		int[] level = new int[10];//存放判断级别的数字
		int[] loves = new int[10];//好感度
		int nnCount = 5;//已经存在的人物的初始数量，增加人物的话这个数字加1
		int gameDays = 1;//回合数
		//设定默认好感度
		for (int i = 0; i < nnCount; i++) {
			loves[i] = 100;
		}
		JOptionPane.showMessageDialog(null,"导师，录制马上开始，学员们已经等候多时了！", "大型在线真人选秀游戏：青春有你2",0, new ImageIcon("image/test1.jpg"));
		while(gameDays <= 10)//运行十天
		{
			String strMenu = "1、海选新人\n";
			strMenu += "2、舞台表演\n";
			strMenu += "3、强制退赛\n";
			strMenu += "4、私下交友\n";
			strMenu += "请选择活动";
			Object objResult = JOptionPane.showInputDialog(null, strMenu, "第" + gameDays + "天", 0, new ImageIcon("image/test1.jpg"),new String[]{"1","2","3","4"},null);		
			if(objResult == null){
				continue;
			}
			String choice = objResult.toString();
			switch (choice) {
			case "1"://增加功能
				if(nnCount == Names.length)
				{
					System.out.println("陛下，可纳数量已经达到上限，选妃圣旨被皇太后驳回!");
					break;
				}
				objResult = (JOptionPane.showInputDialog(null, "请选择新进选手", "海选", 0, new ImageIcon("image/1.jpg"), addName, null));
				//增加姓名数组，等级数组，好感度数组；
				if(objResult == null){
					//用户点击了取消
					continue;
				}
				JOptionPane.showMessageDialog(null,"俺来也", "俺老邦来也",0,new ImageIcon("image/1.jpg"));
				Names[nnCount] = objResult.toString();
				loves[nnCount] = 100;
				//其他人物好感度下降10
				for (int i = 0; i < loves.length; i++) {
					loves[i] -= 10;
				}
				nnCount++;
				break;
			case "2"://翻牌儿，查找并修改
				//System.out.println("今晚想翻谁的牌？");
				//String name = input.next();
				objResult = JOptionPane.showInputDialog(null, "请选择", "才艺表演", 0, new ImageIcon("image/sy.jpg"), Names, null);
				if(objResult == null){
					//点了取消
					continue;
				}
				String name = objResult.toString();
				int searchIndex = -1;
				for (int i = 0; i < nnCount; i++) {
					if(name.compareTo(Names[i]) == 0){
						//姓名相等
						searchIndex = i;
						break;
					}
				}
				/*if(searchIndex < 0){
					System.out.println("陛下，并未找到此人");//现在不会找不到
					break;
				}*/
				loves[searchIndex] += 30;
				if(level[searchIndex] + 1 != levelNames.length){
					level[searchIndex] ++;
					System.out.println(Names[searchIndex] + "等级提升");
				}
				for (int i = 0; i < nnCount; i++) {
					loves[i] -= 10;
				}
				if (name == "菜虚鲲"){
					File soundFile = new File("sounds/12.wav");
					try {
						AudioClip sound = Applet.newAudioClip(soundFile.toURL());
						sound.play();
						//sound.stop();
						System.out.println("播放成功");
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				JOptionPane.showMessageDialog(null, Names[searchIndex] + "才艺展示成功，积分+10，其他人物积分-10!","才艺展示",0,new ImageIcon("image/test1.jpg"));
				break;
			case "3":
			case "4":
			default:
				System.out.println("请输入正确选项");
				continue;
			}
			//每日结算
			
			String value = "青春有你积分榜！\n";
			for (int i = 0; i < nnCount; i++) {
				value += String.format("%s   %s   %d\n",Names[i],levelNames[level[i]], loves[i]);
				
			}
			
					
			JOptionPane.showMessageDialog(null, value, "每日结算", 0, new ImageIcon("image/test1.jpg"));
			gameDays++;
		
		}
		
		
		
		
		
		
		
	}
}
