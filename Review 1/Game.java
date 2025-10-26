import java.util.Scanner;

class Game {
    static class Question {
        String question;
        String[] options;
        int correctIndex;

        Question(String question, String[] options, int correctIndex) {
            this.question = question;
            this.options = options;
            this.correctIndex = correctIndex;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        // Questions, options, and answers for each language
    String[] languages = {"English", "French", "Spanish", "German", "Italian", "Hindi", "Chinese", "Japanese"};

        String[][] questions = {
            { // English
                "What is the synonym of 'Happy'?",
                "What is the antonym of 'Big'?",
                "What is the plural of 'Child'?",
                "Which word means 'quick'?",
                "What is the opposite of 'Cold'?"
            },
            { // French
                "What is the French word for 'Apple'?",
                "What does 'Merci' mean?",
                "What is the French word for 'Book'?",
                "What does 'Bonjour' mean?",
                "What is the French word for 'Water'?"
            },
            { // Spanish
                "What is the Spanish word for 'House'?",
                "What is the Spanish word for 'Dog'?",
                "What does 'Hola' mean?",
                "What does 'Gracias' mean?",
                "What is the Spanish word for 'School'?"
            },
            { // German
                "What is the German word for 'Bread'?",
                "What does 'Danke' mean?",
                "What is the German word for 'Car'?",
                "What does 'Guten Morgen' mean?",
                "What is the German word for 'Cat'?"
            },
            { // Italian
                "What is the Italian word for 'Cheese'?",
                "What does 'Ciao' mean?",
                "What is the Italian word for 'Friend'?",
                "What does 'Grazie' mean?",
                "What is the Italian word for 'Window'?"
            },
            { // Hindi
                "What is the Hindi word for 'Water'?",
                "What does 'Namaste' mean?",
                "What is the Hindi word for 'Book'?",
                "What does 'Dhanyavaad' mean?",
                "What is the Hindi word for 'Mother'?"
            },
            { // Chinese
                "What is the Chinese word for 'Hello'?",
                "What does 'Xièxiè' mean?",
                "What is the Chinese word for 'Book'?",
                "What does 'Zàijiàn' mean?",
                "What is the Chinese word for 'Water'?"
            },
            { // Japanese
                "What is the Japanese word for 'Thank you'?",
                "What does 'Konnichiwa' mean?",
                "What is the Japanese word for 'Book'?",
                "What does 'Sayonara' mean?",
                "What is the Japanese word for 'Cat'?"
            }
        };

        String[][][] options = {
            { // English
                {"Sad", "Joyful", "Angry", "Tired"},
                {"Large", "Huge", "Small", "Tall"},
                {"Children", "Childs", "Child", "Childes"},
                {"Slow", "Quick", "Late", "Old"},
                {"Hot", "Warm", "Cool", "Cold"}
            },
            { // French
                {"Pomme", "Banane", "Orange", "Raisin"},
                {"Hello", "Goodbye", "Thank you", "Please"},
                {"Livre", "Stylo", "Table", "Chaise"},
                {"Goodbye", "Hello", "Please", "Thanks"},
                {"Eau", "Lait", "Pain", "Vin"}
            },
            { // Spanish
                {"Perro", "Casa", "Libro", "Coche"},
                {"Perro", "Gato", "Casa", "Libro"},
                {"Goodbye", "Please", "Hello", "Thanks"},
                {"Hello", "Thank you", "Goodbye", "Please"},
                {"Escuela", "Casa", "Libro", "Coche"}
            },
            { // German
                {"Brot", "Milch", "Käse", "Apfel"},
                {"Hello", "Thank you", "Goodbye", "Please"},
                {"Auto", "Haus", "Buch", "Katze"},
                {"Good morning", "Good night", "Thank you", "Hello"},
                {"Hund", "Katze", "Vogel", "Fisch"}
            },
            { // Italian
                {"Formaggio", "Pane", "Latte", "Vino"},
                {"Hello", "Goodbye", "Thank you", "Please"},
                {"Amico", "Libro", "Casa", "Gatto"},
                {"Hello", "Thank you", "Goodbye", "Please"},
                {"Finestra", "Porta", "Sedia", "Tavolo"}
            },
            { // Hindi
                {"Pani", "Doodh", "Kitab", "Maa"},
                {"Hello", "Thank you", "Goodbye", "Please"},
                {"Kitab", "Pustak", "Kursi", "Mez"},
                {"Thank you", "Hello", "Goodbye", "Please"},
                {"Maa", "Pita", "Bhai", "Behen"}
            },
            { // Chinese
                {"Nǐ hǎo", "Xièxiè", "Zàijiàn", "Shuǐ"},
                {"Hello", "Thank you", "Goodbye", "Please"},
                {"Shū", "Shuǐ", "Nǐ hǎo", "Zàijiàn"},
                {"Goodbye", "Hello", "Thank you", "Please"},
                {"Shuǐ", "Shū", "Nǐ hǎo", "Xièxiè"}
            },
            { // Japanese
                {"Arigatou", "Konnichiwa", "Sayonara", "Neko"},
                {"Hello", "Thank you", "Goodbye", "Please"},
                {"Hon", "Neko", "Sakana", "Mizu"},
                {"Goodbye", "Hello", "Thank you", "Please"},
                {"Neko", "Inu", "Hon", "Mizu"}
            }
        };

        int[][] correctIndexes = {
            {1, 2, 0, 1, 0}, // English
            {0, 2, 0, 1, 0}, // French
            {1, 0, 2, 1, 0}, // Spanish
            {0, 1, 0, 0, 1}, // German
            {0, 1, 0, 1, 0}, // Italian
            {0, 1, 0, 0, 0}, // Hindi
            {0, 1, 0, 0, 0}, // Chinese
            {0, 1, 0, 0, 0}  // Japanese
        };

        // Language selection

        System.out.println("Welcome to the Language Learning Game!");
        System.out.println("Choose a language to learn by entering its number:");
        for (int i = 0; i < languages.length; i++) {
            System.out.println((i + 1) + ". " + languages[i]);
        }
        System.out.print("Enter your choice (1-" + languages.length + "): ");
        int langIndex = -1;
        try {
            langIndex = sc.nextInt() - 1;
        } catch (Exception e) {
            System.out.println("Invalid input. Exiting...");
            sc.close();
            return;
        }
        if (langIndex < 0 || langIndex >= languages.length) {
            System.out.println("Invalid choice. Exiting...");
            sc.close();
            return;
        }
        sc.nextLine(); // consume newline

        System.out.println("\nYou selected: " + (langIndex + 1) + ". " + languages[langIndex] + "\n");

        int score = 0;


        // Quiz loop
        for (int i = 0; i < questions[langIndex].length; i++) {
            System.out.println("\nQ" + (i + 1) + ". " + questions[langIndex][i]);
            for (int j = 0; j < options[langIndex][i].length; j++) {
                System.out.println((j + 1) + ". " + options[langIndex][i][j]);
            }
            System.out.print("Your answer (1-" + options[langIndex][i].length + "): ");
            int answer = sc.nextInt();
            if (answer - 1 == correctIndexes[langIndex][i]) {
                System.out.println(" Correct!");
                score++;
            } else {
                System.out.println(" Wrong! Correct answer: " + options[langIndex][i][correctIndexes[langIndex][i]]);
            }
        }

        // Final Score
        System.out.println("\n===== Quiz Finished =====");
        System.out.println("Language: " + languages[langIndex]);
        System.out.println("Your Score: " + score + "/" + questions[langIndex].length);

        if (score == questions[langIndex].length) {
            System.out.println(" Excellent! Perfect score!");
        } else if (score >= questions[langIndex].length / 2) {
            System.out.println(" Good job! Keep practicing!");
        } else {
            System.out.println(" Don’t worry, practice makes perfect!");
        }
        sc.close();
    }
}
