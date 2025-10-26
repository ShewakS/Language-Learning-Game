import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.Arrays;

class CompleteDBSeeder {
    public static void main(String[] args) {
        try {
            MongoClient mongoClient = MongoClients.create("mongodb+srv://user:user@cluster0.pxqfzjc.mongodb.net/");
            MongoDatabase database = mongoClient.getDatabase("LanguageLearningGame");
            MongoCollection<Document> collection = database.getCollection("Questions");
            
            collection.deleteMany(new Document());
            
            // English - 5 questions
            collection.insertOne(new Document("language", "English").append("question", "What is the synonym of 'Happy'?").append("options", Arrays.asList("Sad", "Joyful", "Angry", "Tired")).append("correctIndex", 1));
            collection.insertOne(new Document("language", "English").append("question", "What is the antonym of 'Big'?").append("options", Arrays.asList("Large", "Huge", "Small", "Tall")).append("correctIndex", 2));
            collection.insertOne(new Document("language", "English").append("question", "What is the plural of 'Child'?").append("options", Arrays.asList("Children", "Childs", "Child", "Childes")).append("correctIndex", 0));
            collection.insertOne(new Document("language", "English").append("question", "Which word means 'quick'?").append("options", Arrays.asList("Slow", "Quick", "Late", "Old")).append("correctIndex", 1));
            collection.insertOne(new Document("language", "English").append("question", "What is the opposite of 'Cold'?").append("options", Arrays.asList("Hot", "Warm", "Cool", "Cold")).append("correctIndex", 0));
            
            // French - 5 questions
            collection.insertOne(new Document("language", "French").append("question", "What is the French word for 'Apple'?").append("options", Arrays.asList("Pomme", "Banane", "Orange", "Raisin")).append("correctIndex", 0));
            collection.insertOne(new Document("language", "French").append("question", "What does 'Merci' mean?").append("options", Arrays.asList("Hello", "Goodbye", "Thank you", "Please")).append("correctIndex", 2));
            collection.insertOne(new Document("language", "French").append("question", "What is the French word for 'Book'?").append("options", Arrays.asList("Livre", "Stylo", "Table", "Chaise")).append("correctIndex", 0));
            collection.insertOne(new Document("language", "French").append("question", "What does 'Bonjour' mean?").append("options", Arrays.asList("Goodbye", "Hello", "Please", "Thanks")).append("correctIndex", 1));
            collection.insertOne(new Document("language", "French").append("question", "What is the French word for 'Water'?").append("options", Arrays.asList("Eau", "Lait", "Pain", "Vin")).append("correctIndex", 0));
            
            // Spanish - 5 questions
            collection.insertOne(new Document("language", "Spanish").append("question", "What is the Spanish word for 'House'?").append("options", Arrays.asList("Perro", "Casa", "Libro", "Coche")).append("correctIndex", 1));
            collection.insertOne(new Document("language", "Spanish").append("question", "What is the Spanish word for 'Dog'?").append("options", Arrays.asList("Perro", "Gato", "Casa", "Libro")).append("correctIndex", 0));
            collection.insertOne(new Document("language", "Spanish").append("question", "What does 'Hola' mean?").append("options", Arrays.asList("Goodbye", "Please", "Hello", "Thanks")).append("correctIndex", 2));
            collection.insertOne(new Document("language", "Spanish").append("question", "What does 'Gracias' mean?").append("options", Arrays.asList("Hello", "Thank you", "Goodbye", "Please")).append("correctIndex", 1));
            collection.insertOne(new Document("language", "Spanish").append("question", "What is the Spanish word for 'School'?").append("options", Arrays.asList("Escuela", "Casa", "Libro", "Coche")).append("correctIndex", 0));
            
            // German - 5 questions
            collection.insertOne(new Document("language", "German").append("question", "What is the German word for 'Bread'?").append("options", Arrays.asList("Brot", "Milch", "Käse", "Apfel")).append("correctIndex", 0));
            collection.insertOne(new Document("language", "German").append("question", "What does 'Danke' mean?").append("options", Arrays.asList("Hello", "Thank you", "Goodbye", "Please")).append("correctIndex", 1));
            collection.insertOne(new Document("language", "German").append("question", "What is the German word for 'Car'?").append("options", Arrays.asList("Auto", "Haus", "Buch", "Katze")).append("correctIndex", 0));
            collection.insertOne(new Document("language", "German").append("question", "What does 'Guten Morgen' mean?").append("options", Arrays.asList("Good morning", "Good night", "Thank you", "Hello")).append("correctIndex", 0));
            collection.insertOne(new Document("language", "German").append("question", "What is the German word for 'Cat'?").append("options", Arrays.asList("Hund", "Katze", "Vogel", "Fisch")).append("correctIndex", 1));
            
            // Italian - 5 questions
            collection.insertOne(new Document("language", "Italian").append("question", "What is the Italian word for 'Cheese'?").append("options", Arrays.asList("Formaggio", "Pane", "Latte", "Vino")).append("correctIndex", 0));
            collection.insertOne(new Document("language", "Italian").append("question", "What does 'Ciao' mean?").append("options", Arrays.asList("Hello", "Goodbye", "Thank you", "Please")).append("correctIndex", 1));
            collection.insertOne(new Document("language", "Italian").append("question", "What is the Italian word for 'Friend'?").append("options", Arrays.asList("Amico", "Libro", "Casa", "Gatto")).append("correctIndex", 0));
            collection.insertOne(new Document("language", "Italian").append("question", "What does 'Grazie' mean?").append("options", Arrays.asList("Hello", "Thank you", "Goodbye", "Please")).append("correctIndex", 1));
            collection.insertOne(new Document("language", "Italian").append("question", "What is the Italian word for 'Window'?").append("options", Arrays.asList("Finestra", "Porta", "Sedia", "Tavolo")).append("correctIndex", 0));
            
            // Hindi - 5 questions
            collection.insertOne(new Document("language", "Hindi").append("question", "What is the Hindi word for 'Water'?").append("options", Arrays.asList("Pani", "Doodh", "Kitab", "Maa")).append("correctIndex", 0));
            collection.insertOne(new Document("language", "Hindi").append("question", "What does 'Namaste' mean?").append("options", Arrays.asList("Hello", "Thank you", "Goodbye", "Please")).append("correctIndex", 1));
            collection.insertOne(new Document("language", "Hindi").append("question", "What is the Hindi word for 'Book'?").append("options", Arrays.asList("Kitab", "Pustak", "Kursi", "Mez")).append("correctIndex", 0));
            collection.insertOne(new Document("language", "Hindi").append("question", "What does 'Dhanyavaad' mean?").append("options", Arrays.asList("Thank you", "Hello", "Goodbye", "Please")).append("correctIndex", 0));
            collection.insertOne(new Document("language", "Hindi").append("question", "What is the Hindi word for 'Mother'?").append("options", Arrays.asList("Maa", "Pita", "Bhai", "Behen")).append("correctIndex", 0));
            
            // Chinese - 5 questions
            collection.insertOne(new Document("language", "Chinese").append("question", "What is the Chinese word for 'Hello'?").append("options", Arrays.asList("Nǐ hǎo", "Xièxiè", "Zàijiàn", "Shuǐ")).append("correctIndex", 0));
            collection.insertOne(new Document("language", "Chinese").append("question", "What does 'Xièxiè' mean?").append("options", Arrays.asList("Hello", "Thank you", "Goodbye", "Please")).append("correctIndex", 1));
            collection.insertOne(new Document("language", "Chinese").append("question", "What is the Chinese word for 'Book'?").append("options", Arrays.asList("Shū", "Shuǐ", "Nǐ hǎo", "Zàijiàn")).append("correctIndex", 0));
            collection.insertOne(new Document("language", "Chinese").append("question", "What does 'Zàijiàn' mean?").append("options", Arrays.asList("Goodbye", "Hello", "Thank you", "Please")).append("correctIndex", 0));
            collection.insertOne(new Document("language", "Chinese").append("question", "What is the Chinese word for 'Water'?").append("options", Arrays.asList("Shuǐ", "Shū", "Nǐ hǎo", "Xièxiè")).append("correctIndex", 0));
            
            // Japanese - 5 questions
            collection.insertOne(new Document("language", "Japanese").append("question", "What is the Japanese word for 'Thank you'?").append("options", Arrays.asList("Arigatou", "Konnichiwa", "Sayonara", "Neko")).append("correctIndex", 0));
            collection.insertOne(new Document("language", "Japanese").append("question", "What does 'Konnichiwa' mean?").append("options", Arrays.asList("Hello", "Thank you", "Goodbye", "Please")).append("correctIndex", 1));
            collection.insertOne(new Document("language", "Japanese").append("question", "What is the Japanese word for 'Book'?").append("options", Arrays.asList("Hon", "Neko", "Sakana", "Mizu")).append("correctIndex", 0));
            collection.insertOne(new Document("language", "Japanese").append("question", "What does 'Sayonara' mean?").append("options", Arrays.asList("Goodbye", "Hello", "Thank you", "Please")).append("correctIndex", 0));
            collection.insertOne(new Document("language", "Japanese").append("question", "What is the Japanese word for 'Cat'?").append("options", Arrays.asList("Neko", "Inu", "Hon", "Mizu")).append("correctIndex", 0));
            
            System.out.println("All 8 languages with 5 questions each populated successfully!");
            mongoClient.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}