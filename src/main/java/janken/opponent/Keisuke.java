package janken.opponent;

import java.util.Random;

import janken.Main;

public class Keisuke extends Opponent{
	public Keisuke(){
		this.name = "本田圭佑";

		all = 1;
		gu = 0;
		cho = 0;
		pa = 0;
		this.success = true;
	}

	public int battle(int yourHand){
		Random random = new Random();
		double r = random.nextDouble();

		if(Main.DEBUG){
			System.out.println(this.name + "randomの数");
			System.out.println(r);
			System.out.println();
		}

		if(r <= 0.998){
			return Main.LOSE;
		} else {
			return Main.VICTORY;
		}
	}

	public String toString(){
		return this.name + "の勝率：99.8%";
	}
}
