package pers.cb1;
import java.applet.Applet;
import java.util.Scanner;
/*
 * 选妃项目，后期想改成蔡徐坤
 */
//sound = Applet.newAudioClip(new File("sounds/背景音乐.wav").toURL())
public class HaremGame {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String Name;//存放输入的姓名
		String[] Names = {"貂蝉","孙尚香","大乔","小乔","菜虚鲲","","","","",""};//后宫妹子姓名数组,预留五个空间
		String[] levelNames = {"备胎","小老婆","侧室","正妻"};//级别名称
		int[] level = new int[10];//存放判断级别的数字
		int[] loves = new int[10];//好感度
		int nnCount = 5;//已经存在的人物的初始数量，增加人物的话这个数字加1
		int gameDays = 1;//回合数
		//设定默认好感度
		for (int i = 0; i < nnCount; i++) {
			loves[i] = 100;
		}
		while(gameDays <= 10)//运行十天
		{
			System.out.println("第" + gameDays + "天");
			System.out.println("1、下旨选妃\t增加");
			System.out.println("2、翻牌宠幸\t爽爽");
			System.out.println("3、打入冷宫\t删除");
			System.out.println("4、召见查看\t查找");
			System.out.println("陛下请输入数字选择行动");
			int choice = input.nextInt();
			switch (choice) {
			case 1://增加功能
				if(nnCount == Names.length)
				{
					System.out.println("陛下，可纳数量已经达到上限，选妃圣旨被皇太后驳回!");
					break;
				}
				System.out.println("请给新妃子取个名字：");
				String newName = input.next();
				//增加姓名数组，等级数组，好感度数组；
				Names[nnCount] = newName;
				loves[nnCount] = 100;
				//其他人物好感度下降10
				for (int i = 0; i < loves.length; i++) {
					loves[i] -= 10;
				}
				nnCount++;
				break;
			case 2://翻牌儿，查找并修改
				System.out.println("今晚想翻谁的牌？");
				String name = input.next();
				int searchIndex = -1;
				for (int i = 0; i < nnCount; i++) {
					if(name.compareTo(Names[i]) == 0){
						//姓名相等
						searchIndex = i;
						break;
					}
				}
				if(searchIndex < 0){
					System.out.println("陛下，并未找到此人");
					break;
				}
				loves[searchIndex] += 30;
				if(level[searchIndex] + 1 != levelNames.length){
					level[searchIndex] ++;
					System.out.println(Names[searchIndex] + "等级提升");
				}
				for (int i = 0; i < nnCount; i++) {
					loves[i] -= 10;
				}
				System.out.println("宠幸" + Names[searchIndex] + "成功，好感度+10，其他人物好感度-10!");
				break;
			case 3:
			case 4:
			default:
				System.out.println("请输入正确选项");
				continue;
			}
			System.out.println("姓名\t级别\t好感度");
			for (int i = 0; i < nnCount; i++) {
				System.out.println(Names[i] + "\t" + levelNames[level[i]] + "\t" + loves[i]);
				
			}
			gameDays++;
		
		}
		
		
		
		
		
		
		
	}
}
