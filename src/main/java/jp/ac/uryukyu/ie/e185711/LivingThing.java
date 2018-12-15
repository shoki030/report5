package jp.ac.uryukyu.ie.e185711;

/**
 *キャラの生存判定クラス
 * String name; //敵の名前
 * int hitPoint; //敵のHP
 * int attack; //敵の攻撃力
 * boolean dead; //敵の生死状態。true=死亡。
 *Created by shoki on 2018/11
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    public LivingThing(String name, int hitPoint, int attack) {
        this.name = name;
        this.hitPoint = hitPoint;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, hitPoint, attack);
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead){
        this.dead = dead;
    }

    public String getName() {
        return name;
    }

    public int getHitPoint(){
        return hitPoint;
    }

    public void setHitPoint(int damage){
        this.hitPoint -= damage;
    }

    public int getAttack(){
        return attack;
    }

    /**
     * 相手が生存している間は攻撃し続けるメソッド。
     * deadで生死判定をする。
     * @param damage 受けたダメージ。
     */
    public void attack(LivingThing opponent) {
        if (dead == false) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        } else if (dead == true) {
            System.out.printf("%sは死んでいるよ。\n", name);
        }
    }
    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint < 0) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }

    }
}

