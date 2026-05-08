import java.util.ArrayList;

public class Inventory
{
    private ArrayList<Book> books;
    private ArrayList<Book> borrowedBooks;

    public Inventory()
    {
        books = new ArrayList<>();
        borrowedBooks = new ArrayList<>();
    }

    public void addBook(Book book)
    {
        books.add(book);
    }

    public boolean borrowBook(int id)
    {
        for (Book book : books)
        {
            if (book.getId() == id)
            {
                borrowedBooks.add(book);
                books.remove(book);
                return true;
            }
        }

        return false;
    }

    public boolean returnBook(int id)
    {
        for (Book book : borrowedBooks)
        {
            if (book.getId() == id)
            {
                books.add(book);
                borrowedBooks.remove(book);
                return true;
            }
        }

        return false;
    }

    public void printAll()
    {
        if (books.isEmpty())
        {
            System.out.println("No books in library.");
        }
        else
        {
            for (Book book : books)
            {
                book.printBookInfo();
            }
        }
    }

    public void searchByTitle(String title)
    {
        boolean found = false;

        for (Book book : books)
        {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase()))
            {
                book.printBookInfo();
                found = true;
            }
        }

        if (!found)
        {
            System.out.println("No matching book found.");
        }
    }
