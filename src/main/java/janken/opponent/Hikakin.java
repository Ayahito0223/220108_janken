package janken.opponent;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import janken.Main;

public class Hikakin extends Opponent {

	public Hikakin() {
		try {
			this.name = "ヒカキン";
			Document doc = Jsoup.connect("https://hikakinjunken.tk/").get();
			Elements cells = doc.select(".all_junken_table_cell");

			Element allElement = cells.first();
			all = Integer.parseInt(allElement.child(0).text());

			Element eachElement = cells.get(1);
			gu = Integer.parseInt(eachElement.child(0).text());
			pa = Integer.parseInt(eachElement.child(1).text());
			cho = Integer.parseInt(eachElement.child(2).text());

			this.success = true;
		} catch (Exception e) {
			all = 1;
			gu = 0;
			pa = 0;
			cho = 0;
			this.success = false;
			System.out.println("ヒカキンさんのジャンケン情報取得時に何かしらのエラーが起きました。");
			if (Main.DEBUG) {
				e.printStackTrace();
			}
		}
	}
}
