import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

class GameWithScores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] languages = {"English", "French", "Spanish", "German", "Italian", "Hindi", "Chinese", "Japanese"};

        System.out.println("Welcome to the Language Learning Game!");
        System.out.print("Enter your name: ");
        String playerName = sc.nextLine();
        
        System.out.println("Choose a language to learn by entering its number:");
        for (int i = 0; i < languages.length; i++) {
            System.out.println((i + 1) + ". " + languages[i]);
        }
        System.out.print("Enter your choice (1-" + languages.length + "): ");
        
        int langIndex = sc.nextInt() - 1;
        if (langIndex < 0 || langIndex >= languages.length) {
            System.out.println("Invalid choice. Exiting...");
            sc.close();
            return;
        }

        System.out.println("\nYou selected: " + languages[langIndex]);
        
        try {
            MongoClient mongoClient = MongoClients.create("mongodb+srv://user:user@cluster0.pxqfzjc.mongodb.net/");
            MongoDatabase database = mongoClient.getDatabase("LanguageLearningGame");
            MongoCollection<Document> questionsCollection = database.getCollection("Questions");
            MongoCollection<Document> scoresCollection = database.getCollection("Scores");
            
            List<Document> questions = new ArrayList<>();
            questionsCollection.find(new Document("language", languages[langIndex])).into(questions);
            
            if (questions.isEmpty()) {
                System.out.println("No questions found for " + languages[langIndex]);
                mongoClient.close();
                sc.close();
                return;
            }
            
            int score = 0;
            for (int i = 0; i < questions.size(); i++) {
                Document q = questions.get(i);
                System.out.println("\nQ" + (i + 1) + ". " + q.getString("question"));
                List<String> opts = q.getList("options", String.class);
                for (int j = 0; j < opts.size(); j++) {
                    System.out.println((j + 1) + ". " + opts.get(j));
                }
                System.out.print("Your answer (1-" + opts.size() + "): ");
                int answer = sc.nextInt();
                if (answer - 1 == q.getInteger("correctIndex")) {
                    System.out.println(" Correct!");
                    score++;
                } else {
                    System.out.println(" Wrong! Correct answer: " + opts.get(q.getInteger("correctIndex")));
                }
            }
            
            // Save score to database
            Document scoreDoc = new Document("playerName", playerName)
                .append("language", languages[langIndex])
                .append("score", score)
                .append("totalQuestions", questions.size())
                .append("percentage", (score * 100.0 / questions.size()))
                .append("date", new Date());
            
            scoresCollection.insertOne(scoreDoc);
            
            System.out.println("\n===== Quiz Finished =====");
            System.out.println("Player: " + playerName);
            System.out.println("Language: " + languages[langIndex]);
            System.out.println("Your Score: " + score + "/" + questions.size());
            System.out.println("Percentage: " + String.format("%.1f", (score * 100.0 / questions.size())) + "%");
            System.out.println("Score saved to database!");
            
            if (score == questions.size()) {
                System.out.println(" Excellent! Perfect score!");
            } else if (score >= questions.size() / 2) {
                System.out.println(" Good job! Keep practicing!");
            } else {
                System.out.println(" Don't worry, practice makes perfect!");
            }
            
            mongoClient.close();
        } catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
        
        sc.close();
    }
}