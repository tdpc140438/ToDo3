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
        super(context, "TODO_DB", null, 3);
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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //version2以降での変更の詳しい内容をここに記述していく

        //version2でのアップグレード内容
        //version1→version2の時のみ起動する

		if(oldVersion == 1){
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

		if(oldVersion == 2){
			//詳しい変更内容
            db.execSQL("CREATE TABLE past(" +
                    " past_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " past_name TEXT," +
                    " year INTEGER," +
                    " month INTEGER," +
                    " day INTEGER," +
                    " TorF INTEGER)");
		}

    }
}