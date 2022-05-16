package janken;

import java.awt.Font;
import java.io.File;

import janken.cotohaAPI.CotohaAPI;
import janken.opponent.Hikakin;
import janken.opponent.Keisuke;
import janken.opponent.Sazae;
import janken.visualComponents.MainFrame;
import janken.youtubeDataAPIv3.YoutubeDataAPI;

/**
 * @内容 1. ユーザーの文章から感情を分析
 * cotohaAPIを用いる 一日1000コールまで。
 *
 *
 * 2. ユーザーの感情から最も出す確率の高い手を選択
 * （参考）https://japan-rps.jimdofree.com/%E5%8B%9D%E5%88%A9%E3%81%AE%E6%B3%95%E5%89%87/
 * 冷静である→チョキを出しやすい 冷静でない→グーをだしやすい。
 *
 * 冷静であるとは？ ポジティブすぎでなく、ネガティブすぎでないという事 →つまり、ポジティブまたはネガティブ過ぎたらグーを出しやすい
 * そうで無ければチョキを出しやすい パーはその真ん中
 *
 * 3. サザエさんとヒカキンさんの今までのデータを取得
 * サザエさん	→	http://park11.wakwak.com/~hkn/
 * ヒカキンさん	→	https://hikakinjunken.tk/introduction これらのサイトから情報を取得
 *
 * 4. サザエさんとヒカキンさんにジャンケンで勝てるかどうか判定
 *
 * 5. それぞれの人のおすすめ動画を表示
 * 勝利したら、感情分析の結果に応じた対戦相手のおすすめ動画を表示
 * youtubeDataAPIv3を用いる。
 *
 * @必要ライブラリ
 * 〇Gsonの導入
 * jsonを使いやすくするため。
 *
 * 	<dependency>
 * 		<groupId>com.google.code.gson</groupId>
 * 		<artifactId>gson</artifactId>
 * 		<version>2.8.9</version>
 * 	</dependency>
 *
 * 〇Jsoupの導入
 * HTMLのパースをやりやすくするため。
 *
 * 	<dependency>
 * 		<!-- jsoup HTML parser library @ https://jsoup.org/ -->
 * 		<groupId>org.jsoup</groupId>
 * 		<artifactId>jsoup</artifactId>
 * 		<version>1.14.3</version>
 * 	</dependency>
 */
public class Main {

	public static final Font PIXEL_MPLUS_32;
	public static final Font PIXEL_MPLUS_24;
	public static final Font PIXEL_MPLUS_16;
	public static final Font PIXEL_MPLUS_12;

	public static final int GU = 0;
	public static final int CHO = 1;
	public static final int PA = 2;
	public static final int DRAW = 0;
	public static final int LOSE = 1;
	public static final int VICTORY = 2;

	public static boolean DEBUG = false;
	public static boolean DEFINITELY_WIN = false;

	public static MainFrame mainFrame;

	private static CotohaAPI cotoha;
	private static YoutubeDataAPI youtube;
	private static Hikakin hikakin;
	private static Sazae sazae;
	private static Keisuke keisuke;

	static {
		PIXEL_MPLUS_32 = makeFont("./fonts/PixelMplus12-Regular.ttf", 32f);
		PIXEL_MPLUS_24 = makeFont("./fonts/PixelMplus12-Regular.ttf", 24f);
		PIXEL_MPLUS_16 = makeFont("./fonts/PixelMplus12-Regular.ttf", 16f);
		PIXEL_MPLUS_12 = makeFont("./fonts/PixelMplus12-Regular.ttf", 12f);
	}

	public static void main(String[] args) {
		cotoha = new CotohaAPI("", "");
		youtube = new YoutubeDataAPI("");
		new Thread(new Runnable() {
			public void run() {
				keisuke = new Keisuke();
				if(DEBUG) {
					System.out.println("本田圭佑さんの情報---------");
					System.out.println(keisuke);
					System.out.println();
				}
				sazae = new Sazae();
				if(DEBUG) {
					System.out.println("サザエさんの情報---------");
					System.out.println(sazae);
					System.out.println();
				}
				hikakin = new Hikakin();
				if(DEBUG) {
					System.out.println("ヒカキンさんの情報---------");
					System.out.println(hikakin);
					System.out.println();
				}
			}
		}).start();

		mainFrame = new MainFrame("感情的なじゃんけんゲーム");
	}

	private static Font makeFont(String filePath, float size) {
		Font font = null;
		File filename = new File(filePath);
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, filename).deriveFont(size);
		} catch (Exception ex) {
			if(DEBUG) {
				ex.printStackTrace();
			}
			System.out.println("Fontの読み込みに失敗したので、終了します。");
			System.exit(0);
		}
		return font;
	}

	public static CotohaAPI getCotoha() {
		return cotoha;
	}

	public static YoutubeDataAPI getYoutube() {
		return youtube;
	}

	public static Hikakin getHikakin() {
		return hikakin;
	}

	public static Sazae getSazae() {
		return sazae;
	}

	public static Keisuke getKeisuke() {
		return keisuke;
	}
}
