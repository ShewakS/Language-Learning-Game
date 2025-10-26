import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.List;
import java.util.ArrayList;

class ViewScores {
    public static void main(String[] args) {
        try {
            MongoClient mongoClient = MongoClients.create("mongodb+srv://user:user@cluster0.pxqfzjc.mongodb.net/");
            MongoDatabase database = mongoClient.getDatabase("LanguageLearningGame");
            MongoCollection<Document> scoresCollection = database.getCollection("Scores");
            
            List<Document> scores = new ArrayList<>();
            scoresCollection.find().into(scores);
            
            if (scores.isEmpty()) {
                System.out.println("No scores found in database.");
            } else {
                System.out.println("===== All Player Scores =====");
                for (Document score : scores) {
                    System.out.println("Player: " + score.getString("playerName"));
                    System.out.println("Language: " + score.getString("language"));
                    System.out.println("Score: " + score.getInteger("score") + "/" + score.getInteger("totalQuestions"));
                    System.out.println("Percentage: " + String.format("%.1f", score.getDouble("percentage")) + "%");
                    System.out.println("Date: " + score.getDate("date"));
                    System.out.println("---");
                }
            }
            
            mongoClient.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}