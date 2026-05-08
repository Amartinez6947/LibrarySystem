import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true)
        {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search by Title");
            System.out.println("5. Print All Books");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice;

            try
            {
                choice = input.nextInt();
                input.nextLine();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Invalid input.");
                input.nextLine();
                continue;
            }

            switch (choice)
            {
                case 1:

                    try
                    {
                        System.out.print("Enter Book ID: ");
                        int id = input.nextInt();
                        input.nextLine();

                        System.out.print("Enter Title: ");
                        String title = input.nextLine();

                        System.out.print("Enter Author: ");
                        String author = input.nextLine();

                        System.out.print("Enter ISBN: ");
                        String isbn = input.nextLine();

                        System.out.print("Enter Number of Pages: ");
                        int pages = input.nextInt();
                        input.nextLine();

                        Book book = new Book(id, title, author, isbn, pages);

                        inventory.addBook(book);

                        System.out.println("Book added to the library.");
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("Invalid input.");
                        input.nextLine();
                    }

                    break;

                case 2:

                    System.out.print("Enter Book ID to borrow: ");
                    int borrowId = input.nextInt();
                    input.nextLine();

                    if (inventory.borrowBook(borrowId))
                    {
                        System.out.println("Book successfully borrowed.");
                    }
                    else
                    {
                        System.out.println("Book not found or already borrowed.");
                    }

                    break;

                case 3:

                    System.out.print("Enter Book ID to return: ");
                    int returnId = input.nextInt();
                    input.nextLine();

                    if (inventory.returnBook(returnId))
                    {
                        System.out.println("Book successfully returned.");
                    }
                    else
                    {
                        System.out.println("Book is not in borrowed list.");
                    }

                    break;

                case 4:

                    System.out.print("Enter title to search: ");
                    String searchTitle = input.nextLine();

                    inventory.searchByTitle(searchTitle);

                    break;

                case 5:

                    inventory.printAll();

                    break;

                case 6:

                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);

                    break;

                default:

                    System.out.println("Invalid option.");
            }
        }
    }
}
