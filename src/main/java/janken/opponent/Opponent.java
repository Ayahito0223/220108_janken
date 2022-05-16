package janken.opponent;

import java.util.Random;

import janken.Main;

abstract public class Opponent {

	protected String name;
	protected int all = 1;
	protected int gu;
	protected int pa;
	protected int cho;
	protected int selectHand = -1;
	protected boolean success = false;

	protected int battle(int a, int b) {
		return (a - b + 3) % 3;
	}

	public int battle(int yourHand) {
		Random random = new Random();
		double r = random.nextDouble();

		if(Main.DEBUG){
			System.out.println(this.name + "randomの数");
			System.out.println(r);
			System.out.println();
		}

		double guP = (double) gu / all;
		double choP = (double) cho / all;
		double paP = (double) pa / all;

		int opponentHand = -1;

		if (r <= guP) {
			opponentHand = Main.GU;
		} else if(r <= guP + choP){
			opponentHand = Main.CHO;
		} else if(r <= 1){
			opponentHand = Main.PA;
		} else {
			return -1;
		}
		this.selectHand = opponentHand;
		return battle(yourHand, opponentHand);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGu() {
		return String.format("%.2f", (double) gu / all * 100) + "%";
	}

	public String getPa() {
		return String.format("%.2f", (double) pa / all * 100) + "%";
	}

	public String getCho() {
		return String.format("%.2f", (double) cho / all * 100) + "%";
	}

	public boolean getSuccess(){
		return this.success;
	}

	public int getSelectHand(){
		return this.selectHand;
	}

	public String toString() {
		return "総ジャンケン数: " + all + "\n"
				+ "グー数: " + gu + " (" + String.format("%.2f", (double) gu / all * 100) + "%)" + "\n"
				+ "チョキ数: " + cho + " (" + String.format("%.2f", (double) cho / all * 100) + "%)" + "\n"
				+ "パー数: " + pa + " (" + String.format("%.2f", (double) pa / all * 100) + "%)";
	}
}
