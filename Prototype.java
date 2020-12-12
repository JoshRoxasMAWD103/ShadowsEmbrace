import java.util.Scanner;
import java.util.Random;
public class ShadowsEmbrace
{
	//SYSTEM VARIABLES
	Random r = new Random();
	Scanner s = new Scanner(System.in);
	Scanner enterScanner = new Scanner(System.in);
	
	//PLAYER VARIABLES
	String playerName, choice, role, playerWeapon, playerClass, playerSkills;
	int maxPlayerHP, maxPlayerMana, maxPlayerArmor, 
		hpAdd, manaAdd, armorAdd, 
		playerHP, playerMana, playerArmor;
	int playerDamage;
	int currentPlayerDamage;
	
	//OTHER GAME VARIABLES
	int monsterHP;
	int monsterDamage;
	String monster[] = {"Skeleton", "Ghoul", "Wraith", "Zombie", "Vampire",};
        String monsterRandomizer;
	int monsterCounter = 5;
	int abbadonDamage = 40;
	int abbadonHP = 100;
	int monstercounter = 4; //5th one will be a boss
	
	int asmodeusHP;
	int asmodeusDamage;
	
	//ITEMS
	int healLeft = 3;
	int revive; // Used to finish the game
	int key;
		
	public static void main(String[] args) 
	{
		ShadowsEmbrace game;
		game = new ShadowsEmbrace();
		
		game.playerSetUp();
		game.startUp();
		game.firstMonsterWave();
	}
	
	public void playerSetUp()
	{
	    System.out.println("\nWelcome to Shadow's Embrace.");
	    System.out.print("Your adventure begins here. Please enter a name: ");
		playerName = s.nextLine();
		System.out.println("------------------------------------------------"); 
		
		System.out.print("Hello " + playerName + ", let's pick a role!");
		System.out.println("\n\t1. Warrior 	");
		System.out.println("\t2. Mage");
		System.out.println("\t3. Archer");
		System.out.print("Select: ");
		role = s.nextLine();
		System.out.println("\n------------------------------------------------"); 
		
		//ROLES OR CLASSES TO SELECT
		if (role.equals("1"))
		{
			//WARRIOR CHOICE
			playerHP = 10;
			maxPlayerHP = 220;
			hpAdd = 15;
			
			playerMana = 0;
			maxPlayerMana = 80;
			manaAdd = 5;
			
			playerArmor = 5;
			maxPlayerArmor = 145;
			armorAdd = 10;
			
			playerClass = "Warrior";
			playerWeapon = "Long Sword";
			playerSkills = "\n\t[1]Punch \n\t[2]Blade Surge \n\t[3]Hail of Blades";
		}
		
		else if (role.equals("2"))
		{
			//MAGE CHOICE
			playerHP = 10;
			maxPlayerHP = 150;
			hpAdd = 10;
			
			playerMana = 20;
			maxPlayerMana = 220;
			manaAdd = 15;
			
			playerArmor = 5;
			maxPlayerArmor = 75;
			armorAdd = 5;
			
			playerClass = "Mage";
			playerWeapon = "Staff";
			playerSkills = "\n\t[]Fireball \n\t[2]Thunderbolt \n\t[3]Hinokami Kagura";
		}
		
		else if (role.equals("3"))
		{
			//ARCHER CHOICE
			playerHP = 10;
			maxPlayerHP = 150;
			hpAdd = 10;
			
			playerMana = 5;
			maxPlayerMana = 145;
			manaAdd = 10;
			
			playerArmor = 10;
			maxPlayerArmor = 80;
			armorAdd = 5;
			
			playerClass = "Archer";
			playerWeapon = "Bow";
			playerSkills = "\n\t[1]Arrow Shot \n\t[2]Sectral Arrow \n\t[3]Enchanted Arrow";
		}
	}
	
