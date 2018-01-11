package com.example.a140438.todo3;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class OpenHelper extends SQLiteOpenHelper{
    public OpenHelper(Context context){
        //version1：DB・テーブルの作成
        //super(context, "TODO_DB", null, 1);

        //以降、データベースに変更を加える際はversionを更新していく
        //使用していないversionのsuper～の記述はコメントアウトすること

        //version2：userテーブルの修正
        //super(context, "TODO_DB", null, 2);

        //version3：pastテーブルの追加
        //super(context, "TODO_DB", null, 3);

        //version4 : picture テーブルの変更
        //super(context, "TODO_DB", null, 4);

        //version5 : 台詞パックの追加
        //super(context, "TODO_DB", null, 5);

        super(context, "TODO_DB", null, 6);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        //version1(初回起動時のみ動作する)の内容

        //外部キーを有効にする
        db.execSQL("PRAGMA foreign_keys = true;");

        //packageテーブルの作成
        //wordsテーブルより先に作成すること
        db.execSQL("CREATE TABLE package (" +
                "package_id TEXT PRIMARY KEY," +
                "package_name TEXT," +
                "unlock INTEGER )");

        //wordsテーブルの作成
        //packageテーブルより後に作成すること
        db.execSQL("CREATE TABLE words(" +
                "words_id TEXT," +
                "package_id TEXT," +
                "words_text TEXT," +
                "switch INTEGER," +
                "PRIMARY KEY (words_id, package_id), " +
                "FOREIGN KEY(package_id) REFERENCES package(package_id) )");

        //goalテーブルの作成
        db.execSQL("CREATE TABLE goal(" +
                " goal_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " goal_name TEXT," +
                " memo TEXT," +
                " progress INTEGER," +
                " year INTEGER," +
                " month INTEGER," +
                " day INTEGER," +
                " hour INTEGER," +
                " minutes INTEGER," +
                " category INTEGER)");

        //userテーブルの作成
        db.execSQL("CREATE TABLE user(" +
                " user_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " user_name TEXT," +
                " user_level INTEGER," +
                " exp INTEGER)");

        //pictureテーブルの作成
        db.execSQL("CREATE TABLE picture(" +
                " picture_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " picture BLOB )");

        //ツンデレ幼馴染パックINSERT
        db.execSQL("INSERT INTO package(package_id, package_name, unlock)" +
                "VALUES('Tsundere', 'ツンデレ幼馴染', 1)");

        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('tsun_CHAR_A','Tsundere','ちょっと！どこ触ってんのよ！',1)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('tsun_CHAR_B','Tsundere','私に何か用かしら。',2)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('tsun_CHAR_C','Tsundere','っもう、これ以上触ったら本当に怒るわよ！',3)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('PER0','Tsundere','目標達成目指して頑張りましょう。',4)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('PER10','Tsundere','進捗率10％よ、まだまだこれからね。',5)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('PER20','Tsundere','進捗率20％、この調子ならまだまだ余裕ね！',6)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('PER30','Tsundere','進捗率30％、この程度なら楽勝かしら、まあ、その調子よ。',7)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('PER40','Tsundere','進捗率40％、気を引き締めていくわよ。',8)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('PER50','Tsundere','進捗率50％、とりあえず半分まで来たわね、お疲れ様。',9)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('PER60','Tsundere','進捗率60％、集中していくわよ。',10)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('PER70','Tsundere','進捗率70％、nameがここまでやるなんて見直したわ、でも油断は禁物よ。',11)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('PER80','Tsundere','進捗率80％、ここまで来たんだから今更やめたりなんかしないわよね。',12)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('PER90','Tsundere','進捗率90％、あと少しで目標達成よ！',13)");

        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('tsun_PER0_GOAL', 'Tsundere', '目標達成目指して頑張りましょう。', 14)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('tsun_PER10_GOAL', 'Tsundere', 'ほら、さっさと始めるわよ！', 15)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('tsun_PER20_GOAL', 'Tsundere', 'このペースで大丈夫？ …大丈夫ならいいけど。', 16)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('tsun_PER30_GOAL', 'Tsundere', 'まあ、たまには休息も必要よね。', 17)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('tsun_PER40_GOAL', 'Tsundere', '休息は必要だって言ったけど、まさかサボってるわけじゃないでしょうね…？', 18)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('tsun_PER50_GOAL', 'Tsundere', 'nameにしてはよくやってるわね。そっ、その頑張りは認めてあげてもいいわよ？', 19)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('tsun_PER60_GOAL', 'Tsundere', 'いい調子よname。…何？ この前はもっと褒めてくれた？ そっそれは、その…たまたまよ！', 20)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('tsun_PER70_GOAL', 'Tsundere', '頑張りすぎはよくないわ。 …別にnameを心配してるわけじゃないわよ。', 21)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('tsun_PER80_GOAL', 'Tsundere', 'そろそろ終わりが見えてきたわね、体調に気を付けるのよ？', 22)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('tsun_PER90_GOAL', 'Tsundere', 'もう少しよname、さっさと終わらせましょ！', 23)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('tsun_SUCC', 'Tsundere', 'やったわね、目標達成よ！ 次もこの調子で頑張りましょう！', 24)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('tsun_FAIL', 'Tsundere', '…今回は、ほんのちょっと調子が悪かっただけよ！', 25)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('tsun_NORM_A', 'Tsundere', 'べ、別にnameを待ってたってわけじゃないわよ？', 26)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('tsun_NORM_B', 'Tsundere', 'さあ、今日も頑張っていきましょ！', 27)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('tsun_NORM_C', 'Tsundere', 'えっ！？ …別に、nameがいなかったからって退屈なんてしてないわよ！', 28)");

        //仮ユーザー入力(ユーザー登録機能作成時に消去すること)
        db.execSQL("INSERT INTO user(user_name, user_level, exp) VALUES('テスター', 1, 0)");

        //goalテーブル
        db.execSQL("INSERT INTO goal(goal_name, memo, progress, year, month, day, hour, minutes, category)" +
                "VALUES('プレゼンの資料を作る', '', 0,  2017, 12, 11, 17, 30, 0)");
        db.execSQL("INSERT INTO goal(goal_name, memo, progress, year, month, day, hour, minutes, category)" +
                "VALUES('課題Ex02を終わらせる', '川名先生に提出', 0,  2017, 12, 11, 17, 30, 0)");

        //ver2
        db.execSQL("DROP TABLE user;");
        db.execSQL("CREATE TABLE user(" +
                " user_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " user_name TEXT," +
                " user_level INTEGER," +
                " exp INTEGER," +
                " use_package TEXT)");
        db.execSQL("INSERT INTO user(user_name, user_level, exp, use_package) VALUES('テスター', 1, 0, 'ツンデレ幼馴染')");

        //ver3
        db.execSQL("CREATE TABLE past(" +
                " past_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " past_name TEXT," +
                " year INTEGER," +
                " month INTEGER," +
                " day INTEGER," +
                " TorF INTEGER)");

        //ver4
        db.execSQL("DROP TABLE picture");
        db.execSQL("CREATE TABLE picture(" +
                " picture_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " picture_url TEXT)");

        //ver5
        db.execSQL("INSERT INTO package(package_id, package_name, unlock)" +
                "VALUES('Maid', 'メイド', 1)");

        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('maid_CHAR_A','Maid','name、何かご用でしょうか？',1)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('maid_CHAR_B','Maid','name、私に何なりとお申し付けくださいませ。',2)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('maid_CHAR_C','Maid','name、お戯れも程々になさいませ。',3)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('PER0','Maid','目標達成までnameをサポート致します。これから頑張りましょう。',4)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('PER10','Maid','進捗率が10％になりました。name、まだこれからですね。',5)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('PER20','Maid','進捗率が20％になりました。まだまだ余裕そうですね。',6)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('PER30','Maid','進捗率が30％になりました。name、その調子いきましょう。',7)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('PER40','Maid','進捗率が40％になりました。気を引き締めていきましょう。',8)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('PER50','Maid','進捗率が50％になりました。目標達成まであと半分です。',9)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('PER60','Maid','進捗率が60％になりました。集中していきましょう。',10)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('PER70','Maid','進捗率が70％になりました。name、無理は禁物です。',11)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('PER80','Maid','進捗率が80％になりました。体調に気を付けてください。',12)");
        db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                "VALUES('PER90','Maid','進捗率が90％になりました。目標達成までもう少しです。',13)");

        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('maid_PER0_GOAL', 'Maid', 'name、目標達成までこれから頑張りましょう。', 14)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('maid_PER10_GOAL', 'Maid', '進捗率は10％です。name、計画は立てていますか？早速取り掛かりましょう。', 15)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('maid_PER20_GOAL', 'Maid', '進捗率は20％です。目標達成に向けて少しずつでも努力することが大切です。', 16)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('maid_PER30_GOAL', 'Maid', '進捗率は30％です。name、順調に進んでいるでしょうか？', 17)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('maid_PER40_GOAL', 'Maid', '進捗率は40％です。計画通りに進んでいるのでしたら、すこし休憩しましょう。', 18)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('maid_PER50_GOAL', 'Maid', '進捗率は50％です。ようやく半分ですね、お疲れ様ですname。', 19)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('maid_PER60_GOAL', 'Maid', '進捗率は60％です。体調を崩さないよう、気を付けて頑張りましょう。', 20)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('maid_PER70_GOAL', 'Maid', '進捗率は70％です。name、最近疲れがたまってはいませんか？時には休息も必要ですよ。', 21)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('maid_PER80_GOAL', 'Maid', '進捗率は80％です。もう少しで目標達成ですね。 name、焦らずにいきましょう。', 22)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('maid_PER90_GOAL', 'Maid', '進捗率は90％です。目標達成まであと少しです。 name、早く終わらせてしまいましょう。', 23)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('maid_SUCC', 'Maid', '目標達成おめでとうございます。nameなら出来ると信じておりました。', 24)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('maid_FAIL', 'Maid', '時にはこのような事もあります。 次は頑張りましょう。', 25)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('maid_NORM_A', 'Maid', 'お待ちしておりましたname。', 26)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('maid_NORM_B', 'Maid', 'お帰りなさいませname。', 27)");
        db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                "VALUES('maid_NORM_C', 'Maid', 'name、今日も目標に向けて頑張りましょう。', 28)");

        //ver6
        db.execSQL("INSERT INTO picture(picture_url)" +
                "VALUES('aaa')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //version2以降での変更の詳しい内容をここに記述していく

        //version2でのアップグレード内容
        //version1→version2の時のみ起動する

		if(oldVersion <= 1){
			//詳しい変更内容
            db.execSQL("DROP TABLE user;");
            db.execSQL("CREATE TABLE user(" +
                    " user_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " user_name TEXT," +
                    " user_level INTEGER," +
                    " exp INTEGER," +
                    " use_package TEXT)");
            db.execSQL("INSERT INTO user(user_name, user_level, exp, use_package) VALUES('テスター', 1, 0, 'ツンデレ幼馴染')");
		}


        //version3でのアップグレード内容
        //version2→version3の時のみ起動する

		if(oldVersion <= 2){
			//詳しい変更内容
            db.execSQL("CREATE TABLE past(" +
                    " past_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " past_name TEXT," +
                    " year INTEGER," +
                    " month INTEGER," +
                    " day INTEGER," +
                    " TorF INTEGER)");
		}

		if(oldVersion <= 3){
            db.execSQL("DROP TABLE picture");
            db.execSQL("CREATE TABLE picture(" +
                    " picture_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " picture_url TEXT)");
        }

        if(oldVersion <= 4) {
            db.execSQL("INSERT INTO package(package_id, package_name, unlock)" +
                    "VALUES('Maid', 'メイド', 1)");

            db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                    "VALUES('maid_CHAR_A','Maid','name、何かご用でしょうか？',1)");
            db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                    "VALUES('maid_CHAR_B','Maid','name、私に何なりとお申し付けくださいませ。',2)");
            db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                    "VALUES('maid_CHAR_C','Maid','name、お戯れも程々になさいませ。',3)");
            db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                    "VALUES('PER0','Maid','目標達成までnameをサポート致します。これから頑張りましょう。',4)");
            db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                    "VALUES('PER10','Maid','進捗率が10％になりました。name、まだこれからですね。',5)");
            db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                    "VALUES('PER20','Maid','進捗率が20％になりました。まだまだ余裕そうですね。',6)");
            db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                    "VALUES('PER30','Maid','進捗率が30％になりました。name、その調子いきましょう。',7)");
            db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                    "VALUES('PER40','Maid','進捗率が40％になりました。気を引き締めていきましょう。',8)");
            db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                    "VALUES('PER50','Maid','進捗率が50％になりました。目標達成まであと半分です。',9)");
            db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                    "VALUES('PER60','Maid','進捗率が60％になりました。集中していきましょう。',10)");
            db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                    "VALUES('PER70','Maid','進捗率が70％になりました。name、無理は禁物です。',11)");
            db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                    "VALUES('PER80','Maid','進捗率が80％になりました。体調に気を付けてください。',12)");
            db.execSQL("INSERT INTO words(words_id,package_id,words_text,switch) " +
                    "VALUES('PER90','Maid','進捗率が90％になりました。目標達成までもう少しです。',13)");

            db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                    "VALUES('maid_PER0_GOAL', 'Maid', 'name、目標達成までこれから頑張りましょう。', 14)");
            db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                    "VALUES('maid_PER10_GOAL', 'Maid', '進捗率は10％です。name、計画は立てていますか？早速取り掛かりましょう。', 15)");
            db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                    "VALUES('maid_PER20_GOAL', 'Maid', '進捗率は20％です。目標達成に向けて少しずつでも努力することが大切です。', 16)");
            db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                    "VALUES('maid_PER30_GOAL', 'Maid', '進捗率は30％です。name、順調に進んでいるでしょうか？', 17)");
            db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                    "VALUES('maid_PER40_GOAL', 'Maid', '進捗率は40％です。計画通りに進んでいるのでしたら、すこし休憩しましょう。', 18)");
            db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                    "VALUES('maid_PER50_GOAL', 'Maid', '進捗率は50％です。ようやく半分ですね、お疲れ様ですname。', 19)");
            db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                    "VALUES('maid_PER60_GOAL', 'Maid', '進捗率は60％です。体調を崩さないよう、気を付けて頑張りましょう。', 20)");
            db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                    "VALUES('maid_PER70_GOAL', 'Maid', '進捗率は70％です。name、最近疲れがたまってはいませんか？時には休息も必要ですよ。', 21)");
            db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                            "VALUES('maid_PER80_GOAL', 'Maid', '進捗率は80％です。もう少しで目標達成ですね。 name、焦らずにいきましょう。', 22)");
            db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                            "VALUES('maid_PER90_GOAL', 'Maid', '進捗率は90％です。目標達成まであと少しです。 name、早く終わらせてしまいましょう。', 23)");
            db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                    "VALUES('maid_SUCC', 'Maid', '目標達成おめでとうございます。nameなら出来ると信じておりました。', 24)");
            db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                            "VALUES('maid_FAIL', 'Maid', '時にはこのような事もあります。 次は頑張りましょう。', 25)");
            db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                    "VALUES('maid_NORM_A', 'Maid', 'お待ちしておりましたname。', 26)");
            db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                    "VALUES('maid_NORM_B', 'Maid', 'お帰りなさいませname。', 27)");
            db.execSQL("INSERT INTO words(words_id, package_id, words_text, switch)" +
                    "VALUES('maid_NORM_C', 'Maid', 'name、今日も目標に向けて頑張りましょう。', 28)");
        }

        if(oldVersion <= 5){
            db.execSQL("INSERT INTO picture(picture_url)" +
                    "VALUES('aaa')");
        }
    }
}