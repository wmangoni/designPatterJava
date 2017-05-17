package playerClasses;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

import armorsClasses.Armor;
import weaponsClasses.Weapon;

public class Player {
	protected String nome = "Player 1";
	protected int level;
	protected int hp;
	protected int ca;
	protected int bba;
	protected int _str;
	protected int _dex;
	protected int _con;
	protected int _int;
	protected int _wis;
	protected int _cha;
	protected int protectFactor = 0;
	protected Weapon weapon;
	protected Armor armor;
	
	public Player() {
		//nada ainda
	}
	
	public Map<String, Integer> causeDamage() {
		
		Map<String, Integer> damage = new HashMap<String, Integer>();
		
		damage.put("dice", this.weapon.damage());
		damage.put("bonus", this.getBonus(this._str));
		damage.put("total", damage.get("dice") + damage.get("bonus"));
		return damage;
	}
	public Map<String, Integer> shortAttack() {
		
		Map<String, Integer> attack = new HashMap<String, Integer>();
		Random randomGenerator = new Random();
		
		attack.put("dice", randomGenerator.nextInt(20) + 1);
		attack.put("bba", this.bba);
		attack.put("bonus", this.getBonus(this._str));
		attack.put("damage", attack.get("dice") + attack.get("bba") + attack.get("bonus"));
		return attack;
	}
	public Map<String, Integer> longAttack() {
		
		Map<String, Integer> attack = new HashMap<String, Integer>();
		Random randomGenerator = new Random();
		
		attack.put("dice", randomGenerator.nextInt(20) + 1);
		attack.put("bba", this.bba);
		attack.put("bonus", this.getBonus(this._dex));
		attack.put("damage", attack.get("dice") + attack.get("bba") + attack.get("bonus"));
		return attack;
	}
	public void takesDamage(int dano) {
		this.hp -= dano - this.protectFactor;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	public void setArmor(Armor armor) {
		this.armor = armor;
	}
	public void recalculateParams(int factorCalculateAtr) {
		this.hp = 10 + this.getBonus(this._con) * this.level;
		this.ca = 10 + this.getBonus(this._dex);
	}
	public int getBonus(int atr) {
		return (atr % 2 == 0) ? (atr - 10) / 2 : (atr - 11) / 2;
	}
	public int factorLevel(int level) {
		return (int) Math.floor( level / 4 );
	}
	public String displayEstatics() throws IOException {
		
//		HttpServletResponse response = null;
//		
//		@SuppressWarnings("null")
//		PrintWriter out = response.getWriter();
		
		Map<String, Integer> atk = this.shortAttack();
		Map<String, Integer> dmg = this.causeDamage();
		
		String html = "";
		html +="<div class='statiscs'>";
		html += "<span><strong>Classe</strong> : " + this.nome + "</span><br>";
		html += "<span><strong>Level</strong> : " + this.level + "</span><br>";
		html += "<span><strong>Força</strong> : " + this._str + " (" + this.getBonus(this._str) + ")</span><br>";
		html += "<span><strong>Destreza</strong> : " + this._dex + " (" + this.getBonus(this._dex) + ") </span><br>";
		html += "<span><strong>Constituição</strong> : " + this._con + " (" + this.getBonus(this._con) + ") </span><br>";
		html += "<span><strong>Inteligência</strong> : " + this._int + " (" + this.getBonus(this._int) + ") </span><br>";
		html += "<span><strong>Sabedoria</strong> : " + this._wis + " (" + this.getBonus(this._wis) + ") </span><br>";
		html += "<span><strong>Carisma</strong> : " + this._cha + " (" + this.getBonus(this._cha) + ") </span><br>";
		html += "<span><strong>Arma</strong> : " + this.weapon.getName() + "</span><br>";
		html += "<span><strong>Dado Base</strong> : " + this.weapon.getDice() + "</span><br>";
		html += "<span><strong>Valor Ataque</strong> : " + atk.get("damage") + " ( dado ) " + atk.get("dice") + " + bba " + atk.get("bba") + " + bonus " + atk.get("bonus") + " )</span><br>";
		html += "<span><strong>Dano com a Arma</strong> : " + dmg.get("total") + " (dado " + dmg.get("dice") + " + bonus " + dmg.get("bonus") + ") </span><br>------<br>";
		html += "</div>";
		
		return html;
	}
}