	public void startUp()
	{
		System.out.println("Class: " + playerClass);
		System.out.println("Player HP: " + playerHP);
		System.out.println("Player Weapon: " + playerWeapon);
		System.out.println("Player Skills: " + playerSkills);
		System.out.println("Health Potions Left: " + healLeft);
			
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println(playerName + " You are a man fighting for Nessa. You must rescue her in order for you to successfully finish this mission!");
		System.out.println("But beware of dangerous underground creatures that you may encounter!");
		System.out.println("You need to defeat 3 boss in order for you to sucessfully retrieve her");
		System.out.println("\tPress Enter to Continue");
		choice = s.nextLine();
		System.out.println("\n------------------------------------------------------------------\n");
	}
	
	
	public void firstMonsterWave()
	{
		while (monsterCounter > 0)
		{
			monsterCounter--;
			System.out.println("\n------------------------------------------------------------------\n");
			monsterRandomizer = monster[r.nextInt(monster.length)];
			System.out.println("You encountered a " + monsterRandomizer + "!");
			
			//GHOUL STATS
			if (monsterRandomizer.equals("Ghoul"))
			{
				int monsterHP = r.nextInt(50);
				if (monsterHP <= 30)
				{
					monsterHP = 30;
				}
			
				int monsterDamage = r.nextInt(30);
				if (monsterDamage <= 20)
				{
					monsterDamage = 20;
				}
			
				System.out.println("\tMonster HP: " + monsterHP + "\n\tMonster Damage: " + monsterDamage);
				monsterFight();
			}
			//SKELETON STATS
			else if (monsterRandomizer.equals("Skeleton"))
			{
				int monsterHP = r.nextInt(55);
				if (monsterHP <= 25)
				{
					monsterHP = 25;
				}
				
				int monsterDamage = r.nextInt(50);
				if (monsterDamage <= 40)
				{
					monsterDamage = 40;
				}
				
				System.out.println("\tMonster HP: " + monsterHP + "\n\tMonster Damage: " + monsterDamage);
				monsterFight();
			}
			//WRAITH STATS
			else if (monsterRandomizer.equals("Wraith"))
			{
				int monsterHP = r.nextInt(50);
				if (monsterHP <= 35)
				{
					monsterHP = 35;
				}
				
				int monsterDamage = r.nextInt(40);
				if (monsterDamage <= 35)
				{
					monsterDamage = 35;
				}
				
				System.out.println("\tMonster HP: " + monsterHP + "\n\tMonster Damage: " + monsterDamage);
				monsterFight();
			}
			//ZOMBIE STATS
			else if (monsterRandomizer.equals("Zombie"))
			{
				int monsterHP = r.nextInt(55);
				if (monsterHP <= 35)
				{
					monsterHP = 35;
				}
				
				int monsterDamage = r.nextInt(35);
				if (monsterDamage <= 25)
				{
					monsterDamage = 25;
				}
				
				System.out.println("\tMonster HP: " + monsterHP + "\n\tMonster Damage: " + monsterDamage);
				monsterFight();
			}
			//VAMPIRE STATS
			else if (monsterRandomizer.equals("Vampire"))
			{
				int monsterHP = r.nextInt(40);
				if (monsterHP <= 10)
				{
					monsterHP = 10;
				}
				
				int monsterDamage = r.nextInt(60);
				if (monsterDamage <= 50)
				{
					monsterDamage = 50;
				}
				
				System.out.println("\tMonster HP: " + monsterHP + "\n\tMonster Damage: " + monsterDamage);
				monsterFight();
			}
		}
	}
	
	
	public void monsterFight()
	{
		System.out.println(">Your HP: " + playerHP);
		
		if (monsterHP > 0)
		{
			System.out.println(">" + monsterRandomizer + "'s HP: " + monsterHP);
		}
		else if (monsterHP <= 0)
		{
			System.out.println(">" + monsterRandomizer + "'s HP: " + 0);
		}
		
		System.out.println("Choose:");
		System.out.println("\n\t[1]: Attack");
		System.out.println("\t[2]: Use an item.");
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.print("Select: ");
		choice = s.nextLine();
		
		if(choice.equals("1"))
		{
			monsterBattleMode();
		}
		
		else if(choice.equals("2"))
		{
			if (healLeft == 0)
			{
				System.out.println("You have used all of your heals!");
				monsterFight();
			}
			heal();
		}
		
		else
		{
			System.out.println("Invalid Command!");
		}
	}
	
	
	//OLD ATTACK PUBLIC VOID
	public void monsterBattleMode()
	{
		currentPlayerDamage = r.nextInt(playerDamage);
		if (currentPlayerDamage <= 25)
		{
			currentPlayerDamage = 25;
		}
		playerHP = playerHP - monsterDamage;
		monsterHP = monsterHP - currentPlayerDamage;
		System.out.println("You attacked the monster and dealt " + currentPlayerDamage + " damage!");
		System.out.println("The monster attacked you for " + monsterDamage);
		
		/*System.out.println("\nMonster HP: " + monsterHP + );
		System.out.println("Your HP: " + playerHP);
		System.out.println("Please enter (1) to continue");
		choice = s.nextInt();
		
		if(monsterCounter<=0 && monsterHP <= 0)
		{
			win(); 
		} 
		
		else if (monsterHP <= 0)
		{
			System.out.println("You defeated the " + monsterRandomizer + "!");
			fight();
		}
		else if(monsterHP > 0)
		{
			attack();
			
			if(playerHP <= 0)
			{ 
				dead(); 
			} 
			
			else if(playerHP > 0)
			{
				attack();
			}
		}*/
		
	}
	
