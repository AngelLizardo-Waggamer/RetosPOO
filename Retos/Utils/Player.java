package Retos.Utils;

public class Player {
    // nameTag: nombre hp: Health Points (vida)

    private String nameTag;
    private int hp;
    private int damageDealt;

    // Empty Constructor
    public Player(){}

    // Constructor without damageDealt
    public Player(String nameTag, int hp){
        this.nameTag = nameTag;
        this.hp = hp;
    }

    // Constructor for manual insertion of parameters
    public Player(String nameTag, int hp, int damageDealt){
        this.nameTag = nameTag;
        this.hp = hp;
        this.damageDealt = damageDealt;
    }

    // Constructor for a cloning of other player
    public Player(Player player){
        this.nameTag = player.getnameTag();
        this.hp = player.getHP();
        this.damageDealt = player.getDMGDLT();
    }

    // Getters
    public String getnameTag(){
        return this.nameTag;
    }    
    public int getHP(){
        return this.hp;
    }
    public int getDMGDLT(){
        return this.damageDealt;
    }

    // Setters
    public void setnameTag(String nameTag){
        this.nameTag = nameTag;
    }
    public void setHP(int hp){
        this.hp = hp;
    }
    public void setDMGDLT(int damageDealt){
        this.damageDealt = damageDealt;
    }
}
