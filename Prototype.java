import java.util.Scanner;
import java.util.Random;
public class ShadowsEmbrace 
{
	
	//SYSTEM VARIABLES
	Random r = new Random();
	Scanner s = new Scanner(System.in);
	
	//PLAYER VARIABLES
	int playerHP = 100;
	int maxPlayerHP = r.nextInt(300);
	String playerName;
	int playerDamage = r.nextInt(25);
	int maxPlayerDamage;
	int choice;
	int role;
	String playerWeapon;
	
	//OTHER GAME VARIABLES
	int monsterHP;
	String monster[] = {"Skeleton", "Ghoul", "Wraith", "Zombie","Vampire",};
        String monsterRandomizer = monster[r.nextInt(monster.length)];
	int monsterCounter = 3;
	int abbadonDamage = 40;
	int abbadonHP = 100;
	
	int asmodeusHP = 150;
	
	
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
	}
	
	public void playerSetUp(){
		
	    System.out.println("\t------------------------------------------------"); 
	    System.out.println("\n\tWelcome to Shadow's Embrace.");
	    System.out.print("\tYour adventure begins here. Please enter a name: ");
		playerName = s.nextLine();
		System.out.println("\t------------------------------------------------"); 
		
		System.out.print("\n\tHello " + playerName + ", let's pick a role!");
		System.out.println("\n\t1. Warrior 	");
		System.out.println("\t2. Mage");
		System.out.println("\t3. Archer");
		System.out.print("Select: ");
		
		role = s.nextInt();
		
		System.out.println("\t------------------------------------------------"); 
		
		//ROLES OR CLASSES TO SELECT
		
		if (role == 1)
		{
			maxPlayerHP = 300;
			maxPlayerDamage = 40;
			
			System.out.println("Class: Warrior.");
			playerWeapon = "Long Sword";
			playerHP = playerHP + r.nextInt(maxPlayerHP);
			playerDamage = playerDamage + r.nextInt(maxPlayerDamage);
			
			
			System.out.println("Player Weapon: " + playerWeapon);
			System.out.println("Player HP: " + playerHP);
			System.out.println("Possible Damage: " + playerDamage);
			System.out.println("Health Potions Left: " + healLeft);
			
		
		}
		
		else if (role == 2)
		{
			maxPlayerHP = r.nextInt(140);
			maxPlayerDamage = r.nextInt(100);
			
			System.out.println("Class: Mage.");
			playerWeapon = "Staff";
			playerDamage = playerDamage + maxPlayerDamage;
			playerHP = playerHP + maxPlayerHP;
			System.out.println("Player Weapon: " + playerWeapon);
			System.out.println("Player HP: " + playerHP);
			System.out.println("Possible Damage: " + playerDamage);
			System.out.println("Health Potions Left: " + healLeft);
			
		
		}
		
		else if (role == 3)
		{
			maxPlayerHP = r.nextInt(200);
			maxPlayerDamage = r.nextInt(75);
			
			System.out.println("Class: Archer.");
			playerWeapon = "Bow";
			playerDamage = playerDamage + maxPlayerDamage;
			playerHP = playerHP + maxPlayerHP;
			System.out.println("Player Weapon: " + playerWeapon);
			System.out.println("Player HP: " + playerHP);
			System.out.println("Possible Damage: " + playerDamage);
			System.out.println("Health Potions Left: " + healLeft);
		}
		
		else
		{
			System.out.println("Invalid Command");
		}
	}	
	
	public void startUp(){
		
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println(playerName +" You are a man fighting for Nessa. You must rescue her in order for you to successfully finish this mission!");
		System.out.println("But beware of dangerous underground creatures that you may encounter!");
		System.out.println("You need to defeat 3 boss in order for you to sucessfully retrieve her");
		System.out.println("What do you want to do?");
		System.out.println("");
		System.out.println("[1]: Continue Walking");
		System.out.println("[2]: Exit Game");
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.print("Select: ");
		choice = s.nextInt();
		
		if(choice==1)
		{
			firstMonsterWave();		
		}

		else if(choice==2)
		{
			System.out.println("You left the game.");
		}
		
		else
		{
			System.out.println("Invalid Command");
			startUp();
		}
	}
	
	

	public void firstMonsterWave()
	{
		while (monsterCounter > 0)
		{
			monsterCounter--;
			System.out.println("\n------------------------------------------------------------------\n");
			System.out.println("You encountered a " + monsterRandomizer + "!\n");
			System.out.println("Choose:");
			System.out.println("[1:] Fight");
			System.out.print("Select: ");
			choice = s.nextInt();
			System.out.println("\n------------------------------------------------------------------\n");
			
			if(choice==1)
			{
				fight();
			}
			
			else 
			{
				firstMonsterWave();
			}
		}
	}
	
	
	public void fight()
	{
		monsterRandomizer = monster[r.nextInt(monster.length)];
		
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("\t>Your HP: "+ playerHP);

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
		}
		System.out.println("Choose:");
		System.out.println("\n[1:] Attack");
		System.out.println("[2:] Use an item.");
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.print("Select: ");
		choice = s.nextInt();
		
		if(choice==1)
		{
			attack();
		}
		
		else if(choice==2)
		{
			if (healLeft == 0)
			{
				System.out.println("You have used all of your heals!");
				fight();
			}
			heal();
		}
		
		else
		{
			fight();
		}
		
		//USED SO THAT THE MONSTER HP WON'T BE NEGATIVE
		if (monsterHP <= 0) 
		{
			monsterHP = r.nextInt(60);
		}
	}
	
	public void attack()
	{
		int monsterDamage =  r.nextInt(25);
		playerHP = playerHP - monsterDamage;
		
		
		System.out.println("");
		System.out.println("There are " + monsterCounter + " enemies left!");
		System.out.println("You attacked the monster and dealt " + playerDamage + " damage!");
		System.out.println("The monster attacked you for " + monsterDamage);
		monsterHP = monsterHP - playerDamage;
		
		System.out.println("\nMonster HP: " + monsterHP);
		System.out.println("Your HP: " + playerHP);
		System.out.println("Please enter (1) to continue");
		
		if(monsterCounter<=0 && monsterHP <= 0)
		{
			win(); 
		} 
		
		else if(monsterHP > 0)
		{
			fight();
			
			if(playerHP <= 0)
			{ 
				dead(); 
			} 
			
			else if(playerHP>0)
			{
				fight();
			}
		}
		else if(playerHP<=0)
			{ 
				dead(); 
			} 
	}
	
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
		System.out.println("You killed all the monster!");
		System.out.println("The monster dropped a key to the dungeon!");
		System.out.println("You obtained a key!\n\n");
		System.out.println("1: Continue to the dungeon");
		System.out.println("\n------------------------------------------------------------------\n");
		String monsterRandomizer = monster[r.nextInt(monster.length)];
		}
		key = 1;
		
		System.out.print("Select: ");
		
		choice = s.nextInt();
		if(choice==1)
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
		healLeft--;
		playerHP = playerHP + 50;
		System.out.println("You used heal. You have " + healLeft + " left");
		System.out.println("Current HP is " + playerHP);
		fight();
		}
		else 
		{
			System.out.println("You have used all your heal!");
			fight();
			
		}
		
	}
	
	public void firstBossFight()
	{
			
		if(abbadonHP > 0)
		{
			System.out.println("\nYou encountered the first boss Abbadon");
			System.out.println("\n------------------------------------------------------------------\n");
			System.out.println("\t >BOSS FIGHT!");
			System.out.println("\t>Your HP: "+ playerHP);
			System.out.println("\t>Abbadon's HP: " + abbadonHP);
			System.out.println("Choose:");
			System.out.println("[1.] Fight");
			System.out.println("[2.] Heal");
			System.out.println("\n------------------------------------------------------------------\n");
			System.out.print("Select: ");
			choice = s.nextInt();	
			
			
			if (choice == 1)
			{
				bossAttack();
			}
			
			else if (choice == 2)
			{
				healLeft--;
				playerHP = playerHP + 50;
				System.out.println("You have used your heal potion! Your HP is " + playerHP);
				System.out.println("Heals Left: " + healLeft);
				firstBossFight();
			}
			
			else 
			{
				System.out.println("Invalid Command!");
				firstBossFight();
			}
		}
		
		
		else if (abbadonHP <= 0)
		{
			healLeft = healLeft +3;
			System.out.println("\nYou killed Abbadon! You recieved additional 3 heal potions!");
			ending();
		}
	
	}
	
	
	
		
		public void bossAttack()
		{
			if (abbadonHP > 0)
			{
			abbadonHP = abbadonHP - playerDamage;
			playerHP = playerHP - abbadonDamage;
			
			
			System.out.println("\nAbbadon attacked you for " + abbadonDamage + " damage!");
			System.out.println("You attacked Abbadon for " + playerDamage + " damage!");
			
			
			firstBossFight();
			}
			
			
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
