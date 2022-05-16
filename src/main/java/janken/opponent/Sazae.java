package janken.opponent;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import janken.Main;

public class Sazae extends Opponent {

	public Sazae() {
		try {
			this.name = "サザエさん";
			Document doc = Jsoup.connect("http://park11.wakwak.com/~hkn/bunseki0.htm").get();
			Element cells = doc.select("tbody").first();
			Element tr = cells.child(cells.childrenSize() - 1);
			String gu_str = tr.child(1).text();
			String pa_str = tr.child(2).text();
			String cho_str = tr.child(3).text();
			all = Integer.parseInt(tr.child(4).text());

			gu = Integer.parseInt(gu_str.split("[（(]", 2)[0]);
			cho = Integer.parseInt(pa_str.split("[（(]", 2)[0]);
			pa = Integer.parseInt(cho_str.split("[（(]", 2)[0]);

			this.success = true;
		} catch (Exception e) {
			all = 1;
			gu = 0;
			pa = 0;
			cho = 0;
			this.success = false;
			System.out.println("サザエさんのジャンケン情報取得時に何かしらのエラーが起きました。");
			if (Main.DEBUG) {
				e.printStackTrace();
			}
		}

	}
}
