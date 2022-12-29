import java.util.Scanner;

class Game
{
    public String gameName;
    public String companyName;
    public String platforms;
    public double price;
    public int score;
    public String ageRating;
    public Game(String name, String company, String platforms, String age, double price, int score)
    {
        this.gameName = name;
        this.companyName = company;
        this.platforms = platforms;
        this.ageRating = age;
        this.price = price;
        this.score = score;
    }
    public void printOne()
    {
        System.out.println("Name of the game: " + gameName + "\nMade by: " + companyName + "\nPlatforms: " + platforms + "\nAge rating: " + ageRating + "Price: " + price + "$" + "\nMetaCritic Score: " + score + "/100");
    }

    public void InputToProperties(String item)
    {
        String[] info = item.trim().split(";");
        this.gameName = info[0];
        this.companyName = info[1];
        this.platforms = info[2];
        this.ageRating = info[3];
        this.price = Double.parseDouble(info[4]);
        this.score = Integer.parseInt(info[5]);
    }


}
class GameCollection
{
    private Game[] collection;
    private int length;
    public void addGame(Game tag)
    {
        Game[] array = new Game[length + 1];
        for(int i = 0; i < array.length - 1; i++)
        {
            array[i] = collection[i];
        }
        array[length] = tag;
        length++;
        collection = array;
    }
    public void printAllGames()
    {
        for(int i = 0; i < length; i++)
        {
            System.out.println("GAME " + (i+1));
            collection[i].printOne();
        }
    }

}
public class Main {
    public static String getUserInput(String prompt)
    {
        System.out.print(prompt);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine().trim().toLowerCase();
    }
    public static boolean isContinue()
    {
        String userInput = getUserInput("Do you want to add another item? (Y/N)\n");
        return userInput.equalsIgnoreCase("Y");
    }
    public static void main(String[] args)
    {
        Game item = new Game("name","company","platforms","age restriction",0.00,0);
        GameCollection storage = new GameCollection();
        Scanner key = new Scanner(System.in);
        System.out.println("Welcome to the GameShelf.");
        do
        {
            System.out.println("\nTo add the game to the collection, type these properties:\n\nName of the game: (String)\nName of the company the game is made by: (String)\nPlatforms, on which this game is available: (String)\nAge rating of the game: (String)\nPrice of the game: (double)\nGame score on MetaCritic: (int from 1 to 100)\n\nNote: type ';' to move to next property");
            String properties = key.nextLine();
            item.InputToProperties(properties);
            storage.addGame(item);
        }
        while(isContinue());
        storage.printAllGames();
    }
}