	/*public void monsterstats()
	{
		//GHOUL STATS
		if (monsterRandomizer.equals("Ghoul"))
		{
			int monsterHP = r.nextInt(50);
			if (monsterHP <= 30)
			{
				monsterHP = 30;
			}
			
			int monsterDamage = r.nextInt(30);
			if (monsterDamage <= 20)
			{
				monsterDamage = 20;
			}
			
			System.out.println("\tMonster HP: " + monsterHP + "\n\tMonster Damage: " + monsterDamage);
			monsterFight();
		}
		//SKELETON STATS
		else if (monsterRandomizer.equals("Skeleton"))
		{
			int monsterHP = r.nextInt(55);
			if (monsterHP <= 25)
			{
				monsterHP = 25;
			}
			
			int monsterDamage = r.nextInt(50);
			if (monsterDamage <= 40)
			{
				monsterDamage = 40;
			}
			
			System.out.println("\tMonster HP: " + monsterHP + "\n\tMonster Damage: " + monsterDamage);
			monsterFight();
		}
		//WRAITH STATS
		else if (monsterRandomizer.equals("Wraith"))
		{
			int monsterHP = r.nextInt(50);
			if (monsterHP <= 35)
			{
				monsterHP = 35;
			}
			
			int monsterDamage = r.nextInt(40);
			if (monsterDamage <= 35)
			{
				monsterDamage = 35;
			}
			
			System.out.println("\tMonster HP: " + monsterHP + "\n\tMonster Damage: " + monsterDamage);
			monsterFight();
		}
		//ZOMBIE STATS
		else if (monsterRandomizer.equals("Zombie"))
		{
			int monsterHP = r.nextInt(55);
			if (monsterHP <= 35)
			{
				monsterHP = 35;
			}
			
			int monsterDamage = r.nextInt(35);
			if (monsterDamage <= 25)
			{
				monsterDamage = 25;
			}
			
			System.out.println("\tMonster HP: " + monsterHP + "\n\tMonster Damage: " + monsterDamage);
			monsterFight();
		}
		//VAMPIRE STATS
		else if (monsterRandomizer.equals("Vampire"))
		{
			int monsterHP = r.nextInt(40);
			if (monsterHP <= 10)
			{
				monsterHP = 10;
			}
			
			int monsterDamage = r.nextInt(60);
			if (monsterDamage <= 50)
			{
				monsterDamage = 50;
			}
			
			System.out.println("\tMonster HP: " + monsterHP + "\n\tMonster Damage: " + monsterDamage);
			monsterFight();
		}
	}*/
		
	public void dead()
	{
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You are dead!!!");
		System.out.println("\n\nGAME OVER");
		System.out.println("\n------------------------------------------------------------------\n");
	}
	
	public void win()
	{
		if(monsterCounter == 0)
		{
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You killed the wave of monster!");
		System.out.println("The " + monsterRandomizer + " dropped a key to the dungeon!");
		System.out.println("You obtained a key!\n\n");
		System.out.println("1: Continue to the dungeon");
		System.out.println("\n------------------------------------------------------------------\n");
		String monsterRandomizer = monster[r.nextInt(monster.length)];
		}
		key = 1;
		
		System.out.print("Select: ");
		
		choice = s.nextLine();
		if(choice.equals("1"))
		{
			firstBossFight();
		}
		else
		{
			win();
		}
		
	}
	
	public void heal()
	{
		if (healLeft > 0)
		{
			if (playerHP == playerHP)
			{
				System.out.println("You are still at full health!");
				monsterFight();
			}
			else if (playerHP >= (playerHP - 50))
			{
				healLeft--;
				playerHP += 50;
				System.out.println("You used heal. You have " + healLeft + " left");
				System.out.println("Current HP is maxed out to " + playerHP);
				monsterFight();
			}
			else if (playerHP < (playerHP - 50))
			{
				healLeft--;
				playerHP += 50;
				System.out.println("You used heal. You have " + healLeft + " left");
				System.out.println("Current HP is" + playerHP);
				monsterFight();
			}
		}
		else 
		{
			System.out.println("You have used all your heal!");
			
		}
		
	}
	
	public void firstBossFight()
	{
			System.out.println("\nYou encountered the first boss Abbadon");
			System.out.println("\n------------------------------------------------------------------\n");
			System.out.println("\t >BOSS FIGHT!");
			System.out.println("\t>Your HP: "+ playerHP);
			System.out.println("\t>Abbadon's HP: " + abbadonHP);
			System.out.println("Choose:");
			System.out.println("[1.] Continue");
			System.out.println("[2.] Heal");
			System.out.println("\n------------------------------------------------------------------\n");
			System.out.print("Select: ");
			choice = s.nextLine();	
	}
	
	
	
		
		
	
	
	
	
	public void secondBossFight()
	{
		
	}
	
	public void finalBossFight()
	{
		
	}
	
	
	
	public void ending()
	{
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("Work");
		System.out.println("in");
		System.out.println("Progress ");
		System.out.println("\n------------------------------------------------------------------\n");
	}
	
}
