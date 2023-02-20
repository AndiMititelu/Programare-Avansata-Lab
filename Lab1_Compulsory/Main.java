public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    String[] language = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
    int n = (int) (Math.random() * 1_000_000);
    n = n * 3;
    String binary = "10101";
    String hex = "ff";
    int nr_1 = Integer.parseInt(binary, 2); //radix = 2 because we have binary
    int nr_2 = Integer.parseInt(hex, 16);
    n = n + nr_1 + nr_2;
    n = n * 6;
    while(n > 9)
    {
        n = n / 10 + n % 10;
    }

    System.out.println("Willy-nilly, this semester I will learn: " + language[n]);


    }

}