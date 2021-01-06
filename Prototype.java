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
		playerHP, playerMana, playerArmor, skillChoice;
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
	// NOT IMPLEMENTED YET boolean running = true; 
		
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
			playerSkills = "\n\t[1]Fireball \n\t[2]Thunderbolt \n\t[3]Hinokami Kagura";
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
	
	public void warriorSkills ()
	{
		
		System.out.println("Choose a skill! " + "\n\t[1]Punch \n\t[2]Blade Surge \n\t[3]Hail of Blades");
		
		System.out.print("Choose: ");
		skillChoice = s.nextInt();
		if (skillChoice == 1)
		{
			System.out.println("\nYou used Punch to damage the enemy for 5 HP!");
			monsterHP = monsterHP - 5;
			firstMonsterWave();
		}
		
		
		
		else if (skillChoice == 2)
		{
			if (playerMana >= 10)
			{
			playerMana = playerMana -10;
			System.out.println("\nYou used Blade Surge to damage the enemy for 15 HP!");
			
			monsterHP = monsterHP - 15;
			firstMonsterWave();
			}
			
			else 
			{
				System.out.println("\nYou need 10 mana to cast this skill! You currently have " + playerMana + " mana");
				System.out.println("Press Enter to continue");
				choice = s.nextLine();
				firstMonsterWave();
			}
		}
		
		
		else if (skillChoice == 3)
		{
			if (playerMana >= 40)
			{
			playerMana = playerMana - 40;
			System.out.println("\nYou used Hail of Blades to damage the enemy for 100HP!");
			monsterHP = monsterHP - 100;
			firstMonsterWave();
			}
			else 
			{
				System.out.println("\nYou need 40 mana to cast this skill! You currently have " + playerMana + " mana");
				System.out.println("Press Enter to continue");
				choice = s.nextLine();
				firstMonsterWave();
			}
		}
	}
	
	public void mageSkills()
	{
		System.out.println("Choose a skill " + "\n\t[1]Fireball \n\t[2]Thunderbolt \n\t[3]Hinokami Kagura");
		System.out.print("Select: ");
		skillChoice = s.nextInt();
		if (skillChoice == 1)
		{
			if (playerMana >= 5)
			{
			playerMana = playerMana - 5;
			System.out.println("You used Fireball to damage the enemy for 10 HP!");
			monsterHP = monsterHP - 10;
			firstMonsterWave();
			}
			
			else 
			{
				System.out.println("You need 5 mana to cast this skill! You currently have " + playerMana + " mana");
				System.out.println("Press Enter to continue");
				choice = s.nextLine();
				firstMonsterWave();
			}
		}
		
		
		else if (skillChoice == 2)
		{
			if (playerMana >= 40)
			{
			playerMana = playerMana -40;
			System.out.println("You used Thunder Bolt to damage the enemy for 20HP!");
			
			monsterHP = monsterHP - 20;
			firstMonsterWave();
			}
			
			else 
			{
				System.out.println("You need 40 mana to cast this skill! You currently have " + playerMana + " mana");
				System.out.println("Press Enter to continue");
				choice = s.nextLine();
				firstMonsterWave();
			}
		}
		
		
		else if (skillChoice == 3)
		{
			if (playerMana >= 100)
			{
			playerMana = playerMana - 100;
			System.out.println("You used Hinokami Kagura to damage the enemy for 150HP!");
			monsterHP = monsterHP - 150;
			firstMonsterWave();
		
			}
			else 
			{
				System.out.println("You need 100 mana to cast this skill! You currently have " + playerMana + " mana");
				System.out.println("Press Enter to continue");
				choice = s.nextLine();
				firstMonsterWave();
			}
		
		}
	}
	
	public void archerSkills()
	{
		System.out.println("Choose a skill " + "\n\\t[1]Arrow Shot \\n\\t[2]Sectral Arrow \\n\\t[3]Enchanted Arrow");
		
		if (skillChoice == 1)
		{
			
			System.out.println("You used Arrow Shot to damage the enemy for 10HP!");
			monsterHP = monsterHP - 10;
			firstMonsterWave();
		}
		
		
		else if (skillChoice == 2)
		{
			if (playerMana >= 25)
			{
			playerMana = playerMana -25;
			System.out.println("You used Spectral Arrow to damage the enemy for 20HP!");
			
			monsterHP = monsterHP - 20;
			firstMonsterWave();
			}
			
			else 
			{
				System.out.println("You need 25 mana to cast this skill! You currently have " + playerMana + " mana");
				firstMonsterWave();
			}
		}
		
		
		else if (skillChoice == 3)
		{
			if (playerMana >= 70)
			{
			playerMana = playerMana - 70;
			System.out.println("You used Enchanted Arrow to damage the enemy for 120 HP!");
			monsterHP = monsterHP - 120;
			firstMonsterWave();
			}
			else 
			{
				System.out.println("You need 70 mana to cast this skill! You currently have " + playerMana + " mana");
				System.out.println("Press Enter to continue");
				choice = s.nextLine();
				firstMonsterWave();
			}
		
		}
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
				monsterHP = r.nextInt(20);
				if (monsterHP <= 9)
				{
					monsterHP = 10;
				}
				
				 monsterDamage = r.nextInt(10);
				if (monsterDamage <= 4)
				{
					monsterDamage = 5;
				}
			
				System.out.println("\tMonster HP: " + monsterHP + "\n\tMonster Damage: " + monsterDamage);
				monsterFight();
			}
			//SKELETON STATS
			else if (monsterRandomizer.equals("Skeleton"))
			{
				 monsterHP = r.nextInt(20);
				if (monsterHP <= 9)
				{
					monsterHP = 10;
				}
				
				 monsterDamage = r.nextInt(10);
				if (monsterDamage <= 4)
				{
					monsterDamage = 5;
				}
				
				System.out.println("\tMonster HP: " + monsterHP + "\n\tMonster Damage: " + monsterDamage);
				monsterFight();
			}
			//WRAITH STATS
			else if (monsterRandomizer.equals("Wraith"))
			{
				 monsterHP = r.nextInt(20);
				if (monsterHP <= 9)
				{
					monsterHP = 10;
				}
				
				 monsterDamage = r.nextInt(10);
				if (monsterDamage <= 4)
				{
					monsterDamage = 5;
				}
				
				System.out.println("\tMonster HP: " + monsterHP + "\n\tMonster Damage: " + monsterDamage);
				monsterFight();
			}
			//ZOMBIE STATS
			else if (monsterRandomizer.equals("Zombie"))
			{
				 monsterHP = r.nextInt(20);
				if (monsterHP <= 9)
				{
					monsterHP = 10;
				}
				
				 monsterDamage = r.nextInt(10);
				if (monsterDamage <= 4)
				{
					monsterDamage = 5;
				}
				
				System.out.println("\tMonster HP: " + monsterHP + "\n\tMonster Damage: " + monsterDamage);
				monsterFight();
			}
			//VAMPIRE STATS
			else if (monsterRandomizer.equals("Vampire"))
			{
				 monsterHP = r.nextInt(20);
				if (monsterHP <= 9)
				{
					monsterHP = 10;
				}
				
				 monsterDamage = r.nextInt(10);
				if (monsterDamage <= 4)
				{
					monsterDamage = 5;
				}
				
				System.out.println("\tMonster HP: " + monsterHP + "\n\tMonster Damage: " + monsterDamage);
				monsterFight();
			}
			
			if (playerHP > 0 && monsterCounter == 0)
			{
				firstBossFight();
			}
		}
	}
	
	
	public void monsterFight()
	{
		System.out.println(">Your HP: " + playerHP);
		
	
		
		System.out.println("Choose:");
		System.out.println("\n\t[1]: Basic Attack");
		System.out.println("\t[2]: Use an item.");
		System.out.println("\t[3]: Use Skills.");
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.print("Select: ");
		choice = s.nextLine();
		
		if(choice.equals("1"))
		{
			monsterHP = monsterHP - playerDamage;
			playerHP = playerHP - monsterDamage;
			
			System.out.println("You attacked a monster for " + playerDamage + " damage. While the monster attacked you for " + monsterDamage + " damage.");
			firstMonsterWave();
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
		
		else if (choice.equals("3"))
		{
			if (role.equals("1"))
			{
				warriorSkills();
			}
			
			else if (role.equals("2"))
			{
				mageSkills();			
			}
			
			else if (role.equals("3"))
			{
				archerSkills();
			}
			
			else 
			{
				System.out.println("Invalid Command!");
				monsterFight();
			}
		}
		
		else
		{
			System.out.println("Invalid Command!");
			monsterFight();
		}
	}
	
	
	//UPDATED ATTACK PUBLIC VOID
	public void monsterBattleMode()
	{
	
		
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
			while (abbadonHP > 0)
			{
			System.out.println("\nYou encountered the first boss Abbadon");
			System.out.println("\n------------------------------------------------------------------\n");
			System.out.println("\t >BOSS FIGHT!");
			System.out.println("\t>Your HP: "+ playerHP);
			System.out.println("\t>Abbadon's HP: " + abbadonHP);
			System.out.println("Choose:");
			System.out.println("[1.] Basic Attack");
			System.out.println("[2.] Heal");
			System.out.println("[3.] Use Skills.");
			System.out.println("\n------------------------------------------------------------------\n");
			System.out.print("Select: ");
			int choices = s.nextInt();
			
			
			if (choices == 1)
			{
				abbadonHP = abbadonHP - playerDamage;
				playerHP = playerHP - abbadonDamage;
				
				System.out.println("You used basic Attack to deal " + playerDamage + " damage to abbadon!");
				firstBossFight();
				
			}
			
			else if (choices == 2)
			{
				healLeft--;
				heal();
			}
			
			else if (choices == 3)
			{
				if (role.equals("1"))
				{
					System.out.println("Choose a skill! " + "\n\t[1]Punch \n\t[2]Blade Surge \n\t[3]Hail of Blades");
					
					System.out.print("Choose: ");
					skillChoice = s.nextInt();
					if (skillChoice == 1)
					{
						System.out.println("\nYou used Punch to damage Abbadon for 5 HP!");
						monsterHP = monsterHP - 5;
						firstBossFight();
					}
					
					
					
					else if (skillChoice == 2)
					{
						if (playerMana >= 10)
						{
						playerMana = playerMana -10;
						System.out.println("\nYou used Blade Surge to damage Abbadon for 15 HP!");
						
						monsterHP = monsterHP - 15;
						firstBossFight();
						}
						
						else 
						{
							System.out.println("\nYou need 10 mana to cast this skill! You currently have " + playerMana + " mana");
							System.out.println("Press Enter to continue");
							choice = s.nextLine();
							firstBossFight();
						}
					}
					
					
					else if (skillChoice == 3)
					{
						if (playerMana >= 40)
						{
						playerMana = playerMana - 40;
						System.out.println("\nYou used Hail of Blades to damage Abbadon for 100HP!");
						monsterHP = monsterHP - 100;
						firstBossFight();
						}
						else 
						{
							System.out.println("\nYou need 40 mana to cast this skill! You currently have " + playerMana + " mana");
							System.out.println("Press Enter to continue");
							choice = s.nextLine();
							firstBossFight();
						}
					}
				}
				
				else if (role.equals("2"))
				{
					mageSkills();			
				}
				
				else if (role.equals("3"))
				{
					archerSkills();
				}
			}
			
				else 
				{
					System.out.println("Invalid Command!");
					firstBossFight();
				}
			
			
			
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
