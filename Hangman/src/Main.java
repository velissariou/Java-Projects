import java.util.Scanner;
import java.util.Arrays;
import java.util.Random; 
public class Main {

	public static void main(String[] args) {
		
		// Αρχικοποίηση μεταβλητών σκορ:
		
		int gamesPlayed = 0;        
		int wonGames = 0;          
		int lostGames = 0;         
		
		
		// Δημιουργία απαραίτητων αντικειμένων:
		
		Random randomGenerator = new Random();    
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		Dictionary dictionary = new Dictionary();
		
		// Βασικός βρόχος του παιχνιδιού:
		
		do 
		{
			
			// Αρχικοποίηση βασικών μεταβλητών (βρέθηκε λέξη, αριθμός μαντεψιών , σωστές και λάθος μαντεψιές):
			
			boolean found = false;       
			int guesses = 8;
			int correctGuesses = 0;
			int wrongGuesses = 0;
			
			// Κύριο μενού που εμφανίζεται στην κονσόλα:
			
			System.out.println();
			System.out.println("MAIN MENU");
			System.out.println("   - Start a new game (N)");
			System.out.println("   - Statistics (S)");
			System.out.println("   - Exit (E)");
			System.out.print("Please enter your choice: ");
			
			// Εφαρμογή των επιλογών χρήστη:
			
			char playersMenuChoice = in.next().toUpperCase().charAt(0) ;
			if(playersMenuChoice == 'S')
			{
				System.out.println();
				System.out.println("You have played " +gamesPlayed +" games so far. You won " +wonGames + " times and lost " +lostGames +" times. ");
			}
			else if(playersMenuChoice == 'E') 
			{
				System.exit(0);
			}
			// Κύριος κώδικας δημιουργίας λέξης και επιλογής γραμμάτων από το χρήστη:
			
			else if(playersMenuChoice == 'N') 
			{
				char[] wantedWord = dictionary.getWord(randomGenerator.nextInt(50)).toCharArray();
				char[] shownWord = new char[wantedWord.length]; 
				int i;
				
				// Μετατροπή της εμφανιζόμενης λέξης σε παύλες, όσες και ο αριθμός των γραμμάτων της λέξης: 
			
				for(i = 0 ; i < wantedWord.length; i++){ 
					
					shownWord[i] = '-' ;
					
				}
				while(!found && wrongGuesses < 8 && playersMenuChoice == 'N' )
				{
					boolean correctGuess = false; // Τοπική μεταβλητή για να γνωρίζουμε τις σωστές μαντεψιές.
					
					System.out.println();
					System.out.println("The word is now: " +new String(shownWord));
					System.out.println("You have " +guesses +" guesses left.");
					System.out.print("Your guess: ");
					char playersInput = in.next().toUpperCase().charAt(0);
					
					if((playersInput < 65 || playersInput > 90) && (playersInput < 97 || playersInput > 122))   // Έλεγχος για δεκτούς χαρακτήρες μέσω κώδικα ASCII.
					{
						System.out.println();
						System.out.println("Your character input is not valid. Please type 'a-z' or 'A-Z'.");
					}else 
					{
						// Έλεγχος για όλα τα γράμματα από το 0 μέχρι το τέλος της λέξης για ισότητα χαρακτήρων και αντικατάσταση αν ίσα:
						
						for(int j = 0; j < shownWord.length; j++) {
							if(playersInput == wantedWord[j]) 
							{
								shownWord[j] = wantedWord[j];
								correctGuess = true;
							}
							
						}
						// Αλλαγή της κατάστασης των μεταβλητών correctGuesses, wrongGuesses και guesses και εμφάνιση μηνυμάτων στο χρήστη για την πρόοδο του παιχνιδιού:
						
						if(correctGuess) 
						{
							System.out.println("The guess is CORRECT!");
							correctGuesses++;
						}
						else
						{
							System.out.println("There are no " +playersInput + "'s in your word.");
							wrongGuesses++;
							guesses--;
						}
						
						// Τέλος παιχνιδιού με νίκη ή ήττα και αντίστοιχο μήνυμα χρήστη:
						
						if(Arrays.equals(shownWord, wantedWord)) 
						{
							System.out.println("Congratulations! You guessed the word : " +new String(shownWord));
							found = true;
							wonGames++;
							System.out.println("You made " +correctGuesses +" correct guesses and " + wrongGuesses + " wrong guesses.");
						}
						
						if(wrongGuesses==8) {
							System.out.println("You lost. ");
							lostGames++;
						}
						gamesPlayed = wonGames + lostGames; // Ενημέρωση μεταβλητής gamesPlayed για την επίλογη μενού "Statistics".
					}
					
				}
			}
			
		}while(true); 
	}
}